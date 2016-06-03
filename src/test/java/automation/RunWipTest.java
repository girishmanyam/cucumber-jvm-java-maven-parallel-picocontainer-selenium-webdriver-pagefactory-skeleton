package automation;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty"}, features = "src/test/resources", tags = {"@wip"}) //if you're on windows add `monochrome=true` for clean output
public class RunWipTest {
	
}
