package com.github.com.pages.issues;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.com.pages.AbstractWebPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IssuePage extends AbstractWebPage {

  private final WebDriver driver;

  @FindBy(id = "issue_title")
  protected WebElement issueTitle;

  @FindBy(id = "issue_body")
  protected WebElement issueBody;

  @FindBy(id = "issue_title_header")
  protected WebElement addTitleText;

  public IssuePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public IssuePage assertUserIsOnIssuePage() {
    assertThat(addTitleText.isDisplayed()).isTrue();
    return this;
  }

  public IssuePage typeTitle(String title) {
    issueTitle.sendKeys(title);
    return this;
  }

  public IssuePage typeIssueBody(String body) {
    issueBody.sendKeys(body);
    return this;
  }

  public IssueDetailsPage submitIssueExpectSuccess() {
    issueTitle.sendKeys(Keys.RETURN);
    return new IssueDetailsPage(driver);
  }
}
