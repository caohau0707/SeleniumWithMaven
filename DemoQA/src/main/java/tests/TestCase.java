package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import common.TestBase;

public class TestCase {
	TestBase testBase = new TestBase();
	@BeforeMethod
	public void openBrowser() {
		testBase.openBrowser();	
	}
	//@AfterMethod
	public void closeBrowser() {
		testBase.driver.quit();
	}
	

}
