package xyz.mon0mon.core;

import xyz.mon0mon.core.discount.DiscountPolicy;
import xyz.mon0mon.core.discount.FixDiscountPolicy;
import xyz.mon0mon.core.discount.RateDiscountPolicy;
import xyz.mon0mon.core.member.MemberService;
import xyz.mon0mon.core.member.MemberServiceImpl;
import xyz.mon0mon.core.member.MemoryMemberRepository;
import xyz.mon0mon.core.order.OrderService;
import xyz.mon0mon.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    private static MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }

    private DiscountPolicy getDiscountPolicy() {
        return new FixDiscountPolicy();
//        return new RateDiscountPolicy();
    }
}
