package com.webshop.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.webshop.base.driverScript;
import com.webshop.pages.homePage;
import com.webshop.pages.loginPage;

public class baseTest extends driverScript 
{
	homePage homepage;
	loginPage loginPage;

	@BeforeMethod
	public void setUp() 
	{
		initApplication();
		homepage = new homePage();
		loginPage = new loginPage();
	}

	@AfterMethod
	public void tearDown() 
	{
		quitDriver();
	}
}
