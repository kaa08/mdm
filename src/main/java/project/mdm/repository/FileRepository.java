package project.mdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.mdm.entity.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
