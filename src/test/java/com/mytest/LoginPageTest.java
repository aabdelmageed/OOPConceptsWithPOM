/**
 * 
 */
package com.mytest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mypages.HomePage;
import com.mypages.LoginPage;

/**
 * @author Maha Hameed
 *
 */
public class LoginPageTest extends BaseTest{
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		
		String title=page.getInstance(LoginPage.class).getPageTitle();
		Assert.assertEquals(title, "HubSpot Login");
		
	}
	
	@Test(priority=2)
	public void verifyLoginPageHeaderTest() {
	String header=page.getInstance(LoginPage.class).getPageHeader();
	Assert.assertEquals(header, "Don't have an account?");
	}
	
	
	@Test(priority=3)
	public void doLogin() {
	HomePage homePage=page.getInstance(LoginPage.class).doLogin(prob.getProperty("username"), prob.getProperty("password"));
	String title=homePage.getPageHeader();
	Assert.assertEquals(title, "Dashboard Library");
	}
}
