package com.github.com.test.login;

import com.github.com.test.BaseTest;
import com.github.com.testData.Users.User;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

  @Test
  public void shouldBeAbleToLogin() {

    homePage
        .assertHomePageHeader()
        .clickSignInButton()
        .assertSignInPageHeader()
        .setUsername(user.getUsername())
        .setPassword(user.getPassword())
        .clickSignInButton()
        .assertUserLoggedIn();
  }
}
