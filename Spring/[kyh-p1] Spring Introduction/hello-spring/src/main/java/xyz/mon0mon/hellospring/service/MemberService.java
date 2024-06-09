package xyz.mon0mon.hellospring.service;

import org.springframework.transaction.annotation.Transactional;
import xyz.mon0mon.hellospring.domain.Member;
import xyz.mon0mon.hellospring.repository.MemberRepository;

import java.util.*;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        long start = System.currentTimeMillis();

        try {
            validateDuplicatedMember(member); // 중복 회원 검증
            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("timeMs = " + timeMs);
        }
    }

    private void validateDuplicatedMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
