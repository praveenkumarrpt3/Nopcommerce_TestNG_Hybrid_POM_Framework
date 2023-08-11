package com.nopcommerce.qa.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nopcommerce.qa.utilities.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static Properties dataProp;
	private	WebDriver driver;

	public BaseClass() {

		prop = new Properties();
		try {
			File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\nopcommerce\\qa\\config\\Config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}


		dataProp = new Properties();
		try {
			File file = new File(System.getProperty("user.dir")+"\\src\\test\\resource\\com\\nopcommerce\\qa\\testdataconfig\\TestData.properties");
			FileInputStream fis = new FileInputStream(file);
			dataProp.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}

	}

	public WebDriver initializeBrowserAndLandApplication(String browser) {

		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firfox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new  SafariDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Utilities.IMPLICITY_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Utilities.PAGE_OUT_TIME_OUT, TimeUnit.SECONDS);
		return driver;
	}

	public void sendByTextValue(WebElement element, String text) {
		element.sendKeys(text);
	}

	public WebElement waitForElementToBeClickable(WebElement element) {
		WebDriverWait  wait = new WebDriverWait(this.driver, 10);
		return	wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement waitForVisibilityOfElement(WebElement element) {
		WebDriverWait  wait = new WebDriverWait(this.driver, 10);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}


	public void clickOnElement(WebElement element) {
		element.click();
	}

	public void selectByIndex(WebElement element, int index) {
		element.click();
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectByVisibleText(WebElement element, String visibleText) {
		element.click();
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public void iterateSelectAllOptions(WebElement element) {

		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement webElement : options) {
			System.out.println(webElement);
		}	
	}

	public String getTextValue(WebElement element) {
		return element.getText();
	}

	public Boolean displayedExpectedText(WebElement element) {
		return	element.isDisplayed();
	}
	
	public String getTextFromTheElement(WebElement element) {
		return element.getText();
	}
	
	public String getAttributeValue(WebElement element,String attributeName) {
		return element.getAttribute(attributeName);
	}

	public void handle_Alert_Accept() {
		driver.switchTo().alert().accept();
	}
}
