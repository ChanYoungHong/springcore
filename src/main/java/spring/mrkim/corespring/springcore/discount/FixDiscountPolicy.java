package spring.mrkim.corespring.springcore.discount;

import spring.mrkim.corespring.springcore.member.Grade;
import spring.mrkim.corespring.springcore.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;


    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
