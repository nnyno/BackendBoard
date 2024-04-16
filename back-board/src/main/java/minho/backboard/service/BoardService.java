package minho.backboard.service;

import minho.backboard.domain.Board;
import minho.backboard.domain.Member;
import minho.backboard.repository.BoardRepository;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    /**
     * 글 작성
     */
    public Long write(Board board) {
        boardRepository.saveBoard(board);
        return board.getId();
    }

    /**
     * 글 삭제
     */
    public void delete(Long id) {
        boardRepository.deleteBoard(id);
    }

    /**
     * 전체 글 조회
     */
    public List<Board> findBoard() {
        return boardRepository.findAllBoard();
    }

    public Optional<Board> findOneBoard(Long id) {
        return boardRepository.findById(id);
    }
}
