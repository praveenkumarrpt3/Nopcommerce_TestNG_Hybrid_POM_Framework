package com.nopcommerce.qa.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nopcommerce.qa.baseclass.BaseClass;
import com.nopcommerce.qa.pages.HomePage;
import com.nopcommerce.qa.pages.RegisterCompletePage;
import com.nopcommerce.qa.pages.RegisterPage;
import com.nopcommerce.qa.utilities.Utilities;


public class RegisterTest extends BaseClass {

	public RegisterTest() {
		super();
	}

	private WebDriver driver;
	private RegisterPage rp;
	private RegisterCompletePage rcp;

	@BeforeMethod
	public void setupbrowser() {
		driver=	initializeBrowserAndLandApplication(prop.getProperty("browser"));
		HomePage hp = new HomePage(driver);
		hp.clickOnAndNavigateToRegisterPage();
	}

	@AfterMethod
	public void tearoffBrowser() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@Test(priority=1)
	public void registerwithAllFields()  {
		rp = new RegisterPage(driver);
		rp.clickOnMaleRadioButton();
		rp.entersOnFirstName(dataProp.getProperty("firstName"));
		rp.entersOnLastName(dataProp.getProperty("LastName"));
		rp.selectDate(dataProp.getProperty("date"));
		rp.selectMonth(dataProp.getProperty("month"));
		rp.selectYear(dataProp.getProperty("year"));
		rp.entersEmail(Utilities.generateMaildByGetStamp());
		rp.entersCompanyName(dataProp.getProperty("company"));
		//		rp.clicksOnNewsLetter();
		rp.entersPassword(dataProp.getProperty("valid_password"));
		rp.entersConfirmPassword(dataProp.getProperty("valid_password"));
		rp.clickOnRegisterButton();
		rcp=new RegisterCompletePage(driver);
		Assert.assertEquals(rcp.getRegisterComplectedText(), dataProp.getProperty("register_complete"));
	}

	@Test(priority=2)
	public void registerWithMantoryFields() {
		rp=new RegisterPage(driver);
		rp.entersOnFirstName(dataProp.getProperty("firstName"));
		rp.entersOnLastName(dataProp.getProperty("LastName"));
		rp.entersEmail(Utilities.generateMaildByGetStamp());
		rp.entersCompanyName(dataProp.getProperty("company"));
		rp.clicksOnNewsLetter();
		rp.entersPassword(dataProp.getProperty("valid_password"));
		rp.entersConfirmPassword(dataProp.getProperty("valid_password"));
		rp.clickOnRegisterButton();
		rcp=new RegisterCompletePage(driver);
		Assert.assertEquals(rcp.getRegisterComplectedText(), dataProp.getProperty("register_complete"));
	}

	@Test(priority=3)
	public void registerWithoutAnyDetails() {
		rp = new RegisterPage(driver);
		rp.clickOnRegisterButton();

		Assert.assertEquals(rp.getFirstNameWariningMessage(), dataProp.getProperty("first_name_warning_message"));
		Assert.assertEquals(rp.getLastNameWariningMessage(), dataProp.getProperty("last_name_warning_message"));
		Assert.assertEquals(rp.getEmailWarningMessage(), dataProp.getProperty("email_warning_message"));
		Assert.assertEquals(rp.getPasswordWarningMessage(), dataProp.getProperty("password_warning_message"));
		Assert.assertEquals(rp.getConfirmPasswordWarningMessage(), dataProp.getProperty("confirm_password_warning_message"));
	}

	@Test(priority=4)
	public void registerWithDuplicateMailId() {

		rp = new RegisterPage(driver);
		rp.clickOnMaleRadioButton();
		rp.entersOnFirstName(dataProp.getProperty("firstName"));
		rp.entersOnLastName(dataProp.getProperty("LastName"));
		rp.selectDate(dataProp.getProperty("date"));
		rp.selectMonth(dataProp.getProperty("month"));
		rp.selectYear(dataProp.getProperty("year"));
		rp.entersEmail(dataProp.getProperty("email"));
		rp.entersCompanyName(dataProp.getProperty("company"));
		rp.entersPassword(dataProp.getProperty("valid_password"));
		rp.entersConfirmPassword(dataProp.getProperty("valid_password"));
		rp.clickOnRegisterButton();
		rcp=new RegisterCompletePage(driver);
		Assert.assertEquals(rp.getEmailAlreadyExistsWarningMessage(), dataProp.getProperty("email_already_exists"));
	}


}
