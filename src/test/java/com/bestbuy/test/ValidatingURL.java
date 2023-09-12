package com.bestbuy.test;

import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bestbuy.utils.BaseUtils;
import com.bestbuy.utils.Reports;

public class ValidatingURL extends BaseUtils{
	
	
	@Test
	public void verifyingURL() {
		
		try { 
			
			Assert.assertEquals(currentURL(), property.getURL()); 
			
			URL link = new URL(property.getURL());
			
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			
			httpURLConnection.setConnectTimeout(3000);
			
			httpURLConnection.connect();
			
			if (httpURLConnection.getResponseCode() == 200) {
				
				Reports.reportStep(Status.PASS, "The given URL Response code 200");
				
				System.out.println(property.getURL() + " - " + httpURLConnection.getResponseMessage());
				
			} else {
			
				Reports.reportStep(Status.FAIL, "The given URL Response code not 200 ==> " + httpURLConnection.getResponseCode());
				System.out.println(property.getURL() + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
			}
			
		}catch(Exception ex) {
			
			System.out.println("Problem on validating URL");

			ex.printStackTrace();
		}

	}

}