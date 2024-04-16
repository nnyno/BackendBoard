package minho.backboard.repository;

import minho.backboard.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    Optional<Member> findByUserId(String userid);
    Optional<Member> findByPassWord(String password);
    List<Member> findAll();

}
