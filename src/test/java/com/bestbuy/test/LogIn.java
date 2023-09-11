package com.bestbuy.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bestbuy.property.PropertyKey;
import com.bestbuy.testcases.LoginTestCase;
import com.bestbuy.utils.BaseUtils;
import com.bestbuy.utils.Reports;

public class LogIn extends BaseUtils{

	@Test(priority = 1)
	@Parameters({"errorMessage", "errorMessage2"})
	public void sigin(String errorMessage, String errorMessage2) {
		
		LoginTestCase loginCase = new LoginTestCase();
		
		try {
			
			Reports.setTCDesc("Validating login functionality");
			
			elementNotVisible(pom.getHomePage().getStoreNotification());
			
			clickElement(pom.getHomePage().getAccountBtn(), loginCase.getAccountPass(), loginCase.getAccountFail());
			
			clickElement(pom.getHomePage().getLoginBtn(), loginCase.getSignInPass(), loginCase.getSignInFail());
			
			typeText(pom.getSignIn().getEmail(), property.getValue(PropertyKey.mailID.name()), loginCase.getMailPass(), loginCase.getMailFail());
			
			typeText(pom.getSignIn().getPassword(), property.getValue(PropertyKey.password.name()), loginCase.getPasswordPass(), loginCase.getPasswordFail());
			
			clickElement(pom.getSignIn().getSignIn(), loginCase.getSigInButtonPass(), loginCase.getSigInButtonFail());
			
			String message = null;
			
			if (pom.getSignIn().getErrorMessage().isDisplayed()) {
				
				message = getElementText(pom.getSignIn().getErrorMessage());
			}
			
			if (message.equals(errorMessage) || message.equals(errorMessage2)) {
				
					Reports.reportStep(Status.FAIL, "login fail");
					
			}else {
				
				Reports.reportStep(Status.PASS, "successfully login");
			}
			
//			launchNewURL(property.getURL());
		
		}catch(Exception e) {
			
			Reports.reportStep(Status.FAIL, "login fail");
			e.printStackTrace();
		}
	}
	
}
