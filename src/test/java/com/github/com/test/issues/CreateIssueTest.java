package com.github.com.test.issues;

import com.github.com.test.BaseTest;
import org.testng.annotations.Test;

public class CreateIssueTest extends BaseTest {

  @Test
  public void shouldBeAbleToCreateNewIssue() {
    String projectName = testRepository.getName();

    String issueTitle = "Test issue";
    String issueDescription = "Issue description";

    homePage
        .assertHomePageHeader()
        .clickSignInButton()
        .assertSignInPageHeader()
        .loginUserExpectSuccess(user.getUsername(), user.getPassword())
        .assertUserLoggedIn()
        .openEmptyRepositoryByName(projectName)
        .assertUserIsOnRepositoryPage()
        .openIssuesTab()
        .assertUserIsOnIssuesPage()
        .clickNewIssue()
        .assertUserIsOnIssuePage()
        .typeTitle(issueTitle)
        .typeIssueBody(issueDescription)
        .submitIssueExpectSuccess()
        .assertIssueTitle(issueTitle);
  }
}
