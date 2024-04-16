package minho.backboard.service;

import jakarta.persistence.EntityManager;
import minho.backboard.domain.Member;
import minho.backboard.repository.DBMemberRepository;
import minho.backboard.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;


    @Test
    void 회원가입() {
        Member member = new Member();
        member.setName("spring");
        member.setUserid("userid1");
        member.setPassword("pw1");

        String saveUserId = memberService.join(member);

        Member findMember = memberService.findOne(saveUserId).get();
        assertThat(member.getUserid()).isEqualTo(findMember.getUserid());
    }

    @Test
    public void joinexception() {
        Member member1 = new Member();
        member1.setName("spring");
        member1.setUserid("userid1");
        member1.setPassword("pw1");

        Member member2 = new Member();
        member2.setName("spring");
        member2.setUserid("userid1");
        member2.setPassword("pw1");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 아이디입니다.");
    }

    @Test
    public void findOne() {
        Optional<Member> result = memberService.findOne("minid");
        System.out.println(result.get().getUserid());
    }
}