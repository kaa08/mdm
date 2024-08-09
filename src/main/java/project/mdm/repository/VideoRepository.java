package project.mdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.mdm.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
