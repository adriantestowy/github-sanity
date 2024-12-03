package com.github.com.api.model.responses.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class License {

  @JsonProperty("html_url")
  private String htmlUrl;

  @JsonProperty("name")
  private String name;

  @JsonProperty("spdx_id")
  private String spdxId;

  @JsonProperty("key")
  private String key;

  @JsonProperty("url")
  private String url;

  @JsonProperty("node_id")
  private String nodeId;
}
