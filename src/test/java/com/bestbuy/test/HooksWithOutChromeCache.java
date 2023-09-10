package com.bestbuy.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.bestbuy.utils.BaseUtils;
import com.bestbuy.utils.Reports;

public class HooksWithOutChromeCache extends BaseUtils{
	
	@BeforeSuite
	public void launchURL() {
		
		Reports.startReport();
		
		launchBrowserWithOutChromeCache("chrome", property.getURL());
		
		
	}
	
	@AfterSuite
	public void quit() {
		
		try { Thread.sleep(5000); closeAllBrowsers(); Reports.endReport(); }catch(Exception e) {
			
			e.printStackTrace();
		}
	}


}
