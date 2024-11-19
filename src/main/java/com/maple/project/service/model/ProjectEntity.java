package com.maple.project.service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@Builder
@Entity
@Table(name = "project")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  @NotNull
  @NotEmpty
  @Length(min = 3)
  private String name;
  private String description;
  @NotNull
  @NotEmpty
  private String organizationId;
  @NotNull
  private ProjectType type;
}
