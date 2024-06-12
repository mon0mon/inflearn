package xyz.mon0mon.core.discount;

import xyz.mon0mon.core.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
