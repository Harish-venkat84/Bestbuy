package com.bestbuy.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.bestbuy.testcases.MenuShopByBrandTestCase;
import com.bestbuy.utils.BaseUtils;
import com.bestbuy.utils.Reports;

public class MenuShopByBrand extends BaseUtils{

	static MenuShopByBrandTestCase testCase = new MenuShopByBrandTestCase();
	
	@Test(priority = 1)
	public void selectByBrand() {
		
		try {
			
		Reports.setTCDesc("Validating Menu Brand functionality");
		
		clickElement(pom.getHomePage().getMenuButton(), testCase.getMenuPass(), testCase.getMenuFail());
		
		clickElement(pom.getHomePage().selectMenuByText("Brands"), testCase.getSelectBrandListPass(), testCase.getSelectBrandListFail());
		
		clickElement(pom.getHomePage().selectOneName(property.getValue("brandName")),
				testCase.selectBrandPass(), testCase.selectBrandFail());
		
		clickElement(pom.getHomePage().selectOneName(property.getValue("brandProductName")),
				testCase.SelectProductsPass(), testCase.SelectProductsFail());
		
		List<WebElement> brandProduct = pom.getBrandsPage().brandProduct(property.getValue("brandProductName"));
		
		actionScroll(brandProduct.get(brandProduct.size()-1));
		
		clickElement(brandProduct.get(brandProduct.size()-1),
				testCase.SelectProductsPass(), testCase.SelectProductsFail());
		
		List<WebElement> selectProductName = pom.getBrandsPage().selectProductName(property.getValue("productName"));
		
		clickElement(selectProductName.get(selectProductName.size()-1), testCase.SelectPhonePass(), testCase.SelectPhoneFail());
		
		actionScroll(pom.getBrandsPage().getPayToday());
		
		clickElement(pom.getBrandsPage().getPayToday(), testCase.getSelectPayPass(), testCase.getSelectPayFail());
		
		actionScroll(pom.getSearchResult().getSelectFirstItemAddToCart());
		
		clickElement(pom.getSearchResult().getSelectFirstItemAddToCart(), testCase.getAddtoCartPass(), testCase.getAddtoCartFail());
		
		clickElement(pom.getBrandsPage().getLetGetStartedBtn(), testCase.getStartpass(), testCase.getStartFail());
		
		clickElement(pom.getBrandsPage().getSelectNo(), testCase.getNoPass(), testCase.getNoFail());
		
		clickElement(pom.getBrandsPage().getSelectContinueBtn(), testCase.getContinuePass(), testCase.getContinueFail());
		
		clickElement(pom.getBrandsPage().getSelectNoThanksBtn(), testCase.getNoThankPass(), testCase.getNoThankFail());
		
		clickElement(pom.getBrandsPage().getSelectContinueWithOutTradeBtn(), testCase.getContinuePass(), testCase.getContinueFail());
		
		clickElement(pom.getBrandsPage().getSelectGetNewNumber(), testCase.getSelectNewNumberPass(), testCase.getSelectNewNumberFail());
		
		clickElement(pom.getBrandsPage().selectContinueBtn().get(pom.getBrandsPage().selectContinueBtn().size()-1),
				testCase.getContinuePass(), testCase.getContinueFail());
		
		waitForPresenceOfAllElements(30, "//span[text() = 'Select Plan']//parent::button");
		
		clickElement(pom.getBrandsPage().selectPlanBtn().get(0), testCase.getSelectPlanPass(), testCase.getSelectPlanFail());
		
		clickElement(pom.getBrandsPage().getSelectContinueBtn(), testCase.getContinuePass(), testCase.getContinueFail());
		
		waitForPresenceOfAllElements(20, "//span[text() = 'Continue']//parent::button");
		
		waitForElementClickable(20, pom.getBrandsPage().getSelectContinueBtn());
		
		visibleOfElement(20, pom.getBrandsPage().getSelectContinueBtn());
		
		Thread.sleep(4000);
		
		clickElement(pom.getBrandsPage().getSelectContinueBtn(), testCase.getContinuePass(), testCase.getContinueFail());
		
		waitForPresenceOfAllElements(20, "//span[text() = 'Continue']//parent::button");
		
		waitForElementClickable(20, pom.getBrandsPage().getSelectContinueBtn());
		
		Thread.sleep(5000);
		
		visibleOfElement(20, pom.getBrandsPage().getSelectContinueBtn());
		
		actionScroll(pom.getBrandsPage().getSelectContinueBtn());
		
		clickElement(pom.getBrandsPage().getSelectContinueBtn(), testCase.getContinuePass(), testCase.getContinueFail());
		
		clickElement(pom.getBrandsPage().getGoToCart(), testCase.getClickGoToCartPass(), testCase.getClickGoToCartFail());
		
		}catch(Exception e) {
			
			System.out.println("problem on validating the shop by brand");
			e.printStackTrace();
		}
	}

}
