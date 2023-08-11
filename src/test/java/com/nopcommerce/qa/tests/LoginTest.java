package com.nopcommerce.qa.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nopcommerce.qa.baseclass.BaseClass;
import com.nopcommerce.qa.pages.HeaderPage;
import com.nopcommerce.qa.pages.HomePage;
import com.nopcommerce.qa.pages.LoginPage;

public class LoginTest extends BaseClass{
	private WebDriver driver;
	private LoginPage lp;
	private HeaderPage headerPage;
	public LoginTest() {
		super();
	}
	

	@BeforeMethod
	public void setupbrowser() {
		driver=	initializeBrowserAndLandApplication(prop.getProperty("browser"));
		HomePage hp = new HomePage(driver);
		hp.clickOnAndNagivateToLoginPage();
	}

	@AfterMethod
	public void tearoffBrowser() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	@Test(priority=1)
	public void loginWithValidCredentials() {
		lp = new LoginPage(driver);
		lp.entersEmailText(dataProp.getProperty("valid_email"));
		lp.entersPasswordText(dataProp.getProperty("valid_password"));
		lp.clicksOnLoginButton();
		headerPage= new HeaderPage(driver);
		Assert.assertTrue(headerPage.displayedMyaccount());
	}

	@Test(priority=2)
	public void loginWithInvalidCredentials() {
		lp= new LoginPage(driver);
		lp.entersEmailText(dataProp.getProperty("invalid_email"));
		lp.entersPasswordText(dataProp.getProperty("invalid_password"));
		lp.clicksOnLoginButton();
		assertEquals(lp.getNocustomerAccountWarningMessage(), dataProp.getProperty("no_account_found_warning"));
	}
	
	@Test(priority=3)
	public void loginWithoutEnterEmailTextAndPassword() {
		lp= new LoginPage(driver);
		lp.clicksOnLoginButton();
		Assert.assertEquals(lp.getEmptyEmailTextErrorMessage(), dataProp.getProperty("empty_email_warning"));
		
	}
	
	@Test(priority=4)
	public void loginWithValidEmailAndInvalidPassword() {
		lp= new LoginPage(driver);
		lp.entersEmailText(dataProp.getProperty("invalid_email"));
		lp.entersPasswordText(dataProp.getProperty("valid_password"));
		lp.clicksOnLoginButton();
		Assert.assertEquals(lp.getNocustomerAccountWarningMessage(), dataProp.getProperty("no_account_found_warning"));
	}
	
	@Test(priority=5)
	public void loginWithInvalidEmailAndValidPassword() {
		lp= new LoginPage(driver);
		lp.entersEmailText(dataProp.getProperty("valid_email"));
		lp.entersPasswordText(dataProp.getProperty("invalid_password"));
		lp.clicksOnLoginButton();
		Assert.assertEquals(lp.getInvalidCredentialsWarningMessage(), dataProp.getProperty("valid_account_invalid_password_warning"));
	}
	
}

