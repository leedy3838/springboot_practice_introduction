package hello.hello.spring.Repository;

import hello.hello.spring.Domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository memory = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        memory.clear();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        memory.save(member);

        Member result = memory.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        memory.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memory.save(member2);

        Member result = memory.findByName("spring1").get();
        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        memory.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memory.save(member2);

        List<Member> result = memory.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
