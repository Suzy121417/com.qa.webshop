package com.webshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webshop.base.driverScript;

public class loginPage extends driverScript {

	// *********************** These are the locators for login
	// page******************//

	@FindBy(id = "Email")
	private WebElement emailTextbox;
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	@FindBy(xpath = ("//input[@class='button-1 login-button']"))
	private WebElement loginButton;
	@FindBy(xpath = "//h1[text()='Welcome, Please Sign In!']")
	private WebElement welcomeSign;
	@FindBy(xpath = "//a[@href='/passwordrecovery']")
	private WebElement forgotPassword;
	

	// ******************* this is a constructor for login page.
	// ********************//
	public loginPage() {
		PageFactory.initElements(driver, this);

	}
	
	public boolean isForgotPasswordLinkPresent()
	{
		return forgotPassword.isDisplayed();
	}

	// ******************* this is a method for validating the welcome sign in page
	// text. ********************//
	public String welcomeText() {
		return welcomeSign.getText();
	}

	// ******************* this is a method for getting the input of email id.
	// ********************//
	public void enterEmailId(String emailId) {
		emailTextbox.sendKeys(emailId);

	}

	// ******************* this is a method for getting the input of password.
	// ********************//
	public void enterPassword(String password) {
		passwordTextbox.sendKeys(password);
	}

	// ******************* this is a method for getting the login page title.
	// ********************//

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	// ******************* this is a method for clicking onto the login button.
	// ********************//
	public void clickLoginButton() {
		loginButton.click();
	}

	public void forgotPasswordLink() {
		forgotPassword.click();
	}

}
