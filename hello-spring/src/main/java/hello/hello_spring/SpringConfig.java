package hello.hello_spring;

import hello.hello_spring.aop.TimeTraceAop;
import hello.hello_spring.repository.*;
import hello.hello_spring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean //memberService가 스프링 빈에 등록이 되게 함
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean //스프링 빈에 aop 직접 등록 - 이 방식 대신에 @Component 스캔 가능
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }

  //  @Bean //memberRepository를 스프링 빈에 등록
   // public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
       // return new JdbcMemberRepository(dataSource);
       // return new JdbcTemplateMemberRepository(dataSource);
      //  return new JpaMemberRepository(em);

   // }

}
