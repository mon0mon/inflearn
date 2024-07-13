package xyz.mon0mon.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import xyz.mon0mon.core.discount.FixDiscountPolicy;
import xyz.mon0mon.core.member.Grade;
import xyz.mon0mon.core.member.Member;
import xyz.mon0mon.core.member.MemberRepository;
import xyz.mon0mon.core.member.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    @Test
    void createOrder() {
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice())
                  .isEqualTo(1000);
    }
}