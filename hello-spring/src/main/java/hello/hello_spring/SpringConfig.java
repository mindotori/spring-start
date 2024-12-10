package hello.hello_spring;

import hello.hello_spring.repository.*;
import hello.hello_spring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean //memberService가 스프링 빈에 등록이 되게 함
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean //memberRepository를 스프링 빈에 등록
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
       // return new JdbcMemberRepository(dataSource);
       // return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }

}
