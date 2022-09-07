package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;

public class TextBoxText extends TestCase {
	
	// TC1
	@Test
	public void submitSucessfully() {
		//dinh nghia input truyen vao thong qua cac bien
		String userName = "Hau Cao";
		String userEmail = "test@123gmail.com";
		String currentAddress = "Current Address";
		String permanentAddress = "Permanent Address";

		HomePage homePage = new HomePage(testBase.driver);
		
		homePage.scroll();
		ElementsPage elementsPage = homePage.clickOnElements();
		
		TextBoxPage textBoxpage = elementsPage.clickonTextBox();
		
		
		
		textBoxpage.inputData(userName, userEmail, currentAddress, permanentAddress);
		homePage.scroll();
		textBoxpage.submit();
		Assert.assertTrue(textBoxpage.verifyData(textBoxpage.lbNameElement, userName));
		Assert.assertTrue(textBoxpage.verifyData(textBoxpage.lbEmailElement, userEmail));
		Assert.assertTrue(textBoxpage.verifyData(textBoxpage.lbcurrentAddressElement, currentAddress));
		Assert.assertTrue(textBoxpage.verifyData(textBoxpage.lbpermanentAddressElement, permanentAddress));
	}

	// TC2
//	@Test
//	public void validateEmail(){
//		String userName = "Hau Cao";
//		String userEmail = "test123gmail.com";
//		String currentAddress = "Current Address";
//		String permanentAddress = "Permanent Address";
//
//		HomePage homePage = new HomePage(testBase.driver);
//		homePage.scroll();
//		ElementsPage elementsPage = homePage.clickOnElements();
//		TextBoxPage textBoxpage = elementsPage.clickonTextBox();
//		textBoxpage.inputData(userName, userEmail, currentAddress, permanentAddress);
//		textBoxpage.submit();
		//textBoxpage.verifyRedBorder(textBoxpage.txtUserEmail);
//}
	}


