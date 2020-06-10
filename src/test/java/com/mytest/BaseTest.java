package com.mytest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.util.TestUtil;
import com.mypages.BasePage;
import com.mypages.Page;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prob;
	public Page page ;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	public static Logger log = Logger.getLogger(BaseTest.class);
	
	

	public BaseTest() {
		prob = new Properties();
		try {
			FileInputStream fis = new FileInputStream("D:\\Ahmed Adel\\Eclipse Work Space\\OOPConceptsPOM\\src\\test"
					+ "\\java\\com\\crm\\qa\\config\\config.properties");
			prob.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException o) {
			o.printStackTrace();
		}
	}
	@BeforeMethod
	public void setUp() {
		String browserName = prob.getProperty("browser");
		log.info("Lanching Chrome browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");

		}
		tdriver.set(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prob.getProperty("url"));
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		page = new BasePage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
}
