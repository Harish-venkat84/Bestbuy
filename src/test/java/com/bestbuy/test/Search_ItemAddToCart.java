package com.bestbuy.test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bestbuy.testcases.Search_ItemAddToCartTestCace;
import com.bestbuy.utils.BaseUtils;
import com.bestbuy.utils.Reports;

public class Search_ItemAddToCart extends BaseUtils{

	static Search_ItemAddToCartTestCace testCase = new Search_ItemAddToCartTestCace();
	
	@Test
	public void validatingSearchAndCart() {
		
		try {
				
			Reports.setTCDesc("Validating Search functionality");
		
			typeText(pom.getHomePage().getSearchField(), "laptop", testCase.getEnterTextPass(), testCase.getEnterTextFail());
			
			clickElement(pom.getHomePage().getSelectFirstSearchResult(),
					testCase.getSelectFristResltPass(), testCase.getSelectFristResltFail());
			
			scrollToElement(pom.getSearchResult().getFirstItemText());
			
			String firstText = getElementText(pom.getSearchResult().getFirstItemText());
			
			clickElement(pom.getSearchResult().getSelectFirstItemAddToCart(),
					testCase.getSelectFirstAddToCartPass(), testCase.getSelectFirstAddToCartFail());
			
			visibleOfElement(10, pom.getSearchResult().getGoToCart());
			
			clickElement(pom.getSearchResult().getGoToCart(), testCase.getClickGoToCartPass(), testCase.getClickGoToCartFail());
			
			visibleOfElement(10, pom.getCart().getCartItemName());
			
			String cartItemName = getElementText(pom.getCart().getCartItemName());
			
			if (firstText.equals(cartItemName)) {
				
				System.out.println("added product name and cart product name are matching");
				
				Reports.reportStep(Status.PASS, "Search Functionality Working Successfully");
				
			}else {
				
				System.out.println("both are not matching");
				
				Reports.reportStep(Status.FAIL, "Search Functionality Fail");
			}
			
		} catch (Exception e) {

		}
	}
	
}
