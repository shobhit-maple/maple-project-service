package com.maple.project.dao;

import com.maple.project.service.model.ProjectEntity;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao extends JpaRepository<ProjectEntity, String> {

  Page<ProjectEntity> findByOrganizationIdOrderByName(String organizationId, Pageable pageable);

  Optional<ProjectEntity> findByIdAndOrganizationId(String id, String organizationId);
}
