package project.mdm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.mdm.entity.Board;
import project.mdm.entity.Inquiry;

import java.util.Optional;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

    // 게시글 상세 조회, @BatchSize : Comments와 Files는 필요할 때 in 절로 가져옴
    @Query(value = "SELECT i FROM Inquiry i JOIN FETCH i.member WHERE i.id = :inquiryID")
    Optional<Inquiry> findByIdWithMember(Long inquiryID);

    // 첫 페이징 화면("/")
    @Query(value = "SELECT i FROM Inquiry i JOIN FETCH i.member")
    Page<Inquiry> findAllWithMember(Pageable pageable);

    @Query(value = "SELECT i FROM Inquiry i JOIN FETCH i.member WHERE i.title LIKE %:title%")
    Page<Inquiry> findAllTitleContaining(String title, Pageable pageable);

    // 내용 검색
    @Query(value = "SELECT i FROM Inquiry i JOIN FETCH i.member WHERE i.contents LIKE %:contents%")
    Page<Inquiry> findAllContentContaining(String contents, Pageable pageable);

    // 작성자 검색
    @Query(value = "SELECT i FROM Inquiry i JOIN FETCH i.member WHERE i.member.username LIKE %:username%")
    Page<Inquiry> findAllUsernameContaining(String username, Pageable pageable);

}
