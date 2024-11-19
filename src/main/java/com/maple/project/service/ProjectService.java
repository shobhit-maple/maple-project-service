package com.maple.project.service;

import com.maple.project.service.model.ProjectEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {

  ProjectEntity get(String id, String organizationId);

  Page<ProjectEntity> getAll(String parentId, Pageable pageable);

  ProjectEntity save(ProjectEntity entity);

  void delete(ProjectEntity entity);
}
