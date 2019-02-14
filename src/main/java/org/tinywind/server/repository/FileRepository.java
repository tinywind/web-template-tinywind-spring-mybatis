package org.tinywind.server.repository;

import org.tinywind.server.model.FileEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository {
    FileEntity findOne(Long fileId);

    Long save(FileEntity fileEntity);
}
