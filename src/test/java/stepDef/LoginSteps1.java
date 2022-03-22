package stepDef;

import org.junit.Assert;

import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginSteps1 {
	private String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("user is on Login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		 title = loginPage.getLoginPageTitle();
		 System.out.println(title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		System.out.println(expectedTitleName);
		Assert.assertTrue(title.contains(expectedTitleName));
	}


	@Then("forgot password link should displayed")
	public void forgot_password_link_should_displayed() {
	   Assert.assertTrue(loginPage.isForgotLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String userName) {
	    loginPage.setUserName(userName);
	}

	@When("user enter password {string}")
	public void user_enter_password(String password) {
		loginPage.setPassword(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}


}
