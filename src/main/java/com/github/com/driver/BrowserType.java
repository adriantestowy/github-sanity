package com.github.com.driver;

public enum BrowserType {
  CHROME("chrome"),
  FIREFOX("firefox"),
  OPERA("opera"),
  EDGE("edge"),
  IE("internetexplorer");

  private final String browser;

  BrowserType(String browser) {
    this.browser = browser;
  }
}
