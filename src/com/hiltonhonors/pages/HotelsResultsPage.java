package com.hiltonhonors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HotelsResultsPage extends BasePage {
	
	public HotelsResultsPage(WebDriver driver) {
		super(driver);
	}	
	
	private WebElement getSearchLocationElement() {
		return driver.findElement(By.xpath("//p[@class='searchSummary']//span[@class='sumLocation']"));
	}
	
	private WebElement getSearchDatesElement() {		
		return driver.findElement(By.xpath("//p[@class='searchSummary']//span[@class='sumDates']"));
	}
	
	public String getSearchLocationText(String searchLocation) {
		return getSearchLocationElement().getText();		
	}
	
	public String getSearchDatesText() {
		return getSearchDatesElement().getText();
	}	

	public String getMatchingHotelsText(){		
		return driver.findElement(By.xpath("//*[@id='resultsCapTopper']/p")).getText();
	}
}
