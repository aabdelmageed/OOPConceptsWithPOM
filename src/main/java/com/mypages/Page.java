package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public Page(WebDriver driver) {
		this.driver = driver;
	}
	
	//Abstract Methods
	
	public abstract String getPageBaseTitle();
	public abstract String getPageHeader(By locator);
	public abstract WebElement getElement(By locator);
	public abstract void waitForElementPresent(By locator);

	public abstract void waitForPagetitle(String title);
	
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass ){
		try {
		 return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}catch(Exception e) {
			e.getMessage();
			return null;
			
		}
	}

}
