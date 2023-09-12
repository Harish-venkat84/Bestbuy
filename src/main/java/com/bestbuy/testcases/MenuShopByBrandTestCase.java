package com.bestbuy.testcases;

import com.bestbuy.property.FileReaderManager;

import lombok.Getter;

@Getter
public class MenuShopByBrandTestCase {

	FileReaderManager property = new FileReaderManager();
	
	private String menuPass = "User Clicked on Menu List";
	private String menuFail = "problem on Clicking Menu List";
	
	private String SelectBrandListPass = "User Selected the brand from the menu list";
	private String SelectBrandListFail = "problem Selecting the brand from the menu list";

	public String selectBrandPass() {return "User click the " + property.getValue("brandName")+ " Brand";}
	public String selectBrandFail() {return "problem clicking the " + property.getValue("brandName")+ " Brand";}
	
	public String SelectProductsPass() {return "User click the "+property.getValue("brandProductName")+" products";}
	public String SelectProductsFail() {return "problem clicking the "+property.getValue("brandProductName")+" products";}
	
	public String SelectPhonePass() {return "User click the "+property.getValue("productName")+" phone";}
	public String SelectPhoneFail() {return "User click the "+property.getValue("productName")+" phone";}
	
	private String selectPayPass = "User Select Active Today";
	private String selectPayFail = "problem on Selecting Active Today";
	
	private String addtoCartPass = "Click the Add To Cart button";
	private String addtoCartFail = "Problem Clicking the Add To Cart button";
	
	private String startpass = "click the Lest's Get Started button";
	private String startFail = "problem clicking the Lest's Get Started button";
	
	private String noPass = "User Select the No";
	private String noFail = "problem on selecting No";
	
	private String continuePass = "Click the Continue Button";
	private String continueFail = "Problem on clicking Continue Button";
	
	private String noThankPass = "User Select the No Thank";
	private String noThankFail = "problem on selecting No Thank";
	
	private String selectNewNumberPass = "Select the Get a new number";
	private String selectNewNumberFail = "problem Selecting the Get a new number";
	
	private String selectPlanPass = "User select the Select Plan";
	private String selectPlanFail = "problem on Selecting the Select Plan";

	private String clickGoToCartPass = "User Clicked the Go To Cart Button";
	private String clickGoToCartFail = "problem on Clicking the Go To Cart Button";
	
}
