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
<<<<<<< HEAD
	@Parameters({"loginErrorMessage", "loginErrorMessage2"})
	public void sigin(String loginErrorMessage, String loginErrorMessage2) {
=======
	@Parameters({"errorMessage", "errorMessage2"})
	public void sigin(String errorMessage, String errorMessage2) {
>>>>>>> 80c1bc270b4355122a0dbf4460046b6f7ded1d37
		
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
			
<<<<<<< HEAD
			if (message.equals(loginErrorMessage) || message.equals(loginErrorMessage2)) {
=======
			if (message.equals(errorMessage) || message.equals(errorMessage2)) {
>>>>>>> 80c1bc270b4355122a0dbf4460046b6f7ded1d37
				
					Reports.reportStep(Status.FAIL, "login fail");
					
			}else {
				
				Reports.reportStep(Status.PASS, "successfully login");
			}
			
<<<<<<< HEAD
			launchNewURL(property.getURL());
=======
//			launchNewURL(property.getURL());
>>>>>>> 80c1bc270b4355122a0dbf4460046b6f7ded1d37
		
		}catch(Exception e) {
			
			Reports.reportStep(Status.FAIL, "login fail");
			e.printStackTrace();
		}
	}
	
}
