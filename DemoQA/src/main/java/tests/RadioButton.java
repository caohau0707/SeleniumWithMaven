package tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import pages.CheckBoxPage;
import pages.ElementsPage;
import pages.HomePage;
import pages.RadioButtonPage;

public class RadioButton extends TestCase{
	@Test
	public void verifyRadioButton() {
		HomePage homePage = new HomePage(testBase.driver);
		homePage.scroll();
		ElementsPage elementPage = homePage.clickOnElements();
		RadioButtonPage radioButtonPage = elementPage.clickonRadioButton();
		radioButtonPage.clickRadioButtonImpressive();
		Assert.assertTrue(radioButtonPage.verifyTextImpressive("You have selected impressive"));
	   //  radioButtonPage.clickRadioButtonYes();
	  //  Assert.assertTrue(radioButtonPage.verifyText("You have selected Yes"));	
	}

}
