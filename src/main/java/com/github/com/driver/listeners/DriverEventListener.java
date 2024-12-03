package com.github.com.driver.listeners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

@Log4j2
public class DriverEventListener implements WebDriverListener {
  @Override
  public void beforeGet(WebDriver driver, String url) {
    log.info("Trying to navigate to " + url);
  }

  @Override
  public void afterGet(WebDriver driver, String url) {
    log.info("Navigated to " + url);
  }

  @Override
  public void beforeRefresh(WebDriver.Navigation navigation) {
    log.info("Trying to refresh page");
  }

  @Override
  public void beforeFindElement(WebDriver driver, By locator) {
    log.info("Trying to find element with locator " + locator.toString());
  }

  @Override
  public void afterFindElement(WebDriver driver, By locator, WebElement result) {
    log.info("Found element with locator " + locator.toString());
  }

  @Override
  public void beforeClick(WebElement element) {
    log.info("Trying to click on element with accessible name: " + element.getAccessibleName());
  }

  @Override
  public void afterClick(WebElement element) {
    log.info("Clicked on element with accessible name: " + element);
  }

  @Override
  public void beforeSendKeys(WebElement element, CharSequence[] keysToSend) {
    if (keysToSend == null) {
      log.info("Trying to enter empty string or clear element: " + element.getTagName());
    } else {
      log.info(
          "Trying to type into element: "
              + element.getTagName()
              + " text "
              + Arrays.toString(keysToSend));
    }
  }

  @Override
  public void afterSendKeys(WebElement element, CharSequence[] keysToSend) {
    if (keysToSend == null) {
      log.info("Entered empty string or cleared element: " + element.getTagName());
    } else {
      log.info(
          "Typed into element: " + element.getTagName() + " text " + Arrays.toString(keysToSend));
    }
  }

  @Override
  public void beforeExecuteScript(WebDriver driver, String script, Object[] args) {
    log.info("Trying to execute JS script: " + script);
  }

  @Override
  public void afterExecuteScript(WebDriver driver, String script, Object[] args, Object result) {
    log.info("Executed JS script: " + script);
  }

  @Override
  public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
    log.info(
        "There was an exception in method + "
            + method.getName()
            + " with error message: "
            + e.getMessage());
  }

  @Override
  public void beforeGetText(WebElement element) {
    log.info("Trying to get text from element: " + element.toString());
  }

  @Override
  public void afterGetText(WebElement element, String result) {
    log.info("Fetched text from element: " + result);
  }

  public void beforeQuit(WebDriver driver) {
    log.info("About to close webdriver : " + driver.toString());
  }

  public void afterQuit(WebDriver driver) {
    log.info("Successfully to close webdriver : " + driver.toString());
  }
}
