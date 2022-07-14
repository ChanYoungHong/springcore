package spring.mrkim.corespring.springcore.repository;

import spring.mrkim.corespring.springcore.member.Member;

public class DbMemberRepository implements MemberRepository{
    @Override
    public void save(Member member) {

    }

    @Override
    public Member findById(Long memberId) {
        return null;
    }
}
