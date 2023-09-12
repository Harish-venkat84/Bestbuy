package com.bestbuy.testcases;

import lombok.Getter;

@Getter
public class CheckOutTestCase {

	private String SelectStorePass = "User Select the 'Select a store to see availability'";
	private String SelectStoreFail = "problem Selecting the 'Select a store to see availability'";
	
	private String cityCodePass = "Enter the City code";
	private String cityCodeFail = "problem on entering city code";
	
	private String goPass = "User click the Go button";
	private String goFail = "problem on clicking Go button";
	
	private String pickUpHerePass = "Click 'pick up here'";
	private String pickUpHereFail = "problem on clicking 'Pick up here'";
	
	private String checkOutPass = "click Checkout Button";
	private String checkOutFail = "problem clicking Checkout Button";
	
	private String guestPass = "Click 'Continue as Guest' button";
	private String guestFail = "problem Clicking 'Continue as Guest' button";
	
	private String emailPass = "Enter your Email Id";
	private String emailFail = "problem Entering your Email Id";

	private String mobilePass = "Enter your Mobile number";
	private String mobileFail = "problem Entering your Mobile number";
	
	private String continuePass = "User click Continue to Mobile Setup button";
	private String continueFail = "problem clicking Continue to Mobile Setup button";

}
