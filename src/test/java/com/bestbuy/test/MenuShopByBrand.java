package com.bestbuy.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.bestbuy.utils.BaseUtils;

public class MenuShopByBrand extends BaseUtils{

	@Test(priority = 1)
	public void selectByBrand() {
		
		try {
		
		clickElement(pom.getHomePage().getMenuButton());
		
		clickElement(pom.getHomePage().selectMenuByText("Brands"));
		
		clickElement(pom.getHomePage().selectOneName(property.getValue("brandName")));
		
		clickElement(pom.getHomePage().selectOneName(property.getValue("brandProductName")));
		
		List<WebElement> brandProduct = pom.getBrandsPage().brandProduct(property.getValue("brandProductName"));
		
		actionScroll(brandProduct.get(brandProduct.size()-1));
		
		clickElement(brandProduct.get(brandProduct.size()-1));
		
		List<WebElement> selectProductName = pom.getBrandsPage().selectProductName(property.getValue("productName"));
		
		clickElement(selectProductName.get(selectProductName.size()-1));
		
		actionScroll(pom.getBrandsPage().getPayToday());
		
		clickElement(pom.getBrandsPage().getPayToday());
		
		actionScroll(pom.getSearchResult().getSelectFirstItemAddToCart());
		
		clickElement(pom.getSearchResult().getSelectFirstItemAddToCart());
		
		clickElement(pom.getBrandsPage().getLetGetStartedBtn());
		
		clickElement(pom.getBrandsPage().getSelectNo());
		
		clickElement(pom.getBrandsPage().getSelectContinueBtn());
		
		clickElement(pom.getBrandsPage().getSelectNoThanksBtn());
		
		clickElement(pom.getBrandsPage().getSelectContinueWithOutTradeBtn());
		
		clickElement(pom.getBrandsPage().getSelectGetNewNumber());
		
		clickElement(pom.getBrandsPage().selectContinueBtn().get(pom.getBrandsPage().selectContinueBtn().size()-1));
		
		waitForPresenceOfAllElements(30, "//span[text() = 'Select Plan']//parent::button");
		
		clickElement(pom.getBrandsPage().selectPlanBtn().get(0));
		
		clickElement(pom.getBrandsPage().getSelectContinueBtn());
		
		waitForPresenceOfAllElements(20, "//span[text() = 'Continue']//parent::button");
		
		waitForElementClickable(20, pom.getBrandsPage().getSelectContinueBtn());
		
		visibleOfElement(20, pom.getBrandsPage().getSelectContinueBtn());
		
		Thread.sleep(4000);
		
		clickElement(pom.getBrandsPage().getSelectContinueBtn());
		
		waitForPresenceOfAllElements(20, "//span[text() = 'Continue']//parent::button");
		
		waitForElementClickable(20, pom.getBrandsPage().getSelectContinueBtn());
		
		Thread.sleep(5000);
		
		visibleOfElement(20, pom.getBrandsPage().getSelectContinueBtn());
		
		actionScroll(pom.getBrandsPage().getSelectContinueBtn());
		
		clickElement(pom.getBrandsPage().getSelectContinueBtn());
		
		clickElement(pom.getBrandsPage().getGoToCart());
		
		}catch(Exception e) {
			
			System.out.println("problem on validating the shop by brand");
			e.printStackTrace();
		}
	}

}
