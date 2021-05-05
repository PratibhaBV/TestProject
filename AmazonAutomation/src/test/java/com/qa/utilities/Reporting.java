package com.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest XTest;
	
	public void onStart(ITestContext testContext) {
	    
		  String TimeStamp = new SimpleDateFormat("yyyy-MM-dd.HH.mm.ss").format(new Date());
		  String repName = "Test-Report"+TimeStamp+".html";
		  
		  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+repName);
		  htmlReporter.config().setDocumentTitle("htmlReporter");
		  htmlReporter.config().setReportName("Functional Testing");
		  htmlReporter.config().setTheme(Theme.DARK);
		  htmlReporter.config().setAutoCreateRelativePathMedia(true);
		  
		  extent = new ExtentReports();
		  extent.attachReporter(htmlReporter);
		  extent.setSystemInfo("Host Name", "Localhost");
		  extent.setSystemInfo("QA Name", "Prathiba");
		  extent.setSystemInfo("OS", "Windows 10");
		  
		  
	  }

	
	  public void onFinish(ITestContext testContext) {
		  
		  extent.flush();
	  }
	

	  
	  public void onTestSuccess(ITestResult tr) {
	    
		 
		  XTest = extent.createTest(tr.getName());
		  XTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
		  XTest.log(Status.PASS, "Test is Passed.");
	  }

	  
	  public void onTestFailure(ITestResult tr) {
		  XTest = extent.createTest(tr.getName());
		  XTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		  XTest.log(Status.FAIL, "Test is Failed.");
		  
		  String ScreenshotPath = System.getProperty("user.dir")+"/ScreenShots/"+tr.getName()+".png";
		  File Destination = new File(ScreenshotPath);
		  if(Destination.exists()) {
			  
			  try {
				XTest.fail("Screenshot for Failed Test : "+ XTest.addScreenCaptureFromPath(ScreenshotPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	  }

	 
	  public void onTestSkipped(ITestResult tr) {
		  XTest = extent.createTest(tr.getName());
		  XTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.AMBER));
		  XTest.log(Status.SKIP, "Test is Skipped.");
	  }

}
