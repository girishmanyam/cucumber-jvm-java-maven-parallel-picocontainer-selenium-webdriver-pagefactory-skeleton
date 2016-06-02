package automation.ui;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

public class FirefoxBrowser extends FirefoxDriver {

    public static FirefoxBrowser buildFirefoxBrowser() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);

        FirefoxBrowser browser = new FirefoxBrowser(profile);
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return browser;
    }

    private FirefoxBrowser(FirefoxProfile desiredProfile) {
        super(desiredProfile);
    }
}
