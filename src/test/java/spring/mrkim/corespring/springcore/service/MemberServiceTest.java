package spring.mrkim.corespring.springcore.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.mrkim.corespring.springcore.member.Grade;
import spring.mrkim.corespring.springcore.member.Member;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given
        Member member = new Member(1L, "hi", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(findMember);

    }

    @Test
    void findMember() {
    }
}