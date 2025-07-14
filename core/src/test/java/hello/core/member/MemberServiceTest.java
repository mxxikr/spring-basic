package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach // 테스트 실행 전에 무조건 실행
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService(); // AppConfig를 통해 MemberService를 가져옴
    }
//    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // then
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // when
        Assertions.assertThat(member).isEqualTo(findMember); // 검증
    }
}