package com.bestbuy.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bestbuy.property.PropertyKey;
import com.bestbuy.testcases.LoginTestCase;
import com.bestbuy.utils.BaseUtils;
import com.bestbuy.utils.Reports;

public class LogIn extends BaseUtils{

	@Test
	@Parameters({"tryAgainMessage", "noMessage"})
	public void sigin(String tryAgainMessage, String noMessage) {
		
		LoginTestCase loginCase = new LoginTestCase();
		
		try {
			
			Reports.setTCDesc("Validating login functionality");
			
			elementNotVisible(pom.getHomePage().getStoreNotification());
			
			clickElement(pom.getHomePage().getAccountBtn(), loginCase.getAccountPass(), loginCase.getAccountFail());
			
			clickElement(pom.getHomePage().getLoginBtn(), loginCase.getSignInPass(), loginCase.getSignInFail());
			
			typeText(pom.getSignIn().getEmail(), property.getValue(PropertyKey.mailID.name()), loginCase.getMailPass(), loginCase.getMailFail());
			
			typeText(pom.getSignIn().getPassword(), property.getValue(PropertyKey.password.name()), loginCase.getPasswordPass(), loginCase.getPasswordFail());
			
			clickElement(pom.getSignIn().getSignIn(), loginCase.getSigInButtonPass(), loginCase.getSigInButtonFail());
			
			if (noMessage.equals("fail")) {
				
				waitTextPresent(pom.getSignIn().getErrorMessage(), tryAgainMessage);
			
				if(getElementText(pom.getSignIn().getErrorMessage()).equals(tryAgainMessage)) {
					
					Reports.reportStep(Status.FAIL, "login fail");
					
				}
				
			}else {
				
				Reports.reportStep(Status.PASS, "successfully login");
			}
			
		
		}catch(Exception e) {
			
			Reports.reportStep(Status.FAIL, "login fail");
			e.printStackTrace();
		}
	}
	
}
