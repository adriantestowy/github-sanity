package com.github.com.api.model.requests.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RepositoryModel {

  @JsonProperty("private")
  private boolean isPrivate;

  @JsonProperty("is_template")
  private boolean isTemplate;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("homepage")
  private String homepage;
}
