package tests;

import org.testng.annotations.Test;

import pages.BrowserWindownsPage;
import pages.ElementsPage;
import pages.HomePage;

public class BrowserWindownsTest extends TestCase{
	@Test
	public void verifyOpenNewPage() throws Throwable {
		HomePage homePage = new HomePage(testBase.driver);
		ElementsPage elementPage = homePage.clickOnAlerts();
		homePage.scroll();
		BrowserWindownsPage browserWindownsPage = elementPage.clickOnAlerts();
	//	browserWindownsPage.newTap();
	//	browserWindownsPage.newWindow();
		browserWindownsPage.newWindowMessage();
	}
}
