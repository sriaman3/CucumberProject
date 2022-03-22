package stepDef;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.AccountsPage;
import pageObjects.LoginPage;

public class AccountPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
	    List<Map<String, String>> credList = credTable.asMaps();
	    String username = credList.get(0).get("username");
	    String password = credList.get(0).get("password");
	    DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	    accountsPage = loginPage.doLogin(username, password);
	}

	@Given("user is on Accounts Page")
	public void user_is_on_accounts_page() {
		accountsPage.getAccountPageTitle();
	}
	    

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionTable) {
		List<String> expAccountSectionList = sectionTable.asList();
		
		List<String> actualAccountSectionList = accountsPage.getAccountSectionList();
		Assert.assertTrue(expAccountSectionList.containsAll(actualAccountSectionList));
	}

	@Then("account section count should be {int}")
	public void account_section_count_should_be(Integer expectedSecCount) {
		
	    Assert.assertTrue(accountsPage.getAccountSectionCount() == expectedSecCount);
	}

}
