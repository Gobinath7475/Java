package com.kgisl.SpringBootFileupload.Repository;

import com.kgisl.SpringBootFileupload.Entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {
    // Additional query methods if needed
}
