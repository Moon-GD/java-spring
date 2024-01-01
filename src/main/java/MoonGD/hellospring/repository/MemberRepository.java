package MoonGD.hellospring.repository;

import MoonGD.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    // 저장
    Member save(Member member);

    // id로 member 객체 조회
    Optional<Member> findById(Long id);

    // name으로 member 객체 조회
    Optional<Member> findByName(String name);

    // 모든 member 객체 조회
    List<Member> findAll();
}
