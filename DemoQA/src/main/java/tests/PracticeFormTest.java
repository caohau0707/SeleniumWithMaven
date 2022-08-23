package tests;

import org.testng.annotations.Test;

import pages.ElementsPage;
import pages.HomePage;
import pages.PracticeFormPage;
import pages.TextBoxPage;

public class PracticeFormTest extends TestCase {
	@Test
	public void submitSuccessfully() {
		String firstName ="Cao";
		String lastName ="Hau";
		String userEmail ="caohau89@gmail.com";
		String userNumber ="0329190013";
		String date = "03 August 2022";
		String dateinput = "03 Aug 2022";
		String subjects = "Maths";
		String picture= "/Users/admin/Documents/Screenshot 2022-08-11 at 23.54.27.png";//command option c
		String pictureinput = "Screenshot 2022-08-11 at 23.54.27";
		String currentAddress = "Ha Noi";
		String selectState = "NCR";
		String selectCity = "Delhi";
		
		String title = "Thanks for submitting the form";
		String lable = "Label";
		String value = "Values";
		String sudentName = "Student Name";
		String valueSudentName = "Cao Hau";
		
		HomePage homePage = new HomePage(testBase.driver);
		homePage.scroll();
		ElementsPage elementsPage = homePage.clickOnForms();
		PracticeFormPage practiceFormPage = elementsPage.clickonForm();
		homePage.scroll();
		practiceFormPage.inputData(firstName, lastName, userEmail, userNumber,date, subjects, picture, currentAddress, selectState, selectCity);
		practiceFormPage.verifyDataBeforeClickSubmit(firstName, lastName, userEmail, userNumber,dateinput, subjects, pictureinput, currentAddress, selectState, selectCity);
		practiceFormPage.clickonSubmit();	
		practiceFormPage.verifyDataAfterClickSubmit( title,lable,value, sudentName,valueSudentName);
		practiceFormPage.clickonClose();
	}

}
