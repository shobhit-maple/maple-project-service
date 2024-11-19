package com.maple.project.service.model;

import jakarta.annotation.Nullable;
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
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@Entity
@Table(name = "Project")
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
  @Nullable
  private String description;
  @NotNull
  @NotEmpty
  private String teamId;
  @NotNull
  private ProjectType type;
}
