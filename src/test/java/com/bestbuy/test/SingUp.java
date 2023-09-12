package com.bestbuy.test;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bestbuy.testcases.SignUpTestCase;
import com.bestbuy.utils.BaseUtils;
import com.bestbuy.utils.Reports;

// harish.venkatesan12023@gmail.com    427474@Harishrup

public class SingUp extends BaseUtils {
	
	public SignUpTestCase testCase = new SignUpTestCase();
	
	@Test(priority = 2)
	@Parameters({"firstName", "lastName", "mailID", "password", "mobileNumber", "errorMessagge", "errorMessagge2"})
	public void CreateNewAccount(String firstName, String lastName, String mailID, String password, String mobileNumber, String errorMessagge, String errorMessagge2) {
		
		Reports.setTCDesc("Validating Create An Account functionality");
		
		if (pom.getHomePage().getStoreNotification().isDisplayed()) {
			
			elementNotVisible(pom.getHomePage().getStoreNotification());
		}
		
		clickElement(pom.getHomePage().getAccountBtn(), testCase.getAccountPass(), testCase.getAccountFail());
		
		clickElement(pom.getHomePage().getCreatAccountBtn(), testCase.getCreateAccountPass(), testCase.getCreateAccountFail());
		
		typeText(pom.getCreateAccount().getFirstName(), firstName, testCase.getFirstNamePass(), testCase.getFirstNameFail());
		
		typeText(pom.getCreateAccount().getLastName(), lastName, testCase.getLastNamePass(), testCase.getLastNameFail());
		
		typeText(pom.getCreateAccount().getEmail(), mailID, testCase.getMailID_pass(), testCase.getMailID_Fail());
		
		typeText(pom.getCreateAccount().getPassword(), password, testCase.getPasswordPass(), testCase.getPasswordFail());
		
		typeText(pom.getCreateAccount().getConfirmPassword(), password, testCase.getConPasswordPass(), testCase.getConPasswordFail());
		
		typeText(pom.getCreateAccount().getMobile(), mobileNumber, testCase.getMailID_pass(), testCase.getMobileNumberFail());
		
		clickElement(pom.getCreateAccount().getAccountRecoveryCheckBox(), testCase.getRecoveryPass(), testCase.getRecoveryFail());
		
		scrollToElement(pom.getCreateAccount().getCreateAccountBtn());
		
		clickElement(pom.getCreateAccount().getCreateAccountBtn(), testCase.getCreateBtnPass(), testCase.getCreateBtnFail());
		
		try {
			
			String geterror = getElementText(pom.getCreateAccount().getErrorMessage());
			
			if (geterror.equals(errorMessagge) || geterror.equals(errorMessagge2)) {
				
				Reports.reportStep(Status.FAIL, "Create Account Failed");
				
			}else {
				
				Reports.reportStep(Status.PASS, "Create Account successfully");
			}
			
		} catch (Exception e) {
			
			System.out.println("problem on getting error message from the create account page");
			
			e.printStackTrace();
		}
		
	}
	

}


