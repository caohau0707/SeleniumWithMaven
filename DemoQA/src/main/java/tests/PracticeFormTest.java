package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
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
		String date = "31 August 2022";
		String subjects = "Maths";
		String picture= "/Users/admin/Documents/Screenshot 2022-08-11 at 23.54.27.png";//command option c
		// String[] arr = picture.split("/");
		// => arr = ["", "Users", "admin", "Documents", "Screen..."]
		// arr[3]
		// (chuoi) picture.length() => 59 
		// (mang) picture.split("/").length => 5 
		String currentAddress = "Ha Noi";
		String selectState = "NCR";
		String selectCity = "Delhi";
		String gender = "Female";
		
		// expect result (formatted output)
		String expectPicture = picture.split("/")[picture.split("/").length - 1];
		String[] arrayDate = date.split(" ");
		String joined = String.join(" ", arrayDate[0], arrayDate[1]);
		String expectDate = String.join(",", joined, arrayDate[2]);
		// System.out.println(expectDate);
		
		
		HomePage homePage = new HomePage(testBase.driver);
		homePage.scroll();
		ElementsPage elementsPage = homePage.clickOnForms();
		PracticeFormPage practiceFormPage = elementsPage.clickonForm();
		homePage.scroll();
		practiceFormPage.inputData(firstName, lastName, userEmail, userNumber,date, subjects, picture, currentAddress, selectState, selectCity, gender);
		practiceFormPage.clickonSubmit();	
		System.out.println(testBase.driver);
		Assert.assertEquals(firstName + " " + lastName, practiceFormPage.getDataAfterSubmit(practiceFormPage.valueStudentName));
		Assert.assertEquals(userEmail, practiceFormPage.getDataAfterSubmit(practiceFormPage.valueStudentEmail));
		Assert.assertEquals(userNumber, practiceFormPage.getDataAfterSubmit(practiceFormPage.valueMobile));
		
		Assert.assertEquals(expectDate, practiceFormPage.getDataAfterSubmit(practiceFormPage.valueDateofBirth));
		
		
		Assert.assertEquals(subjects, practiceFormPage.getDataAfterSubmit(practiceFormPage.valueSubjects));
		Assert.assertEquals(expectPicture, practiceFormPage.getDataAfterSubmit(practiceFormPage.valuePicture));
		Assert.assertEquals(currentAddress, practiceFormPage.getDataAfterSubmit(practiceFormPage.valueAddress));
		Assert.assertEquals(selectState + " " + selectCity , practiceFormPage.getDataAfterSubmit(practiceFormPage.valueStateandCity));
		
		
		

//		practiceFormPage.clickonClose();
	}

}
