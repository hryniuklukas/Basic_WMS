package com.github.hryniuklukas.Basic_WMS.repos;

import com.github.hryniuklukas.Basic_WMS.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DocumentRepo extends JpaRepository<Document,Long>, JpaSpecificationExecutor<Document> {
}
