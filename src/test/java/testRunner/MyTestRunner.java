package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				features ="src/test/resources/Features/Login1.feature",
				glue={"stepDef","hooks"},
				//tags = "@All",
				dryRun=false,
				monochrome = true,
				publish = true,
				plugin= {"pretty"}
				)
//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter"
/*
 * Scenario: Login Page Title Given user is on Login page When user gets the
 * title of the page Then page title should be "Login - My Store"
 * 
 * Scenario: forgot password link Given user is on Login page Then forgot
 * password link should displayed
 */
public class MyTestRunner {

}
