package hello.hello.spring;

import hello.hello.spring.Repository.JdbcTemplateMemberRepository;
import hello.hello.spring.Repository.MemberRepository;
import hello.hello.spring.Repository.MemoryMemberRepository;
import hello.hello.spring.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Bean
    MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
