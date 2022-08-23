package tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import pages.ButtonsPage;
import pages.ElementsPage;
import pages.HomePage;

public class ButtonTest extends TestCase{
	@Test
	
	public void clickdone() {
		String msgep = "You have done a double click";
		HomePage homePage = new HomePage(testBase.driver);
		ElementsPage elementPage = homePage.clickOnElements();
		homePage.scroll();
		ButtonsPage buttonsPage = elementPage.clickonButtons();
		buttonsPage.clickonButton1();
		Assert.assertTrue(buttonsPage.verifyData(buttonsPage.msg, msgep));
		
	}

}
