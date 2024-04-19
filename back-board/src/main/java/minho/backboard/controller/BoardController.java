package minho.backboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import minho.backboard.domain.Board;
import minho.backboard.repository.BoardRepository;
import minho.backboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/members/board")
    public  String board(Model model) {
        List<Board> boards = boardService.findBoard();
        model.addAttribute("boards", boards);
        return "members/board";
    }

    @GetMapping("/write")
    public String createboard() {
        return "boards/createBoardForm";
    }

    @PostMapping("members/board")
    public String create(BoardForm form, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Board board = new Board();
        board.setUserid(session.getAttribute("userid").toString());
        board.setText(form.getText());
        board.setTitle(form.getTitle());

        boardService.write(board);

        return "redirect:/";
    }

    @GetMapping("/board/context")
    public String getBoardDetail(@RequestParam("id") Long id, Model model) {
        Optional<Board> board = boardService.findOneBoard(id);
        board.ifPresent(boards -> model.addAttribute("boards", board.get()));
        return "boards/context";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        System.out.println("pass");
        boardService.delete(id);
        System.out.println("pass2");

        return "redirect:/";
    }


//    @GetMapping("/{id}/modify")
//    public String update(@RequestParam("id") Long id, Model model) {
//        Optional<Board> board = boardService.findOneBoard(id);
//        board.ifPresent(boards -> model.addAttribute("boards", board.get()));
//        return "boards/update";
//    }

//    @PostMapping("/{id}/modify")
//    public ResponseEntity<String> updateBoard(
//            @PathVariable("id") Long id,
//            @RequestParam("title") String title,
//            @RequestParam("text") String text) {
//        boardService.update(id, title, text);
//        return ResponseEntity.ok("게시글이 수정되었습니다.");
//    }
}

