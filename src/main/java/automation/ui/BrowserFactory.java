package automation.ui;

import org.openqa.selenium.WebDriver;

class BrowserFactory {

    public static WebDriver getBrowser() throws Throwable {
        String desiredBrowserName = System.getProperty("browser", "firefox");
        WebDriver desiredBrowser = null;

        switch(desiredBrowserName) {
            case "ie":
                desiredBrowser = IEBrowser.buildIEBrowser();
                break;
            case "chrome":
                desiredBrowser = ChromeBrowser.buildChromeBrowser();
                break;
            case "firefox":
                desiredBrowser = FirefoxBrowser.buildFirefoxBrowser();
                break;
            default:
                //work out what to do when a browser isn't needed
                break;
        }
        return desiredBrowser;
    }
}
