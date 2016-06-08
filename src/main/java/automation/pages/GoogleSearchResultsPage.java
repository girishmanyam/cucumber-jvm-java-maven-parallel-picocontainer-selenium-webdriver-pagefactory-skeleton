package automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResultsPage {
	private final WebDriver driver;

	@FindBy(css = ".g .r")
	private WebElement firstHitDescriptionText;

	public GoogleSearchResultsPage(WebDriver commonDriver) {
		driver = commonDriver;
		PageFactory.initElements(driver, this);
	}

	public String firstHitTitle() {
		return firstHitDescriptionText.getText();
	}
}
