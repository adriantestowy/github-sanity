package com.github.com.driver.manager;

import static com.github.com.configuration.ConfigurationManager.getConfiguration;

import com.github.com.driver.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {

  private final BrowserType browserType;

  public BrowserFactory(BrowserType browserType) {
    this.browserType = browserType;
  }

  public WebDriver getBrowser() {
    if (getConfiguration().isRemote()) {
      return switch (browserType) {
        case CHROME -> new RemoteWebDriver(getConfiguration().getGridUrl(), setChromeOption());
        case FIREFOX -> new RemoteWebDriver(getConfiguration().getGridUrl(), setFirefoxOption());
        default -> throw new IllegalArgumentException("Browser not supported");
      };
    } else {
      switch (browserType) {
        case CHROME -> {
          WebDriverManager.chromedriver().setup();
          System.setProperty("webdriver.chrome.silentOutput", "true");
          return new ChromeDriver(setChromeOption());
        }
        case FIREFOX -> {
          WebDriverManager.firefoxdriver().setup();
          System.setProperty("webdriver.firefox.logfile", "/dev/null");
          return new FirefoxDriver(setFirefoxOption());
        }
        default -> throw new IllegalArgumentException("Browser not supported");
      }
    }
  }

  private ChromeOptions setChromeOption() {
    return new ChromeOptions()
        .addArguments(
            "--window-size=1920,1080",
            "--remote-allow-origins=*",
            "--disable-search-engine-choice-screen");
  }

  private FirefoxOptions setFirefoxOption() {
    return new FirefoxOptions()
        .addArguments("--width=1920", "--height=1080")
        .setLogLevel(FirefoxDriverLogLevel.WARN);
  }
}
