package xyz.mon0mon.core;

import xyz.mon0mon.core.discount.FixDiscountPolicy;
import xyz.mon0mon.core.member.MemberService;
import xyz.mon0mon.core.member.MemberServiceImpl;
import xyz.mon0mon.core.member.MemoryMemberRepository;
import xyz.mon0mon.core.order.OrderService;
import xyz.mon0mon.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
