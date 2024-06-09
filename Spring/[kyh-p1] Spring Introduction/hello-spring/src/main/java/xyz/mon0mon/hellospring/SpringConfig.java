package xyz.mon0mon.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.mon0mon.hellospring.repository.JdbcMemberRepository;
import xyz.mon0mon.hellospring.repository.JdbcTemplateMemberRepository;
import xyz.mon0mon.hellospring.repository.MemberRepository;
import xyz.mon0mon.hellospring.repository.MemoryMemberRepository;
import xyz.mon0mon.hellospring.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
