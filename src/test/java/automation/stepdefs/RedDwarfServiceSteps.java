package automation.stepdefs;

import automation.config.TestConfig;
import automation.services.BBCService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedDwarfServiceSteps {
    private BBCService bbcService;
    private String title;
    private String shortSynopsis;
    private final Logger log = LoggerFactory.getLogger(RedDwarfServiceSteps.class);

    @Given("^I query the bbc for information about Red Dwarf$")
    public void i_query_the_bbc_for_information_about_Red_Dwarf() throws Throwable {
        log.info(TestConfig.valueFor("RedDwarfBaseUrl"));
        bbcService = new BBCService(TestConfig.valueFor("RedDwarfBaseUrl"));
    }

    @When("^I look at the programme overview$")
    public void i_look_at_the_programme_overview() throws Throwable {
        title = bbcService.getTitle();
        shortSynopsis = bbcService.getShortSynopsis();
    }

    @Then("^I can see the title$")
    public void i_can_see_the_title() throws Throwable {
        assertThat(title, is("Red Dwarf"));
    }

    @Then("^I can see the short synopsis$")
    public void i_can_see_the_short_synopsis() throws Throwable {
        assertThat(shortSynopsis, is("Cult space comedy by Rob Grant and Doug Naylor."));
    }
}
