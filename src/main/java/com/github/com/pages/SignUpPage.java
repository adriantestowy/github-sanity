package com.github.com.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends AbstractWebPage {

  private final String headerText = "Enter your email*";
  private final WebDriver driver;

  @FindBy(id = "email")
  protected WebElement emailInput;

  @FindBy(css = ".signup-continue-button")
  protected WebElement continueAfterEmail;

  @FindBy(css = "[data-continue-to='username-container']")
  protected WebElement continueAfterPassword;

  @FindBy(css = "[data-continue-to='captcha-and-submit-container']")
  protected WebElement continueAfterUsername;

  @FindBy(id = "password")
  protected WebElement passwordInput;

  @FindBy(id = "login")
  protected WebElement username;

  @FindBy(css = "[for='email']")
  protected WebElement emailHeader;

  public SignUpPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public SignUpPage assertSignUpPageHeader() {
    waitForElementToBeDisplayed(emailHeader);
    assertThat(emailHeader.getText()).isEqualTo(headerText);
    return this;
  }

  public SignUpPage pressContinueExpectPassword() {
    waitForElementToBeClickable(continueAfterEmail);
    continueAfterEmail.click();
    waitForElementToBeDisplayed(passwordInput);
    return this;
  }

  public SignUpPage pressContinueExpectUsername() {
    waitForElementToBeClickable(continueAfterPassword);
    continueAfterPassword.click();
    waitForElementToBeDisplayed(username);
    return this;
  }

  public SignUpPage pressContinueExpectSuccess() {
    waitForElementToBeClickable(continueAfterUsername);
    continueAfterUsername.click();
    return this;
  }

  public SignUpPage setEmail(String email) {
    waitForElementToBeDisplayed(emailInput);
    emailInput.sendKeys(email);
    return this;
  }

  public SignUpPage setPassword(String pass) {
    passwordInput.sendKeys(pass);
    return this;
  }

  public SignUpPage setUsername(String username) {
    waitForElementToBeDisplayed(this.username);
    this.username.sendKeys(username);
    return this;
  }
}
