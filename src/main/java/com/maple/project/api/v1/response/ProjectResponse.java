package com.maple.project.api.v1.response;

import com.maple.project.service.model.ProjectType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {

  private String id;
  private ProjectData data;

  @Data
  @Builder
  public static class ProjectData {
    private String name;
    private String description;
    private String organizationId;
    private ProjectType type;
  }
}
