package automation.stepdefs;

import automation.pages.GoogleSearchPage;
import automation.pages.GoogleSearchResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class GoogleSteps {
    private GoogleSearchPage googleSearchPage;
	private GoogleSearchResultsPage googleSearchResultsPage;

    public GoogleSteps(GoogleSearchPage commonGoogleSearchPage, GoogleSearchResultsPage commonGoogleSearchResultsPage) {
        googleSearchPage = commonGoogleSearchPage;
        googleSearchResultsPage = commonGoogleSearchResultsPage;
    }

	@Given("^I am using Google$")
	public void i_am_using_Google() throws Throwable {
	    googleSearchPage.load();
	}

	@When("^I search for (.*)$")
	public void i_search_for_search_term(String searchTerm) throws Throwable {
	    googleSearchPage.searchFor(searchTerm);
	}
	
	@Then("^I am shown search results for (.*)$")
	public void i_am_shown_search_results_for_search_term(String searchTerm) throws Throwable {
	    assertThat(googleSearchResultsPage.firstHitTitle().toLowerCase(), containsString(searchTerm));
	}
}
