package minho.backboard.service;

import minho.backboard.domain.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardServiceTest {
    @Autowired
    BoardService boardService;

    @Test
    void write() {
        Board board = new Board();
        board.setUserid("minid");
        board.setTitle("title1");
        board.setText("text1");

        Long saveBoard = boardService.write(board);
        Board findboard = boardService.findOneBoard(saveBoard).get();
        assertThat(board.getId()).isEqualTo(findboard.getId());
    }

}