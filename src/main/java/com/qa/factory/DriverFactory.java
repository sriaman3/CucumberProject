package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//will be helpful for parallel execution
public class DriverFactory {
	
	public WebDriver driver;
	
	//In thread local, you can set any object and this object will be local and global to the specific thread which is accessing this object.
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	/**
	 * This method is used to initialize the threadlocal driver on the basis of given browser
	 * @param browser
	 * @return Webdriver
	 */
	public WebDriver init_driver(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	/**
	 * get the driver through thread local
	 * @return Webdriver
	 */
	public static WebDriver getDriver() {
		//will give you the driver
		return tlDriver.get();
	}
}
