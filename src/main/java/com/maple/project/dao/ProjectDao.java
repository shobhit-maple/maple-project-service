package com.maple.project.dao;

import com.maple.project.service.model.ProjectEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao extends JpaRepository<ProjectEntity, String> {

  Page<ProjectEntity> findByTeamIdOrderByName(String teamId, Pageable pageable);
}
