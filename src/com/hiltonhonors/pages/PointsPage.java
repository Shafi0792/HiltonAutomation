package com.hiltonhonors.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PointsPage extends BasePage {

	public PointsPage(WebDriver driver) {
		super(driver); 
	}
	
	private By crediCardsLink() {
		return By.xpath("//div[@id='secondary_nav']//a[text()='Credit Cards']");
	}
	
	private By creditCardCollapseLinks() {
		return By.xpath("//div[@class='accordion_element']//b//span[@class='collapse']");
	}
	
	private By creditCardheaders() {
		return By.xpath("//div[@class='accordion_element']");
	}
	
	private By creditCardExpandLinks() {
		return By.xpath("//div[@class='accordion_element']//b//span[@class='Expand']");
	}
	
	private By ratesFeeLink(String creditCardName) {
		return By.xpath("//strong[text()='"+creditCardName+"']/parent::p/parent::td//a[text()='*Rates and Fees']");
	}
	
	
	public void clickCreditCardsLink() {
		click(crediCardsLink());
	}
	
	public String getHiltonHonorCardsText() {
		return driver.findElement(By.xpath("//*[@id='1341239951592']/div/div/div/div/div[1]/p[2]")).getText();
		
	}
	
	public void clickRatesFeeLink(String href) {
		click(ratesFeeLink(href));
	}
	
	public void assertCreditCardsCount(int count) {
		List<WebElement> creditCards = findAll(creditCardheaders());
		Assert.assertEquals(creditCards.size(), count);
	}
	
	public void collapseCreditCards() {
		List<WebElement> creditCardLinks = findAll(creditCardCollapseLinks());
		for(WebElement creditcard: creditCardLinks) {
			ScrollToElement(creditcard);
			creditcard.click();
			wait(1);
		}
	}
}
