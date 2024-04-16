package minho.backboard.repository;

import minho.backboard.domain.Board;
import minho.backboard.domain.Member;

import java.util.List;
import java.util.Optional;

public interface IBoardRepository {
    Board saveBoard(Board board);
    void deleteBoard(Long id);
    Board modifyBoard(Board board);
    Optional<Board> findById(Long id);
    List<Board> findByTitle(String title);
    Optional<Board> findByUserId(String userid);
    List<Board> findAllBoard();

}
