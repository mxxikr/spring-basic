package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy; // 할인 정책을 인터페이스로 변경하여 유연성을 높임

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원 정보를 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인 정책을 사용하여 할인 금액 계산

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
