package com.github.com.api.requests;

import static com.github.com.configuration.ApiConfiguration.getApi;
import static io.restassured.RestAssured.given;

import io.restassured.specification.RequestSpecification;

public class GlobalRequests extends AbstractGlobalRequests {

  protected RequestSpecification getRequestSpec() {
    return given().spec(getApi()).when();
  }
}
