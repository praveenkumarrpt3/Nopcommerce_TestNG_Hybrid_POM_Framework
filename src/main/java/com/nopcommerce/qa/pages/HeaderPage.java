package com.nopcommerce.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.qa.baseclass.BaseClass;

public class HeaderPage extends BaseClass{
	private WebDriver driver;
	public HeaderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="My account")
	private WebElement my_Account;

	public Boolean displayedMyaccount() {
		return displayedExpectedText(my_Account);
	}

	@FindBy(xpath="//a[text()='Register']")
	private WebElement registerOption;

	@FindBy(xpath="//a[text()='Log in']")
	private WebElement loginOption;

	@FindBy(xpath="//span[text()='Wishlist']")
	private WebElement wishListOption;

	@FindBy(id="small-searchterms")
	private WebElement searchBox;

	@FindBy(xpath="//button[text()='Search']")
	private WebElement searchButton;

	@FindBy(partialLinkText="cart")
	private WebElement shopCartOption;
	

	public void clickOnAndNagivateToLoginPage() {
		clickOnElement(loginOption);
	}

	public void clickOnAndNavigateToRegisterPage() {
		clickOnElement(registerOption);
	}

	public void clickOnAndNavigateToWishlistPage() {
		clickOnElement(wishListOption);
	}

	public void clickOnAndNavigateToShoppingCartPage() {
		clickOnElement(shopCartOption);
		shopCartOption.click();
	}

	public void enterSearchStore(String productName) {
		sendByTextValue(searchBox, productName);
	}

	public void clicksOnSearchButton() {
		clickOnElement(searchButton);
	}
}

	
