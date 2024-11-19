package com.maple.project.api.v1.controller;

import com.alviss.commons.api.model.Response;
import com.alviss.commons.security.SecurityService;
import com.maple.project.api.v1.request.ProjectRequest;
import com.maple.project.api.v1.response.ProjectResponse;
import com.maple.project.api.v1.response.builder.ProjectApiHandler;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("ProjectControllerV1")
@AllArgsConstructor
@RequestMapping("/api/v1/projects")
public class ProjectController {

  private final ProjectApiHandler apiHandler;
  private final SecurityService securityService;

  @GetMapping("/{id}")
  //  @PreAuthorize("@securityService.hasPermission('ROLE_PROJECT_READ')")
  public Response<ProjectResponse> get(@PathVariable final String id) {
    return apiHandler.handleGet(id);
  }

  @GetMapping
  //  @PreAuthorize("@securityService.hasPermission('ROLE_PROJECT_READ')")
  public Response<List<ProjectResponse>> getAll(
      @RequestParam("team_id") final String teamId, final Pageable pageable) {
    return apiHandler.handleGetAll(teamId, pageable);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  //  @PreAuthorize("@securityService.hasPermission('ROLE_PROJECT_CREATE')")
  public Response<ProjectResponse> post(@RequestBody final ProjectRequest request) {
    return apiHandler.handlePost(request);
  }

  @PutMapping("/{id}")
  //  @PreAuthorize("@securityService.hasPermission('ROLE_PROJECT_UPDATE')")
  public Response<ProjectResponse> put(
      @PathVariable final String id, @RequestBody final ProjectRequest request) {
    return apiHandler.handlePut(id, request);
  }

  @PatchMapping("/{id}")
  //  @PreAuthorize("@securityService.hasPermission('ROLE_PROJECT_UPDATE')")
  public Response<ProjectResponse> patch(
      @PathVariable final String id, @RequestBody final ProjectRequest request) {
    return apiHandler.handlePatch(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  //  @PreAuthorize("@securityService.hasPermission('ROLE_PROJECT_DELETE')")
  public void delete(@PathVariable final String id) {
    apiHandler.handleDelete(id);
  }
}
