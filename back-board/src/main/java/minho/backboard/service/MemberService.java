package minho.backboard.service;

import minho.backboard.domain.Member;
import minho.backboard.repository.DBMemberRepository;
import minho.backboard.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public  String join(Member member) {
        validateDuplicateMember(member);//중복회원 검증
        memberRepository.save(member);
        return member.getUserid();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByUserId(member.getUserid())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 아이디입니다.");

                });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(String userid) {
        return memberRepository.findByUserId(userid);
    }
}
