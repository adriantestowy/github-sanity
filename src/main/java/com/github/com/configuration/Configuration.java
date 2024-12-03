package com.github.com.configuration;

import com.github.com.driver.BrowserType;
import java.net.URL;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

@LoadPolicy(LoadType.MERGE)
@Sources({
  "system:env",
  "system:properties",
  "classpath:properties/${env}.properties",
  "classpath:properties/local.properties",
})
public interface Configuration extends Config {

  @Key("IS_REMOTE")
  @DefaultValue("false")
  Boolean isRemote();

  @Key("BROWSER")
  @DefaultValue("CHROME")
  BrowserType getBrowser();

  @Key("IS_DEBUG")
  @DefaultValue("false")
  Boolean isDebug();

  @Key("GRID_URL")
  @DefaultValue("http://localhost:4444/wd/hub")
  URL getGridUrl();

  @Key("WEB_URL")
  @DefaultValue("http://localhost:3001")
  String getWebUrl();

  @Key("API_URL")
  @DefaultValue("")
  String getApiUrl();

}
