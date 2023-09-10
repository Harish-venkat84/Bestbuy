package com.bestbuy.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bestbuy.utils.BaseUtils;

public class CheckoutValidation extends BaseUtils{

	@Test(priority = 2)
	@Parameters({"cityCode", })
	public void checkout() {
		
		try {

			clickElement(pom.getCart().getSelectStore());
			
			waitForPresenceOfAllElements(10, "//button[text() = 'Go!']");
			
			waitForElementClickable(10, pom.getCart().getGoBtn());
			
			Thread.sleep(3000);
			
			typeText(pom.getCart().getInputCityCode(), "99504");
			
			clickElement(pom.getCart().getGoBtn());
			
			visibleOfElement(10, pom.getCart().getPickHere().get(0));
			
			clickElement(pom.getCart().getPickHere().get(0));
			
			waitForElementClickable(10, pom.getCart().getCheckout());
			
			Thread.sleep(3000);
			
			clickElement(pom.getCart().getCheckout());
			
			clickElement(pom.getCheckout().getContinueGuest());
			
			actionScroll(pom.getCheckout().getEmailID());
			
			typeText(pom.getCheckout().getEmailID(), property.getValue("mailID"));
			
			typeText(pom.getCheckout().getPhoneNumber(), property.getValue("mobileNumber"));
			
			clickElement(pom.getCheckout().getContinueMobile());
			
			String error = getElementText(pom.getCheckout().getErrorMeassage());
			
			if (error.equals("Sorry, there was a problem. Please try that again.")) {
				
				System.out.println(error);
			}
			
		} catch (Exception e) {
			
			
			e.printStackTrace();
		}
	}
	
}
