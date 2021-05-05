package com.qa.testscripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import com.qa.pages.AmazonPage;


public class TestBase_01 {

	
	WebDriver driver;
	AmazonPage AmazonSearch;

	
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void Setup( String Browser,String Url) {
		
		if(Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\pratibhabv\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();		
		}
		else if(Browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\pratibhabv\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new InternetExplorerDriver();
		}
		else if(Browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\pratibhabv\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
	
		
		AmazonSearch = new AmazonPage(driver);
	
		driver.get(Url);
		
		
	}
	
	@AfterClass
	public void Teardown() {
		driver.close();
	}
	
	public void CaptureScreenShot(WebDriver driver, String Testcase) throws IOException {
		TakesScreenshot Take = (TakesScreenshot)driver;
		File Source = Take.getScreenshotAs(OutputType.FILE);
		File Destination = new File(System.getProperty("user.dir")+"/ScreenShots/"+Testcase +".png");
		FileUtils.copyFile(Source, Destination);
	}
}
