package com.github.com.pages;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.com.pages.repository.EmptyRepositoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserMainPage extends AbstractWebPage {

  private final WebDriver driver;

  @FindBy(css = ".dashboard-changelog")
  protected WebElement changeLog;

  public LoggedUserMainPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public EmptyRepositoryPage openEmptyRepositoryByName(String name) {
    driver.findElement(By.partialLinkText(name)).click();
    return new EmptyRepositoryPage(driver);
  }

  public LoggedUserMainPage assertUserLoggedIn() {
    assertThat(changeLog.isDisplayed()).isTrue();
    return this;
  }
}
