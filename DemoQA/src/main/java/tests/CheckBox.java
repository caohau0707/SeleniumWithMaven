     package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckBoxPage;
import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;

public class CheckBox extends TestCase{
	@Test
	public void verifyData() {
		HomePage homePage = new HomePage(testBase.driver);
		homePage.scroll();
		ElementsPage elementsPage = homePage.clickOnElements();
		CheckBoxPage checkBoxPage = elementsPage.clickonCheckBox();
		Assert.assertFalse(checkBoxPage.observeScreen(checkBoxPage.inputCheckBoxHome));
		checkBoxPage.clickonCheckBoxHome();
		String textIsShow = "You have selected : home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile";
  //      Assert.assertTrue(checkBoxPage.(textIsShow));
//	    checkBoxPage.clickIconTick();
//		Assert.assertTrue(checkBoxPage.dataDisplayed(checkBoxPage.olElement));
//		Assert.assertTrue(checkBoxPage.isCheckedAll());
//		checkBoxPage.clickOffCheckBox();
//		Assert.assertTrue(checkBoxPage.dataDisplayed(checkBoxPage.olElement));
//		System.out.println(checkBoxPage.uncheckAll());
	//	Assert.assertTrue(checkBoxPage.uncheckAll());
		Assert.assertEquals(checkBoxPage.getText(),textIsShow);
		
		
	}
	
	
	
	

}
