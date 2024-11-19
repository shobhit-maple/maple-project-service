package com.maple.project.service;

import com.maple.project.dao.ProjectDao;
import com.maple.project.service.model.ProjectEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

  private final ProjectDao dao;

  public Page<ProjectEntity> getAll(final String teamId, final Pageable pageable) {
    return dao.findByTeamIdOrderByName(teamId, pageable);
  }

  public void delete(final ProjectEntity entity) {
    dao.delete(entity);
  }

  @Override
  public JpaRepository<ProjectEntity, String> getDao() {
    return dao;
  }
}
