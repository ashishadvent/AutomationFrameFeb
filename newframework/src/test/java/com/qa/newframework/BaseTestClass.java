/**
 * 
 */
package com.qa.newframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.BrowserDriverFactory;

/**
 * @author ashish 
 *
 */
public class BaseTestClass {
	
	protected WebDriver driver;	
	
	@Parameters({"browser"}) 
	//@BeforeClass(alwaysRun = true)
	  @Test 
	 public void setUp(@Optional("chrome") String browser) {
		//Create driver
		System.out.println("Create driver: " +browser);
		 
		BrowserDriverFactory driverfactory=new BrowserDriverFactory(browser);
		driver=driverfactory.createDriver();
	}
	@AfterClass(alwaysRun = true)
	//@AfterClass
	public void tearDown() {
		System.out.println("Closing the driver");
		driver.close();
		driver.quit();
	}
	
	
	
	
}
