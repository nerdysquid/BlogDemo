package cucumberselenuim.cucumberseleniumexample;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "feature/JsfFormCheck.feature", 
		glue = { "cucumberselenuim.cucumberseleniumexample.CustomerRegistrationForm" }, 
//		plugin="com.infostretch.qmetrytestmanager.result.TestExecution",
		monochrome = true
	)
public class TestRunner {

}
