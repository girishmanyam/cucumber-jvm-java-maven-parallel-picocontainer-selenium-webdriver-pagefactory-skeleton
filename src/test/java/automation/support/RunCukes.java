package automation.support;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty"}, features = "classpath:", glue = {"automation.stepdefs"}) //if you're on windows add `monochrome=true` for clean output
public class RunCukes { }
