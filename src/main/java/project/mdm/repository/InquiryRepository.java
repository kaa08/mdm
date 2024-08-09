package project.mdm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.mdm.entity.Board;
import project.mdm.entity.Inquiry;
import project.mdm.entity.Member;

import java.util.Optional;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

    // 문희하기 상세 조회
    @Query(value = "SELECT i FROM Inquiry i JOIN FETCH i.member WHERE i.id = :inquiryID")
    Optional<Inquiry> findByIdWithMember(Long inquiryID);

    // 문의하기 전체 조회
    @Query(value = "SELECT i FROM Inquiry i JOIN FETCH i.member")
    Page<Inquiry> findAllWithMember(Pageable pageable);

    // 문의하기 제목 검색
    @Query(value = "SELECT i FROM Inquiry i JOIN FETCH i.member WHERE i.title LIKE %:title%")
    Page<Inquiry> findAllTitleContaining(String title, Pageable pageable);

    // 문의하기 내용 검색
    @Query(value = "SELECT i FROM Inquiry i JOIN FETCH i.member WHERE i.contents LIKE %:contents%")
    Page<Inquiry> findAllContentContaining(String contents, Pageable pageable);

    // 문의하기 작성자 검색
    @Query(value = "SELECT i FROM Inquiry i JOIN FETCH i.member WHERE i.member.username LIKE %:username%")
    Page<Inquiry> findAllUsernameContaining(String username, Pageable pageable);

    // 사용자 별 문의하기 조회
    Page<Inquiry> findAllByMember(Member member, Pageable pageable);

}
