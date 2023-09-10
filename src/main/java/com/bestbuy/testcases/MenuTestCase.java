package com.bestbuy.testcases;

import lombok.Getter;

@Getter
public class MenuTestCase {
	
	private String menuPass = "User Clicked on Menu List";
	private String menuFail = "problem on Clicking Menu List";

	public String clickingListPass(String name) { 
		
		String pass = "User selected the "+name;
		
		return pass;
	}
	
	public String clickingListFail(String name) { 
		
		String fail = "problem on selecting the "+name;
		
		return fail;
	}
}
