package com.webshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class loginPageTests extends baseTest {

	

	@Test(priority = 1)

	public void testWelcomeSignIn() {

		homepage.clickLoginLink();
		String actual = loginPage.welcomeText();
		System.out.println(actual);
		Assert.assertTrue(actual.contains("welcome"));

	}

	@Test(priority = 2)
	public void testForgotPassword() {

		homepage.clickLoginLink();
		loginPage.enterEmailId("susytest@email.com");
		loginPage.enterPassword("pass");
		loginPage.forgotPasswordLink();
		boolean flag = loginPage.isForgotPasswordLinkPresent();
		System.out.println(flag);
		Assert.assertTrue(flag);

	}

	@Test(priority = 3)
	public void testLoginFunction() {

		homepage.clickLoginLink();
		loginPage.enterEmailId("susytest@email.com");
		loginPage.enterPassword("pass12348");
		loginPage.clickLoginButton();
		boolean linkPresent = homepage.isLogoutLinkPresent();
		System.out.println(linkPresent);
		Assert.assertTrue(linkPresent);
		homepage.clickLogoutLink();

	}
}
