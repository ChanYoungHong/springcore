package spring.mrkim.corespring.springcore;

import spring.mrkim.corespring.springcore.discount.FixDiscountPolicy;
import spring.mrkim.corespring.springcore.order.Order;
import spring.mrkim.corespring.springcore.order.OrderService;
import spring.mrkim.corespring.springcore.order.OrderServiceImpl;
import spring.mrkim.corespring.springcore.repository.MemoryMemberRepository;
import spring.mrkim.corespring.springcore.service.MemberService;
import spring.mrkim.corespring.springcore.service.MemberServiceImpl;

// 객체의 생성과 연결은 AppConfig가 담당한다.
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
