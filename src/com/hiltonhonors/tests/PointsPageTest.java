package com.hiltonhonors.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hiltonhonors.pages.HiltonHomePage;
import com.hiltonhonors.pages.PointsPage;

public class PointsPageTest extends BaseTest{		
			
	@DataProvider(name = "creditCards")
	public Object[][] creditCards() {
		return new Object[][] { 
	    	 {"Hilton Honors American Express Ascend Card", "hilton-honors-ascend-credit-card"},
	    	 {"Hilton Honors American Express Aspire Card", "hilton-honors-aspire-credit-card"},
	    	 {"Hilton Honors American Express Card", "hilton-honors-credit-card"},
	    	 {"Hilton Honors American Express Business Card", "hilton-honors-american-express-business-credit-card"}
	    };
	}
	
	//This Test Case Verify available credit cards
	@Test(groups = {"Smoke", "PointsPage"}, dataProvider = "creditCards")
	@Parameters({ "creditCardName", "creditCardPartialUrl" })
	public void ValidateCreditCards(String creditCardName, String creditCardPartialUrl) {
		HiltonHomePage homePage = new HiltonHomePage(driver);
		PointsPage pointsPage = homePage.clickPointsHeader();		
		pointsPage.clickCreditCardsLink();
		String creditCardsTxt = pointsPage.getHiltonHonorCardsText();
		assertTrue(creditCardsTxt.contains("four"));	
		String parentWindow = driver.getWindowHandle();
		pointsPage.clickRatesFeeLink(creditCardName);
		pointsPage.switchToChildWindow();
		assertTrue(driver.getCurrentUrl().contains(creditCardPartialUrl));
		driver.close();
		driver.switchTo().window(parentWindow);
	}
	
	
}
