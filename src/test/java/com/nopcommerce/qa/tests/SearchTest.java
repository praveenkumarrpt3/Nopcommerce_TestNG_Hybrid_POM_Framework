package com.nopcommerce.qa.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nopcommerce.qa.baseclass.BaseClass;
import com.nopcommerce.qa.pages.HeaderPage;
import com.nopcommerce.qa.pages.LoginPage;
import com.nopcommerce.qa.pages.SearchPage;

public class SearchTest extends BaseClass {
	private HeaderPage headerPage;
	private SearchPage sp;
	private WebDriver driver;
	private LoginPage lp;
	public SearchTest() {
		super();
	}

	@BeforeMethod
	public void setupbrowser() {
		driver=	initializeBrowserAndLandApplication(prop.getProperty("browser"));
		headerPage = new HeaderPage(driver);
	}

	@AfterMethod
	public void tearoffBrowser() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@Test(priority=1)
	public void search_a_Product_Without_Login() {
		headerPage.enterSearchStore(dataProp.getProperty("valid_product_name"));
		headerPage.clicksOnSearchButton();
		sp= new SearchPage(driver);
		assertTrue(sp.displayedSearchResult());
	}
	@Test(priority=2)
	public void search_an_invalid_product_without_login() {
		headerPage=new HeaderPage(driver);
		headerPage.enterSearchStore(dataProp.getProperty("invalid_product_name"));
		headerPage.clicksOnSearchButton();
		sp= new SearchPage(driver);
		assertTrue(sp.displayedNoSearchResult());
	}
	@Test(priority=3)
	public void search_an_empty_text_field_without_login() {
		headerPage=new HeaderPage(driver);
		headerPage.clicksOnSearchButton();
		handle_Alert_Accept();
	}
	@Test(priority=4)
	public void search_a_Product_With_Login() {
		lp= new LoginPage(driver);
		headerPage.clickOnAndNagivateToLoginPage();
		lp.entersEmailText(dataProp.getProperty("valid_email"));
		lp.entersPasswordText(dataProp.getProperty("valid_password"));
		lp.clicksOnLoginButton();
		Assert.assertTrue(headerPage.displayedMyaccount());
		headerPage.enterSearchStore(dataProp.getProperty("valid_product_name"));
		headerPage.clicksOnSearchButton();
		sp= new SearchPage(driver);
		assertTrue(sp.displayedSearchResult());
	}
	@Test(priority=5)
	public void search_an_invalid_product_with_login() {
		headerPage=new HeaderPage(driver);
		lp= new LoginPage(driver);
		headerPage.clickOnAndNagivateToLoginPage();
		lp.entersEmailText(dataProp.getProperty("valid_email"));
		lp.entersPasswordText(dataProp.getProperty("valid_password"));
		lp.clicksOnLoginButton();
		Assert.assertTrue(headerPage.displayedMyaccount());
		headerPage.enterSearchStore(dataProp.getProperty("invalid_product_name"));
		headerPage.clicksOnSearchButton();
		sp= new SearchPage(driver);
		assertTrue(sp.displayedNoSearchResult());
	}
	@Test(priority=6)
	public void search_an_empty_text_field_with_login() {
		headerPage=new HeaderPage(driver);
		lp= new LoginPage(driver);
		headerPage.clickOnAndNagivateToLoginPage();
		lp.entersEmailText(dataProp.getProperty("valid_email"));
		lp.entersPasswordText(dataProp.getProperty("valid_password"));
		lp.clicksOnLoginButton();
		Assert.assertTrue(headerPage.displayedMyaccount());
		headerPage.clicksOnSearchButton();
		handle_Alert_Accept();
	}
}
