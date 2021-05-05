package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

	
	WebDriver driver;
	
	public AmazonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="url")
	WebElement Alldropdown;
	public WebElement getAlldropdown() {
		return Alldropdown;
	}
	
	@FindAll(@FindBy(xpath="//option[starts-with(@value,'search-alias=')]"))
	List<WebElement> Alloptions;
	public List<WebElement> getAlloptions() {
		return Alloptions;
	}
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement SearchTextFeild;
	public WebElement getSearchTextFeild() {
		return SearchTextFeild;
	}
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement SearchBtn;
	public WebElement getSearchBtn() {
		return SearchBtn;
	}
	
	@FindAll(@FindBy(xpath="//a[@class='a-link-normal a-text-normal']"))
	List<WebElement> ProductNames;
	public List<WebElement> getProductNames() {
		return ProductNames;
	}
	
	@FindAll(@FindBy(xpath="//span[@data-a-color='price']"))
	List<WebElement> ProductPrices;
	public List<WebElement> getProductPrices() {
		return ProductPrices;
	}
	
	@FindAll(@FindBy(xpath="//body/div[@id='a-page']/div[@id='navFooter']/div[4]/ul[1]/li/a"))
	List<WebElement> FooterCountries;
	public List<WebElement> getFooterCountries() {
		return FooterCountries;
	}
	
	@FindBy(linkText = "Careers")
	WebElement CarreerLink;
	public WebElement getCarreerLink() {
		return CarreerLink;
	}
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement Signinlink;
	public WebElement getSigninlink()
	{
		return Signinlink;
	}
	
	@FindBy(id="ap_email")
	WebElement emailtextfield;
	public WebElement getemailtextfield()
	{
		return emailtextfield;
	}
	@FindBy(id="continue")
	WebElement continuebutton;
	public WebElement getcontinuebutton()
	{
		return continuebutton;
	}
	@FindBy(id="ap_password")
	WebElement passwordfield;
	public WebElement getpasswordfield()
	{
		return passwordfield;
	}
	@FindBy(id="signInSubmit")
	WebElement signinbutton;
	public WebElement getsigninbutton()
	{
		return signinbutton;
	}
	
}
