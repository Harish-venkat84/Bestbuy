package com.bestbuy.test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bestbuy.utils.BaseUtils;
import com.bestbuy.utils.Reports;

public class BottomLinksValidation extends BaseUtils{
	
	@Test(priority = 1)
	public void validatingBottomLinks() {
		
		List<WebElement> bottomLinks = pom.getHomePage().getBottomLinks();
		
		for (WebElement link : bottomLinks) {
			
			scrollToElement(link);
			
			String href = getAttributeValue(link, "href");
			
			if (href == null || href.equals("")) {
				
				System.out.println(getElementText(link)+ " ==> Broken");
				
			}else {
				
				System.out.println(getElementText(link)+" ==> link working fine");
				
				verifyingURL(href, getElementText(link));
				
			}
		}
		
		List<WebElement> bottomLinksFooter = pom.getHomePage().getBottomLinksFooter();
		
		for (WebElement link : bottomLinksFooter) {
			
			scrollToElement(link);
			
			String href = getAttributeValue(link, "href");
			
			if (href == null || href.equals("")) {
				
				System.out.println(getElementText(link)+ " ==> Broken");
				
			}else {
				
				System.out.println(getElementText(link)+" ==> link working fine");
				
				verifyingURL(href, getElementText(link));
				
			}
		}
	}
	
	public void verifyingURL(String url, String text) {
		
		try { 
			
			URL link = new URL(url);
			
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			
			httpURLConnection.setConnectTimeout(3000);
			
			httpURLConnection.connect();
			
			if (httpURLConnection.getResponseCode() == 200) {
				
				Reports.reportStep(Status.PASS, "The "+text+" URL Response code 200");
				
				System.out.println(httpURLConnection.getResponseMessage());
				
			} else {
			
				Reports.reportStep(Status.FAIL, "The "+text+" URL Response code not 200 ==> " + httpURLConnection.getResponseCode());
				System.out.println(httpURLConnection.getResponseMessage() + " - " + "is a broken link");
			}
			
		}catch(Exception ex) {
			
			System.out.println("Problem on validating URL");

			ex.printStackTrace();
		}

	}

}
