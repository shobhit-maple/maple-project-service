package com.maple.project.api.v1.request;

import com.maple.project.service.model.ProjectType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequest {

  private String name;
  private String description;
  private ProjectType type;
}
