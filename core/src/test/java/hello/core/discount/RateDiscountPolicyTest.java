package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP); // VIP 등급의 회원 생성

        // when
        int discount = discountPolicy.discount(member, 10000); // 10000원에 대해 10% 할인

        // then
        Assertions.assertThat(discount).isEqualTo(1000); // 10% 할인 적용 확인
    }

    @Test
    @DisplayName("VIP가 아닌 회원은 할인이 적용되지 않아야 한다")
    void vip_x() {
        // given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC); // BASIC 등급의 회원 생성

        // when
        int discount = discountPolicy.discount(member, 10000); // 10000원에 대해 할인 시도

        // then
        Assertions.assertThat(discount).isEqualTo(0); // 할인이 적용되지 않아야 함
    }
}