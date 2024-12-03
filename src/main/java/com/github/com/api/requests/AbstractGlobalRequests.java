package com.github.com.api.requests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import org.apache.http.HttpStatus;

public abstract class AbstractGlobalRequests {

  protected abstract RequestSpecification getRequestSpec();

  // GET
  protected Response doGet(String urlPath) {
    return doGet(urlPath, HttpStatus.SC_OK);
  }

  protected Response doGet(String urlPath, int httpStatus) {
    return getRequestSpec()
        .get(urlPath)
        .then()
        .statusCode(httpStatus)
        .extract()
        .response();
  }

  // POST
  protected Response doPost(String query, int httpStatus) {
    return getRequestSpec().post(query).then().statusCode(httpStatus).extract().response();
  }

  protected Response doPostWithBody(Object object, String query, int httpStatus) {
    return getRequestSpec()
        .body(object)
        .post(query)
        .then()
        .statusCode(httpStatus)
        .extract()
        .response();
  }

  protected Response doPostWithBodyAndPathParams(
      Object object, String query, Map<String, ?> params, int httpStatus) {
    return getRequestSpec()
        .body(object)
        .pathParams(params)
        .post(query)
        .then()
        .statusCode(httpStatus)
        .extract()
        .response();
  }

  // DELETE
  protected Response doDelete(String query, Map<String, String> queryMap, int httpStatus) {
    return getRequestSpec()
        .pathParams(queryMap)
        .delete(query)
        .then()
        .statusCode(httpStatus)
        .extract()
        .response();
  }

  protected void doDeleteIgnoreResult(String query, Map<String, String> queryMap) {
    getRequestSpec().pathParams(queryMap).delete(query);
  }
}
