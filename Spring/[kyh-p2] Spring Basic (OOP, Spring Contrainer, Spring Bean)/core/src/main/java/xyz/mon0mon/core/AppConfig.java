package xyz.mon0mon.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import xyz.mon0mon.core.discount.DiscountPolicy;
import xyz.mon0mon.core.discount.FixDiscountPolicy;
import xyz.mon0mon.core.discount.RateDiscountPolicy;
import xyz.mon0mon.core.member.MemberRepository;
import xyz.mon0mon.core.member.MemberService;
import xyz.mon0mon.core.member.MemberServiceImpl;
import xyz.mon0mon.core.member.MemoryMemberRepository;
import xyz.mon0mon.core.order.OrderService;
import xyz.mon0mon.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    /**
     * @Bean memberService -> new MemoryMemberRepository()
     * @Bean orderService -> new MemoryMemberRepository()
     * 이러면 MemoryMemberRepository가 다수 호출 됨에 따라 싱글톤이 아닌게 되는 것인지?
     */


    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    @Primary
    /**
     * public static MemoryMemberRepository memberRepository()
     * static이 붙을 경우 Spring에서 Singleton 임을 보장할 수 없음
     * @see <a href="https://www.inflearn.com/questions/1139482">Inflearn</a>
     * @see <a href="https://www.inflearn.com/questions/1085291">Inflearn</a>
     */
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // call AppConfig.memberRepository
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
//        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
