package com.maple.project.service;

import com.alviss.commons.exception.NotFoundException;
import com.maple.project.dao.ProjectDao;
import com.maple.project.service.model.ProjectEntity;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

  private final ProjectDao dao;

  @Override
  public ProjectEntity get(final String id, final String organizationId) {
    val entity = dao.findByIdAndOrganizationId(id, organizationId);
    if (entity.isEmpty()) {
      throw new NotFoundException("Requested project is not found");
    }
    return entity.get();
  }

  public Page<ProjectEntity> getAll(final String organizationId, final Pageable pageable) {
    return dao.findByOrganizationIdOrderByName(organizationId, pageable);
  }

  @Override
  public ProjectEntity save(final ProjectEntity entity) {
    return dao.save(entity);
  }

  public void delete(final ProjectEntity entity) {
    dao.delete(entity);
  }
}
