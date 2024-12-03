package com.github.com.test;

import static com.github.com.configuration.ConfigurationManager.getConfiguration;

import com.github.com.api.model.requests.repository.RepositoryModel;
import com.github.com.api.model.responses.repository.RepositoryResponse;
import com.github.com.api.requests.RepositoryRequests;
import com.github.com.configuration.ApiConfiguration;
import com.github.com.driver.BrowserType;
import com.github.com.driver.manager.DriverManager;
import com.github.com.driver.manager.DriverUtils;
import com.github.com.pages.HomePage;
import com.github.com.testData.TestDataReader;
import com.github.com.testData.Users.User;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import java.util.HashMap;
import java.util.Map;
import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

public class BaseTest {
  protected static RepositoryResponse testRepository;
  protected final String repositoryName = RandomStringUtils.randomAlphabetic(10);
  protected TestDataReader testDataReader = new TestDataReader();
  protected ApiConfiguration apiConfiguration = new ApiConfiguration();
  protected HomePage homePage;
  protected User user = testDataReader.getUsers().getBasicUser();

  @BeforeSuite
  @SneakyThrows
  public void beforeAll() {
    determineLog();
    clanUpAfterTests(true);
    apiConfiguration.setAuth(user.getToken());
    createTestRepository();
  }

  @BeforeMethod
  public void beforeTest(@Optional BrowserType browserType) {
    DriverManager.setWebDriver(browserType);
    DriverUtils.navigateToPage(getConfiguration().getWebUrl());
    homePage = new HomePage();
  }

  @AfterMethod
  public void afterTest() {
    DriverManager.disposeDriver();
  }

  @AfterSuite
  public void tearDown() {
    clanUpAfterTests(false);
  }

  private void determineLog() {
    var configuration = getConfiguration();
    if (configuration.isDebug()) {
      RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    } else {
      RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
  }

  private void createTestRepository() {
    RepositoryModel repositoryRequest =
        RepositoryModel.builder().name(repositoryName).isTemplate(false).isPrivate(true).build();

    testRepository = RepositoryRequests.repositoryRequest().create(repositoryRequest);
  }

  private void clanUpAfterTests(boolean ignoreResult) {
    Map<String, String> queryParams = new HashMap<>();
    String username = user.getUsername();
    queryParams.put("OWNER", username);
    queryParams.put("REPO", repositoryName);

    RepositoryRequests.repositoryRequest().delete(queryParams, ignoreResult);
  }
}
