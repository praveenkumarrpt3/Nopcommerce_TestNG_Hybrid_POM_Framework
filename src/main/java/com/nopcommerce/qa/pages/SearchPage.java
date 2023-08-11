package com.nopcommerce.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nopcommerce.qa.baseclass.BaseClass;

public class SearchPage extends BaseClass{

	
	private WebDriver driver;
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'search-result')]")
	private WebElement found_search_result;
	
	@FindBy(xpath="//div[contains(@class,'no-result')]")
	private WebElement no_search_result;
	
	
	public boolean displayedSearchResult() {
		return displayedExpectedText(found_search_result);
	}
	
	public boolean displayedNoSearchResult() {
		return displayedExpectedText(no_search_result);
	}
}
