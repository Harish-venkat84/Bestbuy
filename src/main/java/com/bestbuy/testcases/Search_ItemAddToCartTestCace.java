package com.bestbuy.testcases;

import lombok.Getter;

@Getter
public class Search_ItemAddToCartTestCace {
	
	private String enterTextPass = "User Entered Search Text on the search Field";
	private String enterTextFail = "problem on entering text on the search Field";

	private String selectFristResltPass = "Clicked the first Result on Search Result";
	private String selectFristResltFail = "problem on clicking on search result";
	
	private String selectFirstAddToCartPass = "User Clicked on Add To Cart of the First Listed Product";
	private String selectFirstAddToCartFail = "problem Clicking on Add To Cart of the First Listed Product";
	
	private String clickGoToCartPass = "User Clicked the Go To Cart Button";
	private String clickGoToCartFail = "problem on Clicking the Go To Cart Button";
}
