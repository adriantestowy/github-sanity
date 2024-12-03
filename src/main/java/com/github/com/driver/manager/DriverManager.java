package com.github.com.driver.manager;

import static com.github.com.configuration.ConfigurationManager.getConfiguration;
import static com.github.com.driver.listeners.WebDriverEventListenerRegister.registerWebDriverEventListener;
import static java.util.Optional.ofNullable;

import com.github.com.driver.BrowserType;
import java.time.Duration;
import org.openqa.selenium.WebDriver;

public class DriverManager {

  private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
  private static final ThreadLocal<BrowserType> browserTypeThreadLocal = new ThreadLocal<>();

  private DriverManager() {}

  private static void setupTimeouts() {
    WebDriver webDriver = webDriverThreadLocal.get();
    enableImplicitWait();
    webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5L));
    webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30L));
  }

  public static void disableImplicitWait() {
    WebDriver webDriver = webDriverThreadLocal.get();
    webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0L));
  }

  public static void enableImplicitWait() {
    WebDriver webDriver = webDriverThreadLocal.get();
    webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
  }

  public static WebDriver getWebDriver() {
    return webDriverThreadLocal.get();
  }

  public static void setWebDriver(BrowserType browserType) {
    browserType = ofNullable(browserType).orElseGet(() -> getConfiguration().getBrowser());
    if (browserType == null) {
      throw new RuntimeException("Browser type is null");
    }
    WebDriver browser = new BrowserFactory(browserType).getBrowser();
    if (getConfiguration().isDebug()) {
      browser = registerWebDriverEventListener(browser);
    }
    browserTypeThreadLocal.set(browserType);
    webDriverThreadLocal.set(browser);
    setupTimeouts();
  }

  public static BrowserType getBrowserType() {
    return browserTypeThreadLocal.get();
  }

  public static void disposeDriver() {
        try {
    webDriverThreadLocal.get().close();
    webDriverThreadLocal.get().quit();
        } catch (Exception ignore) {
        }
    webDriverThreadLocal.remove();
    browserTypeThreadLocal.remove();
  }
}
