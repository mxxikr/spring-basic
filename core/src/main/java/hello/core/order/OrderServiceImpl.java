package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    // 일반 메서드 주입
//    private MemberRepository memberRepository;
//    private DiscountPolicy discountPolicy; // 할인 정책을 인터페이스로 변경하여 유연성을 높임

    // 수정자 주입
//    private MemberRepository memberRepository;
//    private DiscountPolicy discountPolicy; // 할인 정책을 인터페이스로 변경하여 유연성을 높임

    // 필드 주업
//    @Autowired
//    private MemberRepository memberRepository;
//    @Autowired
//    private DiscountPolicy discountPolicy; // 할인 정책을 인터페이스로 변경하여 유연성을 높임

    // 생성자 주입
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; // 할인 정책을 인터페이스로 변경하여 유연성을 높임

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 수정자 주입
//    @Autowired(required = false)
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired(required = false)
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    // 일반 메서드 주입
//    @Autowired
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원 정보를 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인 정책을 사용하여 할인 금액 계산

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
