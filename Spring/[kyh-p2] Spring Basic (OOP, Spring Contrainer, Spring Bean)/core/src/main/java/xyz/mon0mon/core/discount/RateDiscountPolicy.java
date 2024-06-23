package xyz.mon0mon.core.discount;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import xyz.mon0mon.core.member.Grade;
import xyz.mon0mon.core.member.Member;

@Primary
@Component
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }

        return 0;
    }
}
