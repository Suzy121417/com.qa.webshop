package com.webshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webshop.base.driverScript;

//****************************** Page locators*********************//
public class homePage extends driverScript {

	@FindBy(linkText = "Log in") private WebElement loginLink;
	@FindBy(linkText = "Log out") private WebElement logoutLink;
	

	// ****************** Page initialization*******************//
	public homePage() 
	{
		PageFactory.initElements(driver, this);
	}

	// ********************* Page methods/action**************** *//
	public void clickLoginLink() 
	{
		loginLink.click();
	}

	// ********************* Page methods/action**************** *//
	public String homePageTitle()
	{
		return driver.getTitle();
	}
	
	public void clickLogoutLink()
	{
		logoutLink.click();
	}
	
	public boolean isLogoutLinkPresent()
	{
		 return logoutLink.isDisplayed();
	}
	

}
