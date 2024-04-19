package minho.backboard.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import minho.backboard.domain.Board;

import java.util.List;
import java.util.Optional;

public class BoardRepository implements IBoardRepository{

    private final EntityManager em;

    public BoardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Board saveBoard(Board board) {
        em.persist(board);
        return board;
    }

    @Override
    public void deleteBoard(Long id) {
        em.createQuery("DELETE FROM Board p WHERE p.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Board modifyBoard(Long id) {
        Board board = em.find(Board.class, id);
        if (board != null) {
            em.merge(board);
        }
        return null;
    }

    @Override
    public Optional<Board> findById(Long id) {
        Board board = em.find(Board.class, id);
        return Optional.ofNullable(board);
    }

    @Override
    public Optional<Board> findByTitle(String title) {
        List<Board> result = em.createQuery("select m from Board m where m.title = :title", Board.class)
                .setParameter("title", title)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public Optional<Board> findByUserId(String userid) {
        List<Board> result = em.createQuery("select m from Board m where m.userid = :userid", Board.class)
                .setParameter("userid", userid)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Board> findAllBoard() {
        return em.createQuery("select m from Board m", Board.class)
                .getResultList();
    }
}
