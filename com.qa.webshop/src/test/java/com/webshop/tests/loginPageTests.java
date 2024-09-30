package com.webshop.tests;

import org.testng.annotations.Test;
import org.testng.Assert;

public class loginPageTests extends baseTest {

	@Test(priority = 1)

	public void testWelcomeSignIn() {
		logger = report.createTest("test welcome signIn");
		homepage.clickLoginLink();
		logger.pass("clicked the login link");
		String actual = loginPage.welcomeText();
		System.out.println(actual);
		logger.pass("Got the welcome test");
		Assert.assertTrue(actual.contains("welcome"));

	}

	@Test(priority = 2)
	public void testForgotPassword() {
		logger = report.createTest("Test forgot password");
		homepage.clickLoginLink();
		logger.pass("clicked on the login");
		loginPage.enterEmailId("susytest@email.com");
		logger.pass("entered the email id");
		loginPage.enterPassword("pass");
		logger.pass("entered the password");
		loginPage.forgotPasswordLink();
		logger.pass("clicked on the forgot password link");
		boolean flag = loginPage.isForgotPasswordLinkPresent();
		System.out.println(flag);
		Assert.assertTrue(flag);

	}

	@Test(priority = 3)
	public void testLoginFunction() {

		logger = report.createTest("test the login function");
		homepage.clickLoginLink();
		logger.pass("clicked on the login");
		loginPage.enterEmailId("susytest@email.com");
		logger.pass("enteres the email");
		loginPage.enterPassword("pass12348");
		logger.pass("entered the password");
		loginPage.clickLoginButton();
		logger.pass("clicked on the login button");
		boolean linkPresent = homepage.isLogoutLinkPresent();
		System.out.println(linkPresent);
		Assert.assertTrue(linkPresent);
		homepage.clickLogoutLink();

	}

	@Test(priority = 4)
	public void testPageTitle() {
		report.createTest("check the page title");
		homepage.clickLoginLink();
		logger.pass("clicked on the login page");
		String title = loginPage.getLoginPageTitle();
		logger.pass("collected the title of the page");
		Assert.assertTrue(title.contains("login"));
		logger.pass("The page title contains the word login");

	}
	@Test(priority=5)
	public void testInvalidCredentials() {

		logger = report.createTest("test the login function");
		homepage.clickLoginLink();
		logger.pass("clicked on the login");
		loginPage.enterEmailId("susytest@email.com");
		logger.pass("enteres the email");
		loginPage.enterPassword("");
		logger.pass("entered the password");
		loginPage.clickLoginButton();
		logger.pass("clicked on the login button");
		boolean linkPresent = homepage.isLogoutLinkPresent();
		System.out.println(linkPresent);
		Assert.assertTrue(linkPresent);
		logger.pass("The test failed");
		homepage.clickLogoutLink();
}
}
