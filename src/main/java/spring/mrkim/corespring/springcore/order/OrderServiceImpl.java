package spring.mrkim.corespring.springcore.order;

import spring.mrkim.corespring.springcore.discount.DiscountPolicy;
import spring.mrkim.corespring.springcore.member.Member;
import spring.mrkim.corespring.springcore.repository.MemberRepository;


public class OrderServiceImpl implements OrderService {

    // 인터페이스만 의존하게 된다.
    private final MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


}
