package xyz.mon0mon.core;

import xyz.mon0mon.core.member.Grade;
import xyz.mon0mon.core.member.Member;
import xyz.mon0mon.core.member.MemberService;
import xyz.mon0mon.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + memberA.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
