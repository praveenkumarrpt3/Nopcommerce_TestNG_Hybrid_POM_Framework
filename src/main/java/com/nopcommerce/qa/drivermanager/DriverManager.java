package com.nopcommerce.qa.drivermanager;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.nopcommerce.qa.baseclass.BaseClass;

public class DriverManager extends BaseClass {
	public static WebDriver driver;


//	@BeforeMethod
	public void setupbrowser() {
		if(driver ==null) {
			driver=	initializeBrowserAndLandApplication(prop.getProperty("browser"));
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
