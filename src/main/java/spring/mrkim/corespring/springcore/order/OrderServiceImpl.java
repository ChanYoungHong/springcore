package spring.mrkim.corespring.springcore.order;

import spring.mrkim.corespring.springcore.discount.DiscountPolicy;
import spring.mrkim.corespring.springcore.discount.FixDiscountPolicy;
import spring.mrkim.corespring.springcore.discount.RateDiscountPolicy;
import spring.mrkim.corespring.springcore.member.Member;
import spring.mrkim.corespring.springcore.repository.MemberRepository;
import spring.mrkim.corespring.springcore.repository.MemoryMemberRepository;


public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public OrderServiceImpl(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


}
