package project.mdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.mdm.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 이메일로 사용자 조회
    Optional<Member> findByEmail(String email);

    // 아이디로 사용자 조회
    Optional<Member> findByUsername(String username);

}
