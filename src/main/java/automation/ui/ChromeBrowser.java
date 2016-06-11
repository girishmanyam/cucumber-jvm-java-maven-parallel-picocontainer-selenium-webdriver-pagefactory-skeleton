package automation.ui;

import java.util.concurrent.TimeUnit;

import automation.config.TestConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class ChromeBrowser extends ChromeDriver {
    public static WebDriver buildChromeBrowser() throws Throwable {
    	System.setProperty("webdriver.chrome.driver", TestConfig.valueFor("WebDriverChromeDriverPath"));
        ChromeBrowser browser = new ChromeBrowser();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return browser;
    }
    
    private ChromeBrowser() {
    	super();
    }
}
