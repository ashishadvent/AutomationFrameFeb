/**
 * 
 */
package com.qa.base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author ashish 
 *
 */
public class BaseTestClass {
	
	protected WebDriver driver;	
	protected Logger log;
	
		
	@Parameters({"browser"}) 
	//@BeforeClass(alwaysRun = true)
	  @Test 
	 public void setUp(@Optional("chrome") String browser,ITestContext ctx) {
		//Create driver
		String testName=ctx.getCurrentXmlTest().getName();
		DOMConfigurator.configure("log4j.xml");
		log=LogManager.getLogger(testName);
		log.info("Create driver: " +browser);
		 
		BrowserDriverFactory driverfactory=new BrowserDriverFactory(browser, log);
		driver=driverfactory.createDriver();
	}
	@AfterClass(alwaysRun = true)
	//@AfterClass
	public void tearDown() {
		log.info("Closing the driver");
		driver.close();
		driver.quit();
	}
	
	
	
	
}
