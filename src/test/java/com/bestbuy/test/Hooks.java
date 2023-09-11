package com.bestbuy.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.bestbuy.utils.BaseUtils;
import com.bestbuy.utils.Reports;

public class Hooks extends BaseUtils{
	
	@BeforeSuite
	@Parameters({"browser","headLess", "cache", "reportName"})
	public void launchURL(String browser ,String headLess, String cache, String reportName) {
		
		Reports.startReport(reportName);
		
		launchBrowser(browser, property.getURL(), headLess, cache);
		
	}
	
	
	@AfterTest
	public void quit() {
		
		closeAllBrowsers();
		
		Reports.endReport();
	}

	
	

}
