package spring.mrkim.corespring.springcore;

import spring.mrkim.corespring.springcore.order.Order;
import spring.mrkim.corespring.springcore.order.OrderService;
import spring.mrkim.corespring.springcore.order.OrderServiceImpl;
import spring.mrkim.corespring.springcore.member.Grade;
import spring.mrkim.corespring.springcore.member.Member;
import spring.mrkim.corespring.springcore.service.MemberService;
import spring.mrkim.corespring.springcore.service.MemberServiceImpl;

public class OrderApp {


    public static void main(String[] args) {

        MemberService memberSerivce = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberSerivce.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }

}
