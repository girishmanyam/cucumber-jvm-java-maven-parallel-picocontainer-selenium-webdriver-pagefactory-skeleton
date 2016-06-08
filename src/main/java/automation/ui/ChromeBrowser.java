package automation.ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class ChromeBrowser extends ChromeDriver {
    public static WebDriver buildChromeBrowser() {
    	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeBrowser browser = new ChromeBrowser();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return browser;
    }
    
    private ChromeBrowser() {
    	super();
    }
}
