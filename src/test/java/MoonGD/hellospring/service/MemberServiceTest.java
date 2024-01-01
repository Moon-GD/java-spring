package MoonGD.hellospring.service;

import MoonGD.hellospring.domain.Member;
import MoonGD.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @BeforeEach
    public void injectRepositoryToService() {
        memberService = new MemberService(memoryMemberRepository);
    }

    @Test
    void joinSuccess() {
        // given
        Member member1 = new Member();
        member1.setName("first member");

        // when
        Long returnedId = memberService.join(member1);

        // then
        assertThat(memberService.findMemberById(returnedId).get()).isEqualTo(member1);
    }

    @Test
    void joinFail() {
        // given
        Member member1 = new Member();
        member1.setName("same name member");

        Member member2 = new Member();
        member2.setName("same name member");

        // when
        memberService.join(member1);

        // then
        IllegalStateException error = Assertions.assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });

        assertThat(error.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findMemberById() {
    }

    @Test
    void findMemberByName() {
    }
}