package com.github.com.pages.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.com.pages.AbstractWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepositoryPage extends AbstractWebPage {

  private final WebDriver driver;

  @FindBy(css = "[title='Last commit message']")
  protected WebElement uniqueElement;

  public RepositoryPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public RepositoryPage assertUserIsOnRepositoryPage() {
    assertThat(uniqueElement.isDisplayed()).isTrue();
    return this;
  }
}
