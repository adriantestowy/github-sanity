package com.github.com.api.model.responses.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryResponse {

  @JsonProperty("allow_forking")
  private boolean allowForking;

  @JsonProperty("stargazers_count")
  private int stargazersCount;

  @JsonProperty("is_template")
  private boolean isTemplate;

  @JsonProperty("pushed_at")
  private String pushedAt;

  @JsonProperty("subscription_url")
  private String subscriptionUrl;

  @JsonProperty("branches_url")
  private String branchesUrl;

  @JsonProperty("source")
  private Source source;

  @JsonProperty("issue_comment_url")
  private String issueCommentUrl;

  @JsonProperty("allow_rebase_merge")
  private boolean allowRebaseMerge;

  @JsonProperty("labels_url")
  private String labelsUrl;

  @JsonProperty("subscribers_url")
  private String subscribersUrl;

  @JsonProperty("temp_clone_token")
  private String tempCloneToken;

  @JsonProperty("releases_url")
  private String releasesUrl;

  @JsonProperty("svn_url")
  private String svnUrl;

  @JsonProperty("subscribers_count")
  private int subscribersCount;

  @JsonProperty("id")
  private int id;

  @JsonProperty("name")
  private String name;

}
