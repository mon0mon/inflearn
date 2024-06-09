package xyz.mon0mon.hellospring;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.JdbcClient;
import xyz.mon0mon.hellospring.repository.*;
import xyz.mon0mon.hellospring.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;
    private JdbcClient jdbcClient;
    private EntityManager em;

    @Autowired
    public SpringConfig(DataSource dataSource, JdbcClient jdbcClient, EntityManager em) {
        this.dataSource = dataSource;
        this.jdbcClient = jdbcClient;
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JdbcClientMemberRepository(jdbcClient);
        return new JpaMemberRepository(em);
    }
}
