package com.github.com.pages;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.com.pages.repository.RepositoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommitChangesPage extends AbstractWebPage {

  private final WebDriver driver;

  @FindBy(css = "[data-testid='submit-commit-button']")
  protected WebElement commitChanges;

  @FindBy(css = "[for='commit-message-input']")
  protected WebElement popup;

  public CommitChangesPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public CommitChangesPage assertCommitChangesPopupIsVisible() {
    waitForElementToBeDisplayed(popup);
    assertThat(popup.isDisplayed()).isTrue();
    return this;
  }

  public RepositoryPage clickCommitChangesButtonExpectSuccess() {
    commitChanges.click();
    return new RepositoryPage(driver);
  }

}
