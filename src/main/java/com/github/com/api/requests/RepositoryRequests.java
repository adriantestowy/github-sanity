package com.github.com.api.requests;

import com.github.com.api.model.requests.repository.RepositoryModel;
import com.github.com.api.model.responses.repository.RepositoryResponse;
import java.util.Map;
import lombok.NoArgsConstructor;
import org.apache.http.HttpStatus;

@NoArgsConstructor(staticName = "repositoryRequest")
public class RepositoryRequests extends GlobalRequests {

  public RepositoryResponse create(RepositoryModel request) {
    return doPostWithBody(request, "/user/repos", HttpStatus.SC_CREATED)
        .as(RepositoryResponse.class);
  }

  public void delete(Map<String, String> queryMap, boolean ignoreResult) {
    if (ignoreResult) {
      deleteIgnoreResult(queryMap);
    } else {
      doDelete("/repos/{OWNER}/{REPO}", queryMap, HttpStatus.SC_NO_CONTENT);
    }
  }

  public void deleteIgnoreResult(Map<String, String> queryMap) {
    doDeleteIgnoreResult("/repos/{OWNER}/{REPO}", queryMap);
  }
}
