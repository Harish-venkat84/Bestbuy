package com.bestbuy.testcases;

import lombok.Getter;

@Getter
public class SignUpTestCase {
	
	String testData = "";

	private String accountPass = "User clicked the account field successfully";
	private String accountFail = "problem on the clicking on the account field";
	
	private String createAccountPass = "Create Account button clicked successfully and navigate to Account creation page";
	private String createAccountFail = "problem on clicking Create Account button";
	
	private String firstNamePass = "User Entered the First name in the Input Field";
	private String firstNameFail = "Problem on Entering the First Name";
	
	private String lastNamePass = "User Entered the Last Name in the Input Field";
	private String lastNameFail = "Problem on Entering the Last Name";
	
	private String mailID_pass = "User Entered the Mail ID in the Input Field";
	private String mailID_Fail = "Problem on Entering the Mail ID";
	
	private String passwordPass = "User Entered the Password in the Input Field";
	private String PasswordFail = "Problem on Entering the Password";
	
	private String conPasswordPass = "User Entered the Confirm Password in the Input Field";
	private String conPasswordFail = "Problem on Entering the Confirm Password";
	
	private String mobileNumberPass = "User Entered the Mobile Number in the Input Field";
	private String mobileNumberFail = "Problem on Entering the Mobile Number";
	
	private String recoveryPass = "clicked the 'Use for Account Recovery' check box";
	private String recoveryFail = "problem on clicking the 'Use for Account Recovery' check box";
	
	private String createBtnPass = "Create Account clicked successfully";
	private String createBtnFail = "problem on clicking Create Account";
	
}
