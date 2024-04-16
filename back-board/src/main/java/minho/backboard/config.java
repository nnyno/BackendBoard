package minho.backboard;

import jakarta.persistence.EntityManager;
import minho.backboard.repository.BoardRepository;
import minho.backboard.repository.DBMemberRepository;
import minho.backboard.repository.MemberRepository;
import minho.backboard.service.BoardService;
import minho.backboard.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {

    private EntityManager em;

    @Autowired
    public config(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new DBMemberRepository(em);
    }

    @Bean
    public BoardService boardService() {
        return new BoardService(boardRepository());
    }

    @Bean
    public BoardRepository boardRepository() {
        return new BoardRepository(em);
    }
}
