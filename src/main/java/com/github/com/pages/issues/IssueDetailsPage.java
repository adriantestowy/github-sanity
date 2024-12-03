package com.github.com.pages.issues;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.com.pages.AbstractWebPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IssueDetailsPage extends AbstractWebPage {

  private final WebDriver driver;

  @FindBy(css = ".markdown-title")
  protected WebElement issueTitle;

  @FindBy(id = "issue_body")
  protected WebElement issueBody;

  public IssueDetailsPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public IssueDetailsPage assertIssueTitle(String title) {
    assertThat(issueTitle.getText()).isEqualTo(title);
    return this;
  }

  public IssueDetailsPage typeIssueBody(String body) {
    issueBody.sendKeys(body);
    return this;
  }

  public IssuesPage submitIssueExpectSuccess() {
    issueTitle.sendKeys(Keys.RETURN);
    return new IssuesPage(driver);
  }
}
