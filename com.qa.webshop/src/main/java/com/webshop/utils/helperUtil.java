package com.webshop.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.webshop.base.driverScript;

public class helperUtil extends driverScript {

	public static String captureScreen(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenpath = "/Users/susaritha/QA testing/Application for testing/Eclipse/Workspace-Selenium/com.qa.webshop/reports/screenshots/screen.png";
		try {
			FileHandler.copy(src, new File(screenpath));
		} catch (IOException e) {
			System.out.println("unable to capture the screen");
			e.printStackTrace();
		}
		return screenpath;
	}

}
