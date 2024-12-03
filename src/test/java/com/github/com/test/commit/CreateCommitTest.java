package com.github.com.test.commit;

import com.github.com.test.BaseTest;
import org.testng.annotations.Test;

public class CreateCommitTest extends BaseTest {

  @Test
  public void shouldCreateCommitInNewRepository() {
    String projectName = testRepository.getName();

    homePage
        .assertHomePageHeader()
        .clickSignInButton()
        .assertSignInPageHeader()
        .loginUserExpectSuccess(user.getUsername(), user.getPassword())
        .assertUserLoggedIn()
        .openEmptyRepositoryByName(projectName)
        .openCreateNewFileLink()
        .assertUserIsOnCreateNewFilePage()
        .addFileTitle("Readme.md")
        .addFileContent("This is just simple readme text")
        .clickCommitChangesExpectSuccess()
        .assertCommitChangesPopupIsVisible()
        .clickCommitChangesButtonExpectSuccess()
        .assertUserIsOnRepositoryPage();
  }
}
