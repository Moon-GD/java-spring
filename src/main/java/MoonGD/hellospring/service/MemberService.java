package MoonGD.hellospring.service;

import MoonGD.hellospring.domain.Member;
import MoonGD.hellospring.repository.MemberRepository;
import MoonGD.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        // 중복 이름 방지
        repository.findByName(member.getName())
                .ifPresent(duplicatedMember -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });

        repository.save(member);

        return member.getId();
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return repository.findAll();
    }

    /**
     * ID로 회원 조회
     */
    public Optional<Member> findMemberById(Long targetId) {
        return repository.findById(targetId);
    }

    /**
     * 이름으로 회원 조회
     */
    public Optional<Member> findMemberByName(String targetName) {
        return repository.findByName(targetName);
    }
}
