package com.github.com.pages;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.com.driver.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractWebPage {

  private final String homePageHeaderText =
      "Build and ship software on a single, collaborative platform";

  private final WebDriver driver;

  @FindBy(css = ".HeaderMenu-link--sign-in")
  protected WebElement signInButton;

  @FindBy(css = ".HeaderMenu-link--sign-up")
  protected WebElement signUpButton;

  @FindBy(id = "hero-section-brand-heading")
  protected WebElement homePageHeader;

  public HomePage() {
    this.driver = DriverManager.getWebDriver();
    PageFactory.initElements(driver, this);
  }

  public HomePage assertHomePageHeader() {
    assertThat(homePageHeader.getText()).isEqualTo(homePageHeaderText);
    return this;
  }

  public SignInPage clickSignInButton() {
    signInButton.click();
    return new SignInPage(driver);
  }

  public SignUpPage clickSignUpButton() {
    signUpButton.click();
    return new SignUpPage(driver);
  }
}
