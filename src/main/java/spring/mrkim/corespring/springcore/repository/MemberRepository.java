package spring.mrkim.corespring.springcore.repository;

import spring.mrkim.corespring.springcore.member.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
