package com.bestbuy.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.bestbuy.utils.BaseUtils;
import com.bestbuy.utils.Reports;

public class HooksWithChromeCache extends BaseUtils{
	
	@BeforeSuite
	public void launchURL() {
		
		Reports.startReport();
		
		launchBrowserWithChromeCache("chrome", property.getURL());
		
	}
	
	
	@AfterSuite
	public void quit() {
		
		closeAllBrowsers();
		
		Reports.endReport();
	}


}
