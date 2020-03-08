/**
 * 
 */
package com.qa.newframework;
 
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.TestUtilities;

/** 
 * @author akesarwa
 *
 */
public class TC001 extends TestUtilities {
	//WebDriver driver=null;

		
	
@Parameters({"username","password","expectedMessage"})
@Test(priority=1)
 public void TC001_NegativeTest(String username,String password,String expectedErrorMessage) {
	  
	log.info("Starting negativeTest");

	// open main page
	String url = "http://the-internet.herokuapp.com/";
	driver.get(url);
	log.info("Main page is opened.");

	// Click on Form Authentication link
	driver.findElement(By.linkText("Form Authentication")).click();

	// enter username and password
	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);

	// push log in button
	driver.findElement(By.className("radius")).click();

	// Verification
	String actualErrorMessage = driver.findElement(By.id("flash")).getText();
	Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
			"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
					+ expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
	
}
	

}
