package com.maple.project.api.v1.response.builder;

import com.alviss.commons.api.model.Response;
import com.alviss.commons.exception.BadRequestException;
import com.alviss.commons.validator.CustomValidator;
import com.maple.project.api.v1.request.ProjectRequest;
import com.maple.project.api.v1.response.ProjectResponse;
import com.maple.project.service.ProjectService;
import com.maple.project.service.model.ProjectEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProjectApiHandler {

  private final ProjectService projectService;
  private final ProjectEntityMapper mapper;
  private final CustomValidator validator;

  public Response<ProjectResponse> handleGet(final String id, final String organizationId) {
    val entity = projectService.get(id, organizationId);
    return new Response<>(mapper.entityToResponse(entity));
  }

  public Response<List<ProjectResponse>> handleGetAll(
      final String organizationId, final Pageable pageable) {
    val page = projectService.getAll(organizationId, pageable);
    return new Response<>(
        page.get().map(mapper::entityToResponse).collect(Collectors.toList()), page);
  }

  public Response<ProjectResponse> handlePost(
      final String organizationId, final ProjectRequest request) {
    val entity = mapper.mapForPost(organizationId, request);
    validate(entity);
    return new Response<>(mapper.entityToResponse(projectService.save(entity)));
  }

  public Response<ProjectResponse> handlePatch(
      final String id, final String organizationId, final ProjectRequest request) {
    val existingEntity = projectService.get(id, organizationId);
    val updatedEntity = mapper.mapForPatch(existingEntity, request);
    validate(updatedEntity);
    return new Response<>(mapper.entityToResponse(projectService.save(updatedEntity)));
  }

  public Response<ProjectResponse> handlePut(
      final String id, final String organizationId, final ProjectRequest request) {
    val existingEntity = projectService.get(id, organizationId);
    val updatedEntity = mapper.mapForPut(existingEntity, request);
    validate(updatedEntity);
    return new Response<>(mapper.entityToResponse(projectService.save(updatedEntity)));
  }

  public void handleDelete(final String id, final String organizationId) {
    val entity = projectService.get(id, organizationId);
    projectService.delete(entity);
  }

  private void validate(final ProjectEntity entity) {
    val errors = validator.validate(entity);
    if (!errors.isEmpty()) {
      throw new BadRequestException("There are some validation errors", errors);
    }
  }
}
