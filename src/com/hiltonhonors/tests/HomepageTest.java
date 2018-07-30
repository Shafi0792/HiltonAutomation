package com.hiltonhonors.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.hiltonhonors.pages.HiltonHomePage;
import com.hiltonhonors.pages.HotelsResultsPage;


public class HomepageTest extends BaseTest{

	@Test(groups = {"Smoke", "Homepage"})
	public void ValidateSeachFunctionality() {
		//test data
		String location = "Florida City";
		String checkInDate = "15 Aug 2018";
		String checkOutDate = "22 Aug 2018";
		HiltonHomePage homepagePage = new HiltonHomePage(driver);
		HotelsResultsPage resultspagePage = homepagePage.searchHotels(location, checkInDate, checkOutDate);		
		String actualLocation = resultspagePage.getSearchLocationText(location);
		assertTrue(actualLocation.contains(location));	
		String actualDatesText = resultspagePage.getSearchDatesText();
		assertTrue(actualDatesText.contains(checkInDate));	
		assertTrue(actualDatesText.contains(checkOutDate));
		String matchingResults = resultspagePage.getMatchingHotelsText();
		assertTrue(matchingResults.contains("37"));			
	}
	
	

	
	
}
