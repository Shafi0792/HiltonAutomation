package com.hiltonhonors.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//This Class contains actual Driver Object, Setup, Tear down methods.
public class BaseTest {
	
	
	public static WebDriver driver;
	

	static {
		System.setProperty("webdriver.chrome.driver", "C:\\HiltonAutomation\\Jars\\chromedriver.exe");
	}
	
	//setup
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://hiltonhonors3.hilton.com/en/index.html");
	}
	
	//tear down
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	
	
	
}
