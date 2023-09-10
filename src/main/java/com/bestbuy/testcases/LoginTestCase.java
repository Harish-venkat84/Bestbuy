package com.bestbuy.testcases;

import lombok.Getter;

@Getter
public class LoginTestCase {
	
	private String selectCountryPass = "User clicked on the given country successfully";
	private String selectCountryFail = "problem on selecting the given country";

	private String accountPass = "User clicked the account field successfully";
	private String accountFail = "problem on the clicking on the account field";
	
	private String signInPass = "SigIn button clicked successfully and navigate to sigIn page";
	private String signInFail = "problem on clicking sigIn button";
	
	private String mailPass = "User Entered the Mail Id in the Input Field";
	private String mailFail = "Problem on Entering the Mail ID";
	
	private String passwordPass = "Entered the Password in the Password Field";
	private String passwordFail = "Problem on Entering the Password";
	
	private String sigInButtonPass = "SigIn button clicked successfully";
	private String sigInButtonFail = "problem on clicking SigIn button";
	
	

}
