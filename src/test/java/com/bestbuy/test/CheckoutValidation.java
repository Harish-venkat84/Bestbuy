package com.bestbuy.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bestbuy.testcases.CheckOutTestCase;
import com.bestbuy.utils.BaseUtils;
import com.bestbuy.utils.Reports;

public class CheckoutValidation extends BaseUtils{

	static CheckOutTestCase testCase = new CheckOutTestCase();
	
	@Test(priority = 2)
	@Parameters({"cityCode", })
	public void checkout() {
		
		try {
			
			Reports.setTCDesc("Validating Checkout functionality");

			clickElement(pom.getCart().getSelectStore(), testCase.getSelectStorePass(), testCase.getSelectStoreFail());
			
			waitForPresenceOfAllElements(10, "//button[text() = 'Go!']");
			
			waitForElementClickable(10, pom.getCart().getGoBtn());
			
			Thread.sleep(3000);
			
			typeText(pom.getCart().getInputCityCode(), "99504", testCase.getCityCodePass(), testCase.getCityCodeFail());
			
			clickElement(pom.getCart().getGoBtn(), testCase.getGoPass(), testCase.getGoFail());
			
			visibleOfElement(10, pom.getCart().getPickHere().get(0));
			
			clickElement(pom.getCart().getPickHere().get(0), testCase.getPickUpHerePass(), testCase.getPickUpHereFail());
			
			waitForElementClickable(10, pom.getCart().getCheckout());
			
			Thread.sleep(3000);
			
			clickElement(pom.getCart().getCheckout(), testCase.getCheckOutPass(), testCase.getCheckOutFail());
			
			clickElement(pom.getCheckout().getContinueGuest(), testCase.getGuestPass(), testCase.getGuestFail());
			
			actionScroll(pom.getCheckout().getEmailID());
			
			typeText(pom.getCheckout().getEmailID(), property.getValue("mailID"),
					testCase.getEmailPass(), testCase.getEmailFail());
			
			typeText(pom.getCheckout().getPhoneNumber(), property.getValue("mobileNumber"),
					testCase.getMobilePass(), testCase.getMobileFail());
			
			clickElement(pom.getCheckout().getContinueMobile(), testCase.getContinuePass(), testCase.getContinueFail());
			
			String error = getElementText(pom.getCheckout().getErrorMeassage());
			
			if (error.equals("Sorry, there was a problem. Please try that again.")) {
				
				Reports.reportStep(Status.FAIL, "Fail Checkout");
				
				System.out.println(error);
			}
			
		} catch (Exception e) {
			
			
			e.printStackTrace();
		}
	}
	
}
