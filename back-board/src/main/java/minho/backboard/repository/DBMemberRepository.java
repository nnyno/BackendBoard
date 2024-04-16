package minho.backboard.repository;

import jakarta.persistence.EntityManager;
import minho.backboard.domain.Member;

import java.util.List;
import java.util.Optional;

public class DBMemberRepository implements MemberRepository{

    private final EntityManager em;

    public DBMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByUserId(String userid) {
        List<Member> result = em.createQuery("select m from Member m where m.userid = :userid", Member.class)
                .setParameter("userid", userid)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByPassWord(String password) {
        List<Member> result = em.createQuery("select m from Member m where m.password = :password", Member.class)
                .setParameter("password", password)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
