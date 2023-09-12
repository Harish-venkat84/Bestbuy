package com.bestbuy.test;

import org.testng.annotations.Test;

import com.bestbuy.testcases.MenuShopByDepartmentTestCase;
import com.bestbuy.utils.BaseUtils;
import com.bestbuy.utils.Reports;

@Test
public class MenuShopByDepartment extends BaseUtils{
	
	static MenuShopByDepartmentTestCase testCase = new MenuShopByDepartmentTestCase();
	
	public void selectByDepartment() {
		
		Reports.setTCDesc("Validating Menu Shop by Department functionality");
		
		clickElement(pom.getHomePage().getMenuButton(), testCase.getMenuPass(), testCase.getMenuFail());
		
		clickElement(pom.getHomePage().selectDepartment(property.getValue("departmentName")), testCase.getSelectDepartPass(), 
				testCase.getSelectDepartFail());
		
		if (getElementText(pom.getHomePage().selectDepartmentList(property.getValue("selectDepartmentList")))
				.equals(property.getValue("selectDepartmentList"))) {
			
			clickElement(pom.getHomePage().selectDepartmentList(property.getValue("selectDepartmentList")),
					testCase.getSelectProductListPass(), testCase.getSelectProductListFail());
			
			clickElement(pom.getHomePage().selectOneName(property.getValue("selectOneName")),
					testCase.getSelectProductPass(), testCase.getSelectProductFail());

		}else if(getElementText(pom.getHomePage().selectOneName(property.getValue("selectOneName")))
				.equals(property.getValue("selectOneName"))){
		
			clickElement(pom.getHomePage().selectOneName(property.getValue("selectOneName")),
					testCase.getSelectProductPass(), testCase.getSelectProductFail());
			
		}
		
		String name = getElementText(pom.getSearchResult().getFirstItemText());
		
		clickElement(pom.getSearchResult().getSelectFirstItemAddToCart(), 
				testCase.getSelectingFirstProductPass(), testCase.getSelectingFirstProductFail());
		
		clickElement(pom.getSearchResult().getGoToCart(), testCase.getClickGoToCartPass(), testCase.getClickGoToCartFail());
		
		actionScroll(pom.getCart().getNoThankBtn());
		
		clickElement(pom.getCart().getNoThankBtn(), testCase.getNoThankPass(), testCase.getNoThankFail());
		
		String nameMatch = getElementText(pom.getCart().getCartItemName());
		
		if (name.equals(nameMatch)) {
			
			System.out.println("The search list product name and cart product name are matching");
		}
	}

}
