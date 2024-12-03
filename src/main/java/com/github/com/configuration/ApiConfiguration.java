package com.github.com.configuration;

import static com.github.com.configuration.ConfigurationManager.getConfiguration;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ApiConfiguration {
  static RequestSpecification requestSpec;

  public ApiConfiguration() {
    requestSpec =
        new RequestSpecBuilder()
            .setBaseUri(getConfiguration().getApiUrl())
            .addHeader("X-GitHub-Api-Version", "2022-11-28")
            .addHeader("Accept", "application/vnd.github+json")
            .build();
  }

  public static RequestSpecification getApi() {
    return requestSpec;
  }

  public void setAuth(String token) {
    requestSpec.header("Authorization", "Bearer " + token);
  }
}
