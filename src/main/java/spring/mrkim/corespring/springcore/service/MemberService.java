package spring.mrkim.corespring.springcore.service;

import spring.mrkim.corespring.springcore.member.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
