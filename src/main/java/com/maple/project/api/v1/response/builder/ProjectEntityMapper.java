package com.maple.project.api.v1.response.builder;

import com.maple.project.api.v1.request.ProjectRequest;
import com.maple.project.api.v1.response.ProjectResponse;
import com.maple.project.api.v1.response.ProjectResponse.ProjectData;
import com.maple.project.service.model.ProjectEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProjectEntityMapper {

  public ProjectEntity mapForPost(final String organizationId, final ProjectRequest request) {
    return ProjectEntity.builder()
        .name(request.getName())
        .description(request.getDescription())
        .organizationId(organizationId)
        .type(request.getType())
        .build();
  }

  public ProjectEntity mapForPut(final ProjectEntity entity, final ProjectRequest request) {
    entity.setName(request.getName());
    entity.setDescription(request.getDescription());
    entity.setType(request.getType());
    return entity;
  }

  public ProjectEntity mapForPatch(final ProjectEntity entity, final ProjectRequest request) {
    if (request.getName() != null && !request.getName().equals(entity.getName())) {
      entity.setName(request.getName());
    }
    if (request.getDescription() != null
        && !request.getDescription().equals(entity.getDescription())) {
      entity.setDescription(request.getDescription());
    }
    if (request.getType() != null && request.getType() != entity.getType()) {
      entity.setType(request.getType());
    }
    return entity;
  }

  public ProjectResponse entityToResponse(final ProjectEntity entity) {
    return ProjectResponse.builder()
        .id(entity.getId())
        .data(
            ProjectData.builder()
                .name(entity.getName())
                .description(entity.getDescription())
                .organizationId(entity.getOrganizationId())
                .type(entity.getType())
                .build())
        .build();
  }
}
