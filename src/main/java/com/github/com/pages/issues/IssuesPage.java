package com.github.com.pages.issues;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.com.pages.AbstractWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IssuesPage extends AbstractWebPage {

  private final WebDriver driver;

  @FindBy(xpath = "//span[text()='New issue']")
  protected WebElement newIssueButton;

  @FindBy(id = "js-issues-search")
  protected WebElement issueSearch;

  public IssuesPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public IssuesPage assertUserIsOnIssuesPage() {
    assertThat(issueSearch.isDisplayed()).isTrue();
    return this;
  }

  public IssuePage clickNewIssue() {
    newIssueButton.click();
    return new IssuePage(driver);
  }
}
