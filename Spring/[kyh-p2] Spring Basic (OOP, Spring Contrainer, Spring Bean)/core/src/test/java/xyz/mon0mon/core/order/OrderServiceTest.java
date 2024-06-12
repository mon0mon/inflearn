package xyz.mon0mon.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import xyz.mon0mon.core.member.*;

public class OrderServiceTest {
    MemberRepository memberRepository = new MemoryMemberRepository();
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
