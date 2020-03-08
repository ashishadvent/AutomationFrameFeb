package com.qa.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	String browser;
	Logger log;
	public BrowserDriverFactory(String browser,Logger log){
		this.browser=browser.toLowerCase();
		this.log=log;
	}
	public WebDriver createDriver() {
		
		log.info("Creating WebDriver object in BrowserDriverFactory Class"+browser);
		
		switch(browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;
			
		case "firefox":
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
			driver.set(new FirefoxDriver());
			break;
			
		
		case "ie":
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
			driver.set(new InternetExplorerDriver());
			break;
		
		default:
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;	
			
			
		}
		return driver.get();
		
	}
}
