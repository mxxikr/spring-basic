package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    // 생성자를 통해 의존성 주입을 받음
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; // memberRepository는 생성자 통해서 구현체가 주입됨
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member); // 다형성에 의해 MemoryMemberRepository가 호출됨
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}