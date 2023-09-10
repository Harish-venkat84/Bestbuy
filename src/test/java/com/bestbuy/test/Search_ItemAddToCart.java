package com.bestbuy.test;

import org.testng.annotations.Test;

import com.bestbuy.utils.BaseUtils;

public class Search_ItemAddToCart extends BaseUtils{

	@Test
	public void validatingSearchAndCart() {
		
		try {
		
			typeText(pom.getHomePage().getSearchField(), "laptop");
			
			clickElement(pom.getHomePage().getSelectFirstSearchResult());
			
			scrollToElement(pom.getSearchResult().getFirstItemText());
			
			String firstText = getElementText(pom.getSearchResult().getFirstItemText());
			
			clickElement(pom.getSearchResult().getSelectFirstItemAddToCart());
			
			visibleOfElement(10, pom.getSearchResult().getGoToCart());
			
			clickElement(pom.getSearchResult().getGoToCart());
			
			visibleOfElement(10, pom.getCart().getCartItemName());
			
			String cartItemName = getElementText(pom.getCart().getCartItemName());
			
			if (firstText.equals(cartItemName)) {
				
				System.out.println("added product name and cart product name are matching");
			}else {
				
				System.out.println("both are not matching");
			}
			
		} catch (Exception e) {

		}
	}
	
}
