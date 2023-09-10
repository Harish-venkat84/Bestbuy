package com.bestbuy.testcases;

import com.bestbuy.property.FileReaderManager;

import lombok.Getter;

@Getter
public class MenuShopByDepartmentTestCase {
	
	FileReaderManager property = new FileReaderManager();
	
	private String menuPass = "User Clicked on Menu List";
	private String menuFail = "problem on Clicking Menu List";
	
	private String selectDepartPass = "User Selected " + property.getValue("departmentName") + " from the shop by Department List";
	private String selectDepartFail = "problem Selecting " + property.getValue("departmentName") + " from the shop by Department List";

	private String selectProductListPass = "User Selected the " +property.getValue("selectDepartmentList")
				+ " form the "+property.getValue("departmentName")+" List";
	
	private String selectProductListFail = "problem on Selecting " +property.getValue("selectDepartmentList")
	+ " form the "+property.getValue("departmentName")+" List";
	
	private String selectProductPass = "User Selected the " +property.getValue("selectOneName")
	+ " form the "+property.getValue("selectDepartmentList")+" List";

	private String selectProductFail = "problem on Selecting " +property.getValue("selectOneName")
	+ " form the "+property.getValue("selectDepartmentList")+" List";
	
	
	private String SelectingFirstProductPass = "User clicked Add To Cart of the First List Product";
	private String SelectingFirstProductFail = "problem clicking Add To Cart of the First List Product";
	
	private String clickGoToCartPass = "User Clicked on Go To Cart button";
	private String clickGoToCartFail = "problem on clicking GO To Cart button";
	
	private String noThankPass = "Clicked on NoThank Button";
	private String noThankFail = "problem on Clicking NoThank Button";
	
}
