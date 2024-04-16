package minho.backboard.repository;

import jakarta.persistence.EntityManager;
import minho.backboard.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class DBMemberRepositoryTest {

    @Autowired
    MemberRepository repository;

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        member.setUserid("userid1");
        member.setPassword("pw1");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        member1.setUserid("userid1");
        member1.setPassword("pw1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        member2.setUserid("userid2");
        member2.setPassword("pw2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findByUserId() {
        Member member1 = new Member();
        member1.setName("spring1");
        member1.setUserid("userid1");
        member1.setPassword("pw1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        member2.setUserid("userid2");
        member2.setPassword("pw2");
        repository.save(member2);

        Member result = repository.findByUserId("userid1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findByPassWord() {
        Member member1 = new Member();
        member1.setName("spring1");
        member1.setUserid("userid1");
        member1.setPassword("pw1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        member2.setUserid("userid2");
        member2.setPassword("pw2");
        repository.save(member2);

        Member result = repository.findByPassWord("pw1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        List<Member> list = repository.findAll();
        Member member1 = new Member();
        member1.setName("spring1");
        member1.setUserid("userid1");
        member1.setPassword("pw1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        member2.setUserid("userid2");
        member2.setPassword("pw2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(list.size() + 2);
    }
}
