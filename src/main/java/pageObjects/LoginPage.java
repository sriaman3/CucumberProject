package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	//Should not write assertion in page class
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void setUserName(String userName) {
		driver.findElement(emailId).sendKeys(userName);
	}
	
	public void setPassword(String passwrd) {
		driver.findElement(password).sendKeys(passwrd);
	}
	
	public void clickOnLogin() {
		driver.findElement(signInButton).click();
	}
	
	public AccountsPage doLogin(String uN, String pwd) {
		driver.findElement(emailId).sendKeys(uN);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		return new AccountsPage(driver);
	}

}
