package com.bestbuy.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bestbuy.property.PropertyKey;
import com.bestbuy.testcases.LoginTestCase;
import com.bestbuy.utils.BaseUtils;
import com.bestbuy.utils.Reports;

public class ChooseCountry extends BaseUtils {

	@Test(priority = 0)
	public void selectCountry() {
		
		LoginTestCase loginCase = new LoginTestCase();

		clickElement(pom.getSelectCountryPage().getContryUS(), loginCase.getSelectCountryPass(), loginCase.getSelectCountryFail());
		
		String pageTitel = getPageTitel();
		
		try {
			
			Assert.assertEquals(pageTitel, property.getValue(PropertyKey.HomePageTitle.name()));
			Reports.reportStep(Status.PASS, "The given titile matches => "+PropertyKey.HomePageTitle.name());
			
//			if (pom.getHomePage().getPoupNoThank().isDisplayed()) {
//	
//				clickElement(pom.getHomePage().getPoupNoThank());
//			}

		} catch (Exception e) {
		
			System.out.println("problem on Asser Equal Title on SeleContry method");
			Reports.reportStep(Status.FAIL, "The given titile not matches => "+PropertyKey.HomePageTitle.name());
			
			e.printStackTrace();
		}
		
	}

	
}
