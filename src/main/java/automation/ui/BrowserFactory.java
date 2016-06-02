package automation.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver getBrowser() {
        String desiredBrowserName = System.getProperty("browser", "firefox");
        WebDriver desiredBrowser = null;
        switch(desiredBrowserName) {
            case "ie":
                IEBrowser.buildIEBrowser();
                break;
            case "chrome":
                ChromeBrowser.buildChromeBrowser();
                break;
            case "firefox":
                FirefoxBrowser.buildFirefoxBrowser();
                break;
            default:
                //something
                break;
        }
        return desiredBrowser;
    }

    public static WebDriver buildFirefox() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver buildChrome() {
    }

    public static WebDriver buildIE() {
    }
}
