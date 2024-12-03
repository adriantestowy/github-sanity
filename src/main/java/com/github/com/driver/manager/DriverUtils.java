package com.github.com.driver.manager;

import static com.github.com.driver.manager.DriverManager.getWebDriver;

public class DriverUtils {

  public static void navigateToPage(String pageUrl) {
    getWebDriver().get(pageUrl);
  }
}
