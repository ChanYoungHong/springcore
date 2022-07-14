package spring.mrkim.corespring.springcore.service;

import spring.mrkim.corespring.springcore.member.Member;
import spring.mrkim.corespring.springcore.repository.MemberRepository;
import spring.mrkim.corespring.springcore.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
