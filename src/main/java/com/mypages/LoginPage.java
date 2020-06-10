/**
 * 
 */
package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Maha Hameed
 *
 */
public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By emailId = By.id("username");
	private By password = By.id("password");
	private By loginBtn = By.id("loginBtn");
	private By header = By.xpath("//i18n-string[@data-key='login.signupLink.text']");

	public WebElement getEmailId() {
		return getElement(emailId);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}

	public WebElement getHeader() {
		return getElement(header);
	}

	public String getPageTitle() {
		return getPageBaseTitle();
	}

	public String getPageHeader() {

		return getPageHeader(header);
	}

	public HomePage doLogin(String username, String pwd) {

		getEmailId().sendKeys(username);
		getPassword().sendKeys(pwd);
		getLoginBtn().click();

		return getInstance(HomePage.class);
	}
	
	
	//negative TC with Overloading
	public void doLogin() {
		getEmailId().sendKeys("");
		getPassword().sendKeys("");
		getLoginBtn().click();

	}

}