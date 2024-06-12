package xyz.mon0mon.core;

import xyz.mon0mon.core.member.*;
import xyz.mon0mon.core.order.Order;
import xyz.mon0mon.core.order.OrderService;
import xyz.mon0mon.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberRepository memberRepository = new MemoryMemberRepository();
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order order = orderService.createOrder(memberId, memberA.getName(), 10000);

        System.out.println("order = " + order);
        System.out.println(order.calculatePrice());
    }
}
