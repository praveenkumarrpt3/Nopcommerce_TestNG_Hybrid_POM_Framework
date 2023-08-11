package com.nopcommerce.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.qa.baseclass.BaseClass;

public class RegisterCompletePage extends BaseClass{

	private WebDriver driver;
	public RegisterCompletePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Continue")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[@class='result']")
	private WebElement registerCompleteMessage;
	
	public void clicksOnContinueButton() {
		clickOnElement(continueButton);
	}
	
	public String getRegisterComplectedText() {
		return getTextValue(registerCompleteMessage);
	}
	
	
}
