package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //추상화(interface)에만 의존하도록 (구현체는 AppConfig에서 지정)
    private final MemberRepository memberRepository;

    //생성자를 통해 객체 주입받음->생성자 주입
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

