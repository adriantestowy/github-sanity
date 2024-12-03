package com.github.com.test.register;

import com.github.com.test.BaseTest;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class RegisterUserTest extends BaseTest {

  @Test
  public void shoudntBeAbleToCreateAccount() {

    Faker faker = new Faker();

    String userPassword = "Pass;Word13!";
    String email = faker.internet().emailAddress();
    String randomUsername = faker.lorem().characters(30);

    homePage
        .assertHomePageHeader()
        .clickSignUpButton()
        .assertSignUpPageHeader()
        .setEmail(email)
        .pressContinueExpectPassword()
        .setPassword(userPassword)
        .pressContinueExpectUsername()
        .setUsername(randomUsername)
        .pressContinueExpectSuccess();
  }
}
