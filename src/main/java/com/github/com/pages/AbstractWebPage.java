package com.github.com.pages;

import static com.github.com.driver.manager.DriverManager.disableImplicitWait;
import static com.github.com.driver.manager.DriverManager.enableImplicitWait;
import static com.github.com.driver.manager.DriverManager.getWebDriver;

import java.time.Duration;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class AbstractWebPage {

  private static final int defaultTimeout = 20;
  private static final int defaultPollingInterval = 500;

  // display
  protected static void waitForElementToBeDisplayed(WebElement element) {
    waitForElementToBeDisplayed(element, defaultTimeout);
  }

  protected static void waitForElementToBeDisplayed(WebElement element, int timeout) {
    disableImplicitWait();
    FluentWait<WebDriver> wait =
        new FluentWait<>(getWebDriver())
            .withTimeout(Duration.ofSeconds(timeout))
            .pollingEvery(Duration.ofMillis(defaultPollingInterval))
            .ignoring(NoSuchElementException.class);

    wait.until(ExpectedConditions.visibilityOf(element));
    enableImplicitWait();
  }

  // clicking
  protected static void waitForElementToBeClickable(WebElement element) {
    disableImplicitWait();
    FluentWait<WebDriver> wait =
        new FluentWait<>(getWebDriver())
            .withTimeout(Duration.ofSeconds(defaultTimeout))
            .pollingEvery(Duration.ofMillis(defaultPollingInterval))
            .ignoring(ElementClickInterceptedException.class);

    wait.until(ExpectedConditions.elementToBeClickable(element));
    enableImplicitWait();
  }
}
