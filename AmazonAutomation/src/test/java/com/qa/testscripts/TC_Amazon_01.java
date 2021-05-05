package com.qa.testscripts;

import static org.testng.Assert.assertTrue;

import java.awt.List;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.utilities.ExcelUtility;

public class TC_Amazon_01 extends TestBase_01 {

	
		@Test(dataProvider="SearchProvider" , priority = 1)
		public void SearchProduct(String Cate, String Product) throws InterruptedException {
		
			AmazonSearch.getAlldropdown().click();
			Thread.sleep(1500);
			Select Category = new Select(AmazonSearch.getAlldropdown());
			Category.selectByVisibleText(Cate);
			AmazonSearch.getSearchTextFeild().clear();
			AmazonSearch.getSearchTextFeild().sendKeys(Product);
			AmazonSearch.getSearchBtn().click();
			java.util.List<WebElement> ProductTitles = AmazonSearch.getProductNames();
			java.util.List<WebElement> ProductPrices = AmazonSearch.getProductPrices();
			
			
			for(int i=0,j=0;i<=15;i++,j++) {
				String title=ProductTitles.get(i).getText();
				String price = ProductPrices.get(j).getText();
				Reporter.log(title,true);
				Reporter.log(price,true);
				
			}
			 System.out.println();
			 
		}
		
		@DataProvider(name="SearchProvider")
		public Object[][] getData() throws IOException { 
			
			String Xlpath = "C:\\Users\\pratibhabv\\eclipse-workspace\\AmazonAutomation\\src\\test\\java\\com\\qa\\testdata\\TestData.xlsx";
			String Xlsheet = "Sheet1";
			int rowcount = ExcelUtility.getrowcount(Xlpath, Xlsheet);
			int cellcount = ExcelUtility.getcellcount(Xlpath, Xlsheet, rowcount);
			String[][] data = new String[rowcount][cellcount];
			for(int i=1;i<=rowcount;i++) {
				for(int j=0;j<cellcount;j++) {
					data[i-1][j]= ExcelUtility.getcellData(Xlpath, Xlsheet, i, j);
				}
			}
			return data;
		}
		
		 @Test(priority = 2)
		 public void amazonend()
		 { 
			 AmazonSearch.getSigninlink().click();
			 AmazonSearch.getemailtextfield().sendKeys("prajjumargi@gmail.com");
			 AmazonSearch.getcontinuebutton().click();
			 AmazonSearch.getpasswordfield().sendKeys("pratib123");
			 AmazonSearch.getsigninbutton().click();
			
		}
}
