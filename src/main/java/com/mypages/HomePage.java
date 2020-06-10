package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By header=By.xpath("//i18n-string[@data-key='app.header']");

	public WebElement getHeader() {
		return getElement(header);
	}
	
	public String getPageTitle() {
		return getPageTitle();
	}

	public String getPageHeader() {

		return getPageHeader(header);
	}

}
