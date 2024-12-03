package com.github.com.pages.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.com.pages.AbstractWebPage;
import com.github.com.pages.NewFilePage;
import com.github.com.pages.issues.IssuesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmptyRepositoryPage extends AbstractWebPage {

  private final WebDriver driver;

  @FindBy(id = "issues-tab")
  protected WebElement issuesTab;

  @FindBy(id = "code-tab")
  protected WebElement codeTab;

  @FindBy(xpath = "//a[text()='creating a new file']")
  protected WebElement createNewFileLink;

  public EmptyRepositoryPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public EmptyRepositoryPage assertUserIsOnRepositoryPage() {
    assertThat(codeTab.isDisplayed()).isTrue();
    return this;
  }

  public NewFilePage openCreateNewFileLink() {
    createNewFileLink.click();
    return new NewFilePage(driver);
  }

  public IssuesPage openIssuesTab() {
    issuesTab.click();
    return new IssuesPage(driver);
  }
}
