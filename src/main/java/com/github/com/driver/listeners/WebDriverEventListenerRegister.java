package com.github.com.driver.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class WebDriverEventListenerRegister {

  public static synchronized WebDriver registerWebDriverEventListener(WebDriver driver) {
    return new EventFiringDecorator<>(new DriverEventListener()).decorate(driver);
  }
}
