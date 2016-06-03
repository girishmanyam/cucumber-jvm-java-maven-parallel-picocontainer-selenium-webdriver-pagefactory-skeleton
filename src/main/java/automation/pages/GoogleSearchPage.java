package automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class GoogleSearchPage {
	private String url = "http://www.google.co.uk/";
	private WebDriver driver;

	@FindBy(css = "#lst-ib")
	WebElement searchField;

	@FindBy(css = "button[name='btnG']")
	WebElement searchButton;

	public GoogleSearchPage(WebDriver commonDriver) {
		driver = commonDriver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}

	public void load() {
		driver.get(url);
	}

	public void searchFor(String searchString) {
		searchField.clear();
		searchField.sendKeys(searchString + "\n");
		searchButton.click();
	}
}
