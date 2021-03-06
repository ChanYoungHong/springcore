package spring.mrkim.corespring.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.mrkim.corespring.springcore.discount.DiscountPolicy;
import spring.mrkim.corespring.springcore.discount.RateDiscountPolicy;
import spring.mrkim.corespring.springcore.order.OrderService;
import spring.mrkim.corespring.springcore.order.OrderServiceImpl;
import spring.mrkim.corespring.springcore.repository.MemberRepository;
import spring.mrkim.corespring.springcore.repository.MemoryMemberRepository;
import spring.mrkim.corespring.springcore.service.MemberService;
import spring.mrkim.corespring.springcore.service.MemberServiceImpl;

// 객체의 생성과 연결은 AppConfig가 담당한다.
@Configuration
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository();

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
