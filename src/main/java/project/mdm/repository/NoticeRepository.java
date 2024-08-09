package project.mdm.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.mdm.entity.Notice;

import java.util.Optional;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    // 공지사항 조회
    @Query(value = "SELECT n FROM Notice n JOIN FETCH n.member WHERE n.id = :noticeID")
    Optional<Notice> findByIdWithMember(Long noticeID);

    // 공지사항 목록 조회
    @Query(value = "SELECT n FROM Notice n JOIN FETCH n.member")
    Page<Notice> findAllWithMember(Pageable pageable);

    // 공지사항 제목 검색
    @Query(value = "SELECT n FROM Notice n JOIN FETCH n.member WHERE n.title LIKE %:title%")
    Page<Notice> findAllTitleContaining(String title, Pageable pageable);

    // 공지사항 내용 검색
    @Query(value = "SELECT n FROM Notice n JOIN FETCH n.member WHERE n.content LIKE %:content%")
    Page<Notice> findAllContentContaining(String content, Pageable pageable);

    // 공지사항 작성자 검색
    @Query(value = "SELECT n FROM Notice n JOIN FETCH n.member WHERE n.member.username LIKE %:username%")
    Page<Notice> findAllUsernameContaining(String username, Pageable pageable);

}
