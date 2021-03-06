package spring.mrkim.corespring.springcore.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.mrkim.corespring.springcore.AppConfig;
import spring.mrkim.corespring.springcore.member.Grade;
import spring.mrkim.corespring.springcore.member.Member;
import spring.mrkim.corespring.springcore.service.MemberService;
import spring.mrkim.corespring.springcore.service.MemberServiceImpl;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "hi", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}