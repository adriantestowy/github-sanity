package com.github.com.api.model.responses.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Permissions {

  @JsonProperty("pull")
  private boolean pull;

  @JsonProperty("admin")
  private boolean admin;

  @JsonProperty("push")
  private boolean push;
}
