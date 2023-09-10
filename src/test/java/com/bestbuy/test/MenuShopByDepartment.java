package com.bestbuy.test;

import org.testng.annotations.Test;

import com.bestbuy.utils.BaseUtils;

@Test
public class MenuShopByDepartment extends BaseUtils{
	
	public void selectByDepartment() {
		
		clickElement(pom.getHomePage().getMenuButton());
		
		clickElement(pom.getHomePage().selectDepartment(property.getValue("departmentName")));
		
		if (getElementText(pom.getHomePage().selectDepartmentList(property.getValue("selectDepartmentList")))
				.equals(property.getValue("selectDepartmentList"))) {
			
			clickElement(pom.getHomePage().selectDepartmentList(property.getValue("selectDepartmentList")));
			
			clickElement(pom.getHomePage().selectOneName(property.getValue("selectOneName")));

		}else if(getElementText(pom.getHomePage().selectOneName(property.getValue("selectOneName")))
				.equals(property.getValue("selectOneName"))){
		
			clickElement(pom.getHomePage().selectOneName(property.getValue("selectOneName")));
			
		}
		
		String name = getElementText(pom.getSearchResult().getFirstItemText());
		
		clickElement(pom.getSearchResult().getSelectFirstItemAddToCart());
		
		clickElement(pom.getSearchResult().getGoToCart());
		
		actionScroll(pom.getCart().getNoThankBtn());
		
		clickElement(pom.getCart().getNoThankBtn());
		
		String nameMatch = getElementText(pom.getCart().getCartItemName());
		
		if (name.equals(nameMatch)) {
			
			System.out.println("The search list product name and cart product name are matching");
		}
	}

}
