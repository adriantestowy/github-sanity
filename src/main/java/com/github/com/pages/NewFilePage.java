package com.github.com.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewFilePage extends AbstractWebPage {

  private final WebDriver driver;

  @FindBy(css = "[aria-label='File name']")
  protected WebElement fileTitle;

  @FindBy(css = ".cm-content")
  protected WebElement fileContent;

  @FindBy(id = "focus-trap-help-panel")
  protected WebElement panelHelp;

  @FindBy(css = "[data-testid='open-commit-dialog-button']")
  protected WebElement commitChanges;

  public NewFilePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public NewFilePage assertUserIsOnCreateNewFilePage() {
    assertThat(panelHelp.isDisplayed()).isTrue();
    return this;
  }

  public NewFilePage addFileTitle(String title) {
    fileTitle.sendKeys(title);
    return this;
  }

  public NewFilePage addFileContent(String content) {
    fileContent.sendKeys(content);
    return this;
  }

  public CommitChangesPage clickCommitChangesExpectSuccess() {
    commitChanges.click();
    return new CommitChangesPage(driver);
  }
}
