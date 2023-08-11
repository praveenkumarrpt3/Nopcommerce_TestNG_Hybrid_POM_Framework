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
import com.nopcommerce.qa.pommanager.PomManager;
import com.nopcommerce.qa.utilities.Utilities;


public class RegisterTestPom extends BaseClass {

	public RegisterTestPom() {
		super();
	}

	private WebDriver driver;
	PomManager page;

	@BeforeMethod
	public void setupbrowser() {
		driver=	initializeBrowserAndLandApplication(prop.getProperty("browser"));
		page = new PomManager(driver);
		page.getHomePage().clickOnAndNavigateToRegisterPage();
	}

	@AfterMethod
	public void tearoffBrowser() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@Test(priority=1)
	public void registerwithAllFields()  {
		
		page.getRegisterPage().clickOnMaleRadioButton();
		page.getRegisterPage().entersOnFirstName(dataProp.getProperty("firstName"));
		page.getRegisterPage().entersOnLastName(dataProp.getProperty("LastName"));
		page.getRegisterPage().selectDate(dataProp.getProperty("date"));
		page.getRegisterPage().selectMonth(dataProp.getProperty("month"));
		page.getRegisterPage().selectYear(dataProp.getProperty("year"));
		page.getRegisterPage().entersEmail(Utilities.generateMaildByGetStamp());
		page.getRegisterPage().entersCompanyName(dataProp.getProperty("company"));
		//		rp.clicksOnNewsLetter();
		page.getRegisterPage().entersPassword(dataProp.getProperty("valid_password"));
		page.getRegisterPage().entersConfirmPassword(dataProp.getProperty("valid_password"));
		page.getRegisterPage().clickOnRegisterButton();
		Assert.assertEquals(page.getRegisterCompletePage().getRegisterComplectedText(), dataProp.getProperty("register_complete"));
	}

	@Test(priority=2)
	public void registerWithMantoryFields() {
		page.getRegisterPage().entersOnFirstName(dataProp.getProperty("firstName"));
		page.getRegisterPage().entersOnLastName(dataProp.getProperty("LastName"));
		page.getRegisterPage().entersEmail(Utilities.generateMaildByGetStamp());
		page.getRegisterPage().entersCompanyName(dataProp.getProperty("company"));
		page.getRegisterPage().clicksOnNewsLetter();
		page.getRegisterPage().entersPassword(dataProp.getProperty("valid_password"));
		page.getRegisterPage().entersConfirmPassword(dataProp.getProperty("valid_password"));
		page.getRegisterPage().clickOnRegisterButton();
		Assert.assertEquals(page.getRegisterCompletePage().getRegisterComplectedText(), dataProp.getProperty("register_complete"));
	}

	@Test(priority=3)
	public void registerWithoutAnyDetails() {

		page.getRegisterPage().clickOnRegisterButton();

		Assert.assertEquals(page.getRegisterPage().getFirstNameWariningMessage(), dataProp.getProperty("first_name_warning_message"));
		Assert.assertEquals(page.getRegisterPage().getLastNameWariningMessage(), dataProp.getProperty("last_name_warning_message"));
		Assert.assertEquals(page.getRegisterPage().getEmailWarningMessage(), dataProp.getProperty("email_warning_message"));
		Assert.assertEquals(page.getRegisterPage().getPasswordWarningMessage(), dataProp.getProperty("password_warning_message"));
		Assert.assertEquals(page.getRegisterPage().getConfirmPasswordWarningMessage(), dataProp.getProperty("confirm_password_warning_message"));
	}

	@Test(priority=4)
	public void registerWithDuplicateMailId() {

		page.getRegisterPage().clickOnMaleRadioButton();
		page.getRegisterPage().entersOnFirstName(dataProp.getProperty("firstName"));
		page.getRegisterPage().entersOnLastName(dataProp.getProperty("LastName"));
		page.getRegisterPage().selectDate(dataProp.getProperty("date"));
		page.getRegisterPage().selectMonth(dataProp.getProperty("month"));
		page.getRegisterPage().selectYear(dataProp.getProperty("year"));
		page.getRegisterPage().entersEmail(dataProp.getProperty("email"));
		page.getRegisterPage().entersCompanyName(dataProp.getProperty("company"));
		page.getRegisterPage().entersPassword(dataProp.getProperty("valid_password"));
		page.getRegisterPage().entersConfirmPassword(dataProp.getProperty("valid_password"));
		page.getRegisterPage().clickOnRegisterButton();
		Assert.assertEquals(page.getRegisterPage().getEmailAlreadyExistsWarningMessage(), dataProp.getProperty("email_already_exists"));
	}


}
