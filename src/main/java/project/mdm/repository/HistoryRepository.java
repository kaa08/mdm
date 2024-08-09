package project.mdm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import project.mdm.entity.Board;
import project.mdm.entity.History;
import project.mdm.entity.Member;

public interface HistoryRepository extends JpaRepository<History, Long> {

    // 사용자 별 과거기록 조회
    Page<History> findAllByMember(Member member, Pageable pageable);

}
