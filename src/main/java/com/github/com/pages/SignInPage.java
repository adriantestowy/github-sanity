package com.github.com.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends AbstractWebPage {

  private final String headerText = "Sign in to GitHub";
  private final WebDriver driver;

  @FindBy(id = "login_field")
  protected WebElement loginInput;

  @FindBy(id = "password")
  protected WebElement passwordInput;

  @FindBy(name = "commit")
  protected WebElement signInButton;

  @FindBy(css = ".auth-form-header")
  protected WebElement header;

  public SignInPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public SignInPage assertSignInPageHeader() {
    assertThat(header.getText()).isEqualTo(headerText);
    return this;
  }

  public SignInPage setUsername(String username) {
    waitForElementToBeDisplayed(loginInput);
    loginInput.sendKeys(username);
    return this;
  }

  public SignInPage setPassword(String pass) {
    passwordInput.sendKeys(pass);
    return this;
  }

  public LoggedUserMainPage clickSignInButton() {
    signInButton.click();
    return new LoggedUserMainPage(driver);
  }

  public LoggedUserMainPage loginUserExpectSuccess(String username, String password) {
    setUsername(username);
    setPassword(password);
    clickSignInButton();
    return new LoggedUserMainPage(driver);
  }
}
