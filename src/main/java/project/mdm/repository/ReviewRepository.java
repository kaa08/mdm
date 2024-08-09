package project.mdm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.mdm.entity.Board;
import project.mdm.entity.Member;
import project.mdm.entity.Review;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    // 후기글 조회
    @Query(value = "SELECT r FROM Review r JOIN FETCH r.member WHERE r.id = :reviewID")
    Optional<Review> findByIdWithMember(Long reviewID);

    // 후기글 목록 조회
    @Query(value = "SELECT r FROM Review r JOIN FETCH r.member")
    Page<Review> findAllWithMember(Pageable pageable);

    // 후기글 제목 검색
    @Query(value = "SELECT r FROM Review r JOIN FETCH r.member WHERE r.title LIKE %:title%")
    Page<Review> findAllTitleContaining(String title, Pageable pageable);

    // 후기글 내용 검색
    @Query(value = "SELECT r FROM Review r JOIN FETCH r.member WHERE r.content LIKE %:content%")
    Page<Review> findAllContentContaining(String content, Pageable pageable);

    // 후기글 작성자 검색
    @Query(value = "SELECT r FROM Review r JOIN FETCH r.member WHERE r.member.username LIKE %:username%")
    Page<Review> findAllUsernameContaining(String username, Pageable pageable);

    // 사용자 별 후기 글 조회
    Page<Review> findAllByMember(Pageable pageable, Member member);
}
