package com.webshop.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverScript {

	public static WebDriver driver;
	static Properties prop;

	//** this constructor is used to read the contents from the properties file.*//
	public driverScript() {
		try {

			File file = new File("./src/test/resources/config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to load the file");
		}
	}

	//** This method is used to get the value of url and browser from the properties* file.*//
	
	public void initApplication() {
		String browser = prop.getProperty("browser");
		if (browser.trim().equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.trim().equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.trim().equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("unsupported browser type!");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		getAppUrl();
		
	}
	

	//** this method is used to navigate to the url based on the properties file***//
	public static void getAppUrl() {
		String url = prop.getProperty("url");
		driver.get(url);

	}

	//**** this method is used to quit the browser ***//
	public static void quitDriver() {
		driver.quit();
	}
}
