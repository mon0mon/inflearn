package xyz.mon0mon.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.mon0mon.core.discount.DiscountPolicy;
import xyz.mon0mon.core.discount.FixDiscountPolicy;
import xyz.mon0mon.core.discount.RateDiscountPolicy;
import xyz.mon0mon.core.member.MemberService;
import xyz.mon0mon.core.member.MemberServiceImpl;
import xyz.mon0mon.core.member.MemoryMemberRepository;
import xyz.mon0mon.core.order.OrderService;
import xyz.mon0mon.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
