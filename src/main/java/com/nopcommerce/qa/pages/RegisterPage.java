package com.nopcommerce.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.nopcommerce.qa.baseclass.BaseClass;

public class RegisterPage extends BaseClass{

	private WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="gender-male")
	private WebElement maleGenderRadioButton;


	@FindBy(id="gender-female")
	private WebElement femaleGenderRadioButton;


	@FindBy(id="FirstName")
	private WebElement firstNameTextBox;


	@FindBy(id="LastName")
	private WebElement lastNameTextBox;	


	@FindBy(name="DateOfBirthDay")
	private WebElement dateOfBirthDateDropDown;	

	@FindBy(name="DateOfBirthMonth")
	private WebElement dateOfBirthMonthDropDown;	


	@FindBy(name="DateOfBirthYear")
	private WebElement dateOfBirthYearDropDown;	

	@FindBy(name="Email")
	private WebElement emailTextBox;	

	@FindBy(id="Company")
	private WebElement companyName;	

	@FindBy(id="Newsletter")
	private WebElement newsLetter;


	@FindBy(id="Password")
	private WebElement password;

	@FindBy(id="ConfirmPassword")
	private WebElement confirmPassword;


	@FindBy(id="register-button")
	private WebElement registerButton;

	@FindBy(id="FirstName-error")
	private WebElement first_name_warning_message;

	@FindBy(id="Email-error")
	private WebElement email_warning_message;

	@FindBy(id="Password-error")
	private WebElement password_warning_message;


	@FindBy(id="ConfirmPassword-error")
	private WebElement confrim_password_warning_message;

	@FindBy(id="LastName-error")
	private WebElement last_name_warning_message;

	@FindBy(xpath="//li[contains(text(),'email already')]")
	private WebElement emailAlreadyRegister;
	
	public void clickOnMaleRadioButton() {
		clickOnElement(maleGenderRadioButton);
	}

	public void clicksOnFemaleRadioButton() {
		clickOnElement(femaleGenderRadioButton);
	}

	public void entersOnFirstName(String firstName) {
		sendByTextValue(firstNameTextBox, firstName);
	}

	public void entersOnLastName(String lastName) {
		sendByTextValue(lastNameTextBox,lastName);
	}

	public void selectDate(String date) {
		selectByVisibleText(dateOfBirthDateDropDown, date);
	}

	public void selectMonth(String month) {
		selectByVisibleText(dateOfBirthMonthDropDown, month);
	}

	public void selectYear(String year) {
		selectByVisibleText(dateOfBirthYearDropDown, year);
	}

	public void entersEmail(String email) {
		sendByTextValue(emailTextBox, email);
	}


	public void entersCompanyName(String companyNameText) {
		sendByTextValue(companyName, companyNameText);
	}

	public void clicksOnNewsLetter() {
		clickOnElement(newsLetter);
	}

	public void entersPassword(String passwordText) {
		sendByTextValue(password, passwordText);
	}

	public void entersConfirmPassword(String confirmPasswordText) {
		sendByTextValue(confirmPassword, confirmPasswordText);
	}

	public void clickOnRegisterButton() {
		clickOnElement(registerButton);
	}

	public String getFirstNameWariningMessage() {
		return	getTextValue(first_name_warning_message);
	}

	public String getLastNameWariningMessage() {
		return	getTextValue(last_name_warning_message);
	}

	public String getEmailWarningMessage() {
		return getTextValue(email_warning_message);
	}
	public String getPasswordWarningMessage() {
		return getTextValue(password_warning_message);
	}

	public String getConfirmPasswordWarningMessage() {
		return getTextValue(confrim_password_warning_message);
	}
	
	public String getEmailAlreadyExistsWarningMessage() {
		return getTextValue(emailAlreadyRegister);
	}
}

