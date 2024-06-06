package xyz.mon0mon.hellospring.service;

import xyz.mon0mon.hellospring.domain.Member;
import xyz.mon0mon.hellospring.repository.MemberRepository;
import xyz.mon0mon.hellospring.repository.MemoryMemberRepository;

import java.util.*;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        validateDuplicatedMember(member); // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();
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
