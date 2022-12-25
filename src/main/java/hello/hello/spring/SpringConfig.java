package hello.hello.spring;

import hello.hello.spring.Repository.MemberRepository;
import hello.hello.spring.Repository.MemoryMemberRepository;
import hello.hello.spring.Service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
