package xyz.mon0mon.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xyz.mon0mon.core.AppConfig;
import xyz.mon0mon.core.member.*;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

//    @Test
//    void fieldInjectionTest() {
//        OrderServiceImpl orderService = new OrderServiceImpl();
//        // FieldInjection의 경우 순수한 자바로 생성할 때 오류 발생
//        // 의존 관계를 주입할 수 없기 때문
//        // 이 경우 setter와 getter를 별도로 만들어줘야함
//        orderService.createOrder(1L, "itemA", 10000);
//    }
}
