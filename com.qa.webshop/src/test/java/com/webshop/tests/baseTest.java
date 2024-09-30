package com.webshop.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.webshop.base.driverScript;
import com.webshop.pages.homePage;
import com.webshop.pages.loginPage;
import com.webshop.utils.helperUtil;

public class baseTest extends driverScript {
	protected static ExtentHtmlReporter extent;
	protected static ExtentReports report;
	protected static ExtentTest logger;

	homePage homepage;
	loginPage loginPage;

	@Test
	@BeforeSuite
	public void testReport() {
		extent = new ExtentHtmlReporter("./reports/index.html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}


	@BeforeMethod
	public void setUp() {
		initApplication();
		homepage = new homePage();
		loginPage = new loginPage();
	}


	@AfterMethod
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) 
		{
			try {
				Assert.fail("test failed",MediaEntityBuilder.createScreenCaptureFromPath(helperUtil.captureScreen(driver)).build());
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		report.flush();
		quitDriver();

	}
}
