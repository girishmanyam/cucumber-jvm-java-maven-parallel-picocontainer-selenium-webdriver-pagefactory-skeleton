package automation.ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEBrowser extends InternetExplorerDriver {
    public static WebDriver buildIEBrowser() {
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(IGNORE_ZOOM_SETTING, true);
        
        System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
        IEBrowser browser = new IEBrowser(capabilities);
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return browser;
    }
    
    private IEBrowser(DesiredCapabilities capabilities) {
    	super(capabilities);
    }
}
