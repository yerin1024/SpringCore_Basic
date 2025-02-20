package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    //추상화(interface)에만 의존하도록 (구현체는 AppConfig에서 지정)
    private final MemberRepository memberRepository;

    @Autowired //@Autowired를 생성자에 붙여주면 자동으로 의존관계 주입을 해줌
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //@Bean으로 생성할 때 공유되는지 테스트 용도 (memberServiceImpl과 orderServiceImpl비교)
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

