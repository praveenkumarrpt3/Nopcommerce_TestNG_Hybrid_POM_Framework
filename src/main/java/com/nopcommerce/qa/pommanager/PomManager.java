package com.nopcommerce.qa.pommanager;

import org.openqa.selenium.WebDriver;

import com.nopcommerce.qa.pages.CartPage;
import com.nopcommerce.qa.pages.HeaderPage;
import com.nopcommerce.qa.pages.HomePage;
import com.nopcommerce.qa.pages.LoginPage;
import com.nopcommerce.qa.pages.MyAccountPage;
import com.nopcommerce.qa.pages.RegisterCompletePage;
import com.nopcommerce.qa.pages.RegisterPage;
import com.nopcommerce.qa.pages.SearchPage;

public class PomManager {

	private	WebDriver driver;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	HeaderPage headerPage;
	CartPage cartPage;
	RegisterPage registerPage;
	RegisterCompletePage registerCompletePage;
	SearchPage searchPage;
	public static HomePage homePage;





	public 	PomManager(WebDriver driver) {
		this.driver=driver;
	}


	public LoginPage getLoginPage() {
		return loginPage;
	}
	public LoginPage getMyAccountPage() {
		return (loginPage ==null) ? loginPage= new LoginPage(driver):loginPage;
	}
	public HeaderPage getHeaderPage() {
		return (headerPage==null)? headerPage= new HeaderPage(driver):headerPage;
	}
	public CartPage getCartPage() {
		return (cartPage==null) ? cartPage = new CartPage(driver) :cartPage;
	}
	public RegisterPage getRegisterPage() {
		return (registerPage==null) ? registerPage=new RegisterPage(driver):registerPage;
	}
	public RegisterCompletePage getRegisterCompletePage() {
		return (registerCompletePage==null) ? registerCompletePage= new RegisterCompletePage(driver): registerCompletePage;
	}
	public SearchPage getSearchPage() {
		return (searchPage==null) ? searchPage= new SearchPage(driver):searchPage;
	}

	public HomePage getHomePage() {
		return (homePage==null)? homePage=new HomePage(driver):homePage;
	}

}
