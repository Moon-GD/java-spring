package MoonGD.hellospring;

import MoonGD.hellospring.repository.MemberRepository;
import MoonGD.hellospring.repository.MemoryMemberRepository;
import MoonGD.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService getMemberService() {
        return new MemberService(getMemoryMemberRepository());
    }

    @Bean
    public MemberRepository getMemoryMemberRepository() {
        return new MemoryMemberRepository();
    }
}
