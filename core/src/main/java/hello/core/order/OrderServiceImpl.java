package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    //테스트 용도
    @Getter
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; // 할인 정책을 인터페이스로 변경하여 유연성을 높임

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = rateDiscountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원 정보를 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인 정책을 사용하여 할인 금액 계산

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
