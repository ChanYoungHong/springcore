package spring.mrkim.corespring.springcore.discount;

import spring.mrkim.corespring.springcore.member.Member;

public interface DiscountPolicy {

    // 할인 대상 금액
    int discount(Member member, int price);
}
