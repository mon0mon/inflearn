package xyz.mon0mon.core.order;

import xyz.mon0mon.core.discount.DiscountPolicy;
import xyz.mon0mon.core.discount.FixDiscountPolicy;
import xyz.mon0mon.core.member.Member;
import xyz.mon0mon.core.member.MemberRepository;
import xyz.mon0mon.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


}
