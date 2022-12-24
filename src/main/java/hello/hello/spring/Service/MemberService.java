package hello.hello.spring.Service;

import hello.hello.spring.Domain.Member;
import hello.hello.spring.Repository.MemberRepository;
import hello.hello.spring.Repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     */
    public Long join(Member member){
        validateDuplicateMember(member); //중복 검사

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이름입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /**
     * id를 통한 회원 조회
     */

    public Optional<Member> findOne(Member member){
        return memberRepository.findById(member.getId());
    }
}
