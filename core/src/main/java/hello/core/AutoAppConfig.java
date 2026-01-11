package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class),
        basePackages = "hello.core")
public class AutoAppConfig {
//    @Bean(name = "memoryMemberRepository") // 수동 빈 등록이 우선권을 가짐
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}