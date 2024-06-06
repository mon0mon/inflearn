package xyz.mon0mon.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.mon0mon.hellospring.repository.MemberRepository;
import xyz.mon0mon.hellospring.repository.MemoryMemberRepository;
import xyz.mon0mon.hellospring.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
