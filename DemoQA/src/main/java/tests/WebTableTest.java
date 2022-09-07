package tests;


import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.WebTablePage;

public class WebTableTest extends TestCase {
//	@Test
	public void searchByFirstNameSuccessfully() {
		String searchKeyWord = "Cie";
		WebTablePage webTablePage = new WebTablePage(testBase.driver);
		webTablePage.navigateTo("https://demoqa.com/webtables");
		webTablePage.inputSearchKeyWord(searchKeyWord);
		assertTrue(webTablePage.verifySearchResults(searchKeyWord, "First Name"));
	}
//	@Test
	public void searchLastNameSucessfully() {
		String searchKeyWordLastName = "Ve";
		WebTablePage webTablePage = new WebTablePage(testBase.driver);
		webTablePage.navigateTo("https://demoqa.com/webtables");
		webTablePage.inputSearchKeyWord(searchKeyWordLastName);
		assertTrue(webTablePage.verifySearchResults(searchKeyWordLastName, "Last Name"));
	}
	@Test
	public void verifyTextAfterSubmit() {
		String FirstName = "Linh";
		 String LastName = "Hoa";
		 String Email ="linh@gmail.com";
		 String Age ="20";
		 String Salary ="20000";
		 String Department ="bonee";
		WebTablePage webTablePage = new WebTablePage(testBase.driver);
		webTablePage.navigateTo("https://demoqa.com/webtables");
		webTablePage.clickonAdd();
		webTablePage.inputDataRegistrationForm(FirstName, LastName, Email, Age, Salary, Department);
		webTablePage.inputSearchKeyWord(FirstName);
		webTablePage.verifyDataAfterSubmit(webTablePage.firstName, FirstName);
		webTablePage.verifyDataAfterSubmit(webTablePage.lastName, LastName);
		webTablePage.verifyDataAfterSubmit(webTablePage.Email, Email);
		webTablePage.verifyDataAfterSubmit(webTablePage.age, Age);
		webTablePage.verifyDataAfterSubmit(webTablePage.Salary, Salary);
		webTablePage.verifyDataAfterSubmit(webTablePage.Department, Department);
	}
	

}
