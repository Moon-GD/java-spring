package MoonGD.hellospring.repository;

import MoonGD.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    // test variables
    String FIRST_NAME = "first member";
    String SECOND_NAME = "second member";

    Member member1 = new Member();
    Member member2 = new Member();



    @AfterEach
    public void clear() {
        memoryMemberRepository.clear();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("first member");

        memoryMemberRepository.save(member);

        Member returnedMember = memoryMemberRepository.findById(member.getId()).get();


        // assertions

        // 1️⃣ junit test
        // Assertions.assertEquals(member, returnedMember);

        // 2️⃣ assertj.core test
        assertThat(member).isEqualTo(returnedMember);
    }

    @Test
    public void findByName() {
        member1.setName(FIRST_NAME);
        member2.setName(SECOND_NAME);

        memoryMemberRepository.save(member1);
        memoryMemberRepository.save(member2);

        Member firstReturnedMember = memoryMemberRepository.findByName(FIRST_NAME).get();
        Member secondReturendMember = memoryMemberRepository.findByName(SECOND_NAME).get();

        // assertions
        assertThat(firstReturnedMember).isEqualTo(member1);
        assertThat(secondReturendMember).isEqualTo(member2);
    }

    @Test
    public void findAll() {
        member1.setName(FIRST_NAME);
        member2.setName(SECOND_NAME);

        memoryMemberRepository.save(member1);
        memoryMemberRepository.save(member2);

        List<Member> memberList = memoryMemberRepository.findAll();

        // assertions
        assertThat(memberList.size()).isEqualTo(2);
    }
}
