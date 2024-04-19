package minho.backboard.repository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import minho.backboard.domain.Board;
import minho.backboard.service.BoardService;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @Test
    public void saveBoard() {
        Board board = new Board();
        board.setUserid("minid");
        board.setTitle("title1");
        board.setText("text1");

        boardRepository.saveBoard(board);

        Board result = boardRepository.findById(board.getId()).get();
        assertThat(board).isEqualTo(result);
    }

    @Test
    public void findByUserId() {
        Board board1 = new Board();
        board1.setUserid("minid1");
        board1.setTitle("title1");
        board1.setText("text1");
        boardRepository.saveBoard(board1);

        Board board2 = new Board();
        board2.setUserid("minid1");
        board2.setTitle("title2");
        board2.setText("text1");
        boardRepository.saveBoard(board2);

        Board result = boardRepository.findById(board2.getId()).get();

        assertThat(result).isEqualTo(board2);
    }

    @Test
    public void findByTitle() {
        List<Board> list = boardRepository.findAllBoard();
        Board board1 = new Board();
        board1.setUserid("minid");
        board1.setTitle("title1");
        board1.setText("text1");
        boardRepository.saveBoard(board1);

        Board board3 = new Board();
        board3.setUserid("minid2");
        board3.setTitle("title2");
        board3.setText("text1");
        boardRepository.saveBoard(board3);

        Board result = boardRepository.findByTitle(board3.getTitle()).get();

        assertThat(result).isEqualTo(board3);
    }

    @Test
    public void findAllBoard() {
        List<Board> list = boardRepository.findAllBoard();
        Board board1 = new Board();
        board1.setUserid("minid");
        board1.setTitle("title1");
        board1.setText("text1");
        boardRepository.saveBoard(board1);

        Board board2 = new Board();
        board2.setUserid("minid");
        board2.setTitle("title1");
        board2.setText("text1");
        boardRepository.saveBoard(board2);

        List<Board> result = boardRepository.findAllBoard();

        assertThat(result.size()).isEqualTo(list.size() + 2);
    }

    @Test
    public void delete() {
        Board board1 = new Board();
        board1.setUserid("minid");
        board1.setTitle("title1");
        board1.setText("text1");
        boardRepository.saveBoard(board1);

        Board result = boardRepository.findByTitle(board1.getTitle()).get();

        boardRepository.deleteBoard(result.getId());
        assertThat(boardRepository.findByTitle(board1.getTitle()).isEmpty()).isEqualTo(true);
    }
}