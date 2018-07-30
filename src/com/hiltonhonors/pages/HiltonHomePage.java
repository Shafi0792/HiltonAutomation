package com.hiltonhonors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HiltonHomePage extends BasePage {	
	
	public HiltonHomePage(WebDriver driver) {
		super(driver);
		 
	}	
	private By searchBox() {
		return By.xpath("//input[@id='hotelSearchOneBox']");
	}
	
	private By locationOptionByName(String location) {
		return By.xpath("(//li[contains(@id, 'location')]//b[text()='"+location+"'])[1]");
	}
	
	private By checkInDateField() {
		return By.xpath("//input[@id='checkin']");
	}

	private By checkOutDateField() {
		return By.xpath("//input[@id='checkout']");
	}
	
	private By findBtn() {
		return By.xpath("//a[@title='Find it']");
	}
	
	private By pointsHeader() {
		return By.xpath("//a[@id='Points']");
	}	
	
	
	//enter search Key
	public void enterSearchKey(String searchKey) {
		enter(searchBox(), searchKey, true);
	}
	
	//click location option
	public void clickLocationOptionByName(String location) {
		click(locationOptionByName(location));
	}	

	//enter checkin date
	public void enterCheckInDate(String checkInDate) {
		enter(checkInDateField(), checkInDate, true);
	}

	//enter checkout date
	public void enterCheckOutDate(String checkOutDate) {
		enter(checkOutDateField(), checkOutDate, true);
	}
	
	
	//click find button
	public void clickFindBtn() {
		click(findBtn());
	}		
	
	
	//enter Search Criteria
	public HotelsResultsPage searchHotels(String location, String checkInDate, String checkOutDate) {
		enterSearchKey(location);
		clickLocationOptionByName(location);
		enterCheckInDate(checkInDate);
		enterCheckOutDate(checkOutDate);
		clickFindBtn();
		return new HotelsResultsPage(driver);
	}	
	
	//click points header
	public PointsPage clickPointsHeader() {
		click(pointsHeader());
		return new PointsPage(driver);
		}	
	
	
	
}
