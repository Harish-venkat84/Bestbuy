package com.bestbuy.utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports {

	
	public static ExtentSparkReporter sparkReport;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	
	public static void startReport(String reportName) {
		
		
		try {
			
			sparkReport = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/"+reportName+"Report.html");
			
			sparkReport.config().setDocumentTitle("Bestbuy Web Automation Report");
			
			sparkReport.config().setReportName("Bestbuy Web Automation");
			
			sparkReport.config().setTheme(Theme.DARK);
			
			extentReport = new ExtentReports();
			
			extentReport.attachReporter(sparkReport);
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void setTCDesc(String testCaseName) {
		
		try {
			
			extentTest = extentReport.createTest(testCaseName);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void reportStep(Status status, String decs) {
		
		try {
			
			if (status == Status.PASS) {
				
				extentTest.log(Status.PASS, decs);
			
			}else if(status == Status.FAIL) {
				
				BaseUtils.takeScreenshot();
				
				extentTest.log(Status.FAIL, decs);
				
				extentTest.addScreenCaptureFromPath(System.getProperty("user.dir") + "/screenshots/fail.png");
				
//				extentTest.addScreenCaptureFromBase64String(BaseUtils.Screenshot64Based());
			
			}else if(status == Status.SKIP) {
				
				extentTest.log(Status.SKIP, decs);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void endReport() {
		
		try {
			
			extentReport.flush();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
