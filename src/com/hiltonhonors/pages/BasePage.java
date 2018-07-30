package com.hiltonhonors.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage{
	protected WebDriver driver;	
	
	public BasePage(WebDriver driver) {		
		this.driver = driver;
	}

	//click
	public void click(By locator) {
		waitForElementVisibility(locator);
		ScrollToElement(locator);
		driver.findElement(locator).click();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	//switch to child window
	public void switchToChildWindow() {
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
	}
	
	//switch to default content
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	//close browser
	public void closeBrowser() {
		driver.close();
	}
	
	//find all elements
	public List<WebElement> findAll(By locator) {
		waitForElementVisibility(locator);
		List<WebElement> elements = driver.findElements(locator);
		return elements;
	}
	
	//enter text
	public void enter(By locator, String text, Boolean clearField) {
		waitForElementVisibility(locator);
		if(clearField) {
			driver.findElement(locator).clear();
		}
		driver.findElement(locator).sendKeys(text);
	}
	
	
	//common wait for all actions
	public void waitForElementVisibility(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	//common wait 
	public void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public WebElement ScrollToElement(By locator)
	{
	    WebElement element = driver.findElement(locator);
	    return ScrollToElement(element);
	 }
	
	public WebElement ScrollToElement(WebElement element)
	{
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(" + element.getLocation().x+ "," +(element.getLocation().y- 100) + ");");
	    return element;
	 }
	
}
