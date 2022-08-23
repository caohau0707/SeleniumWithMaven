package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class PracticeFormPage extends Page {
	public PracticeFormPage(WebDriver dr) {
		super(dr);
	}

	public By lbFirstName = By.id("firstName");
	public By lbLasttName = By.id("lastName");
	public By lbEmail = By.id("userEmail");
	public By radioButton = By.id("gender-radio-1");
	public By lbMobile = By.id("userNumber");
	public By datePicker = By.id("dateOfBirthInput");
	public By lbsubjects = By.xpath("//div[text()='Maths']");
	public By chbHobbies = By.id("hobbies-checkbox-1");
	public By uppicture = By.id("uploadPicture");
	public By lbcurrentAddress = By.id("currentAddress");
	public By dpselectState = By.xpath("//div[text()='NCR']");
	public By dpselectCity = By.xpath("//div[text()='Delhi']");
	
	public By lbTitle = By.id("example-modal-sizes-title-lg");
	public By lblabel = By.xpath("//th[text()='Label']");
	public By lbValue = By.xpath("//th[text()='Values']");
	public By studentName = By.xpath("//td[text()='Student Name']");
	public By valueStudentName = By.xpath("//td[text()='Cao Hau']");
	

	public void inputData(String firstName, String lastName, String email, String mobile, String date, String subjects,
			String picture, String currentAddress, String selectState, String selectCity) {
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("userEmail")).sendKeys(email);
		WebElement e = driver.findElement(By.xpath("//input[@id='gender-radio-1']/.."));
		e.click();
		driver.findElement(By.id("userNumber")).sendKeys(mobile);
		DatePicker(date);
		driver.findElement(By.id("subjectsInput")).sendKeys(subjects);
		driver.findElement(By.id("react-select-2-option-0")).click();

		driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']/..")).click();
		driver.findElement(By.id("uploadPicture")).sendKeys(picture);
		driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);
		zoomout();
		driver.findElement(By.xpath("//input[@id='react-select-3-input']")).sendKeys(selectState);
		WebElement elementState = driver.findElement(By.id("react-select-3-option-0"));
		clickOnElementByJS(elementState);
		// executor.executeScript("document.getElementById('react-select-3-option-0').click()");
//		driver.findElement(By.xpath("//div[@id='react-select-3-option-0']/..")).click();
		driver.findElement(By.xpath("//input[@id='react-select-4-input']")).sendKeys(selectCity);
		WebElement elementCity = driver.findElement(By.id("react-select-4-option-0"));
		clickOnElementByJS(elementCity);
	}

	public void verifyDataBeforeClickSubmit(String firstName, String lastName, String email, String mobile, String date,
			String subjects, String picture, String currentAddress, String selectState, String selectCity) {
		Assert.assertEquals(firstName, driver.findElement(lbFirstName).getAttribute("value"));
		Assert.assertEquals(lastName, driver.findElement(lbLasttName).getAttribute("value"));
		Assert.assertEquals(email, driver.findElement(lbEmail).getAttribute("value"));
		Assert.assertTrue(driver.findElement(radioButton).isSelected());
		Assert.assertEquals(mobile, driver.findElement(lbMobile).getAttribute("value"));
		Assert.assertEquals(date, driver.findElement(datePicker).getAttribute("value"));
		Assert.assertEquals(subjects, driver.findElement(lbsubjects).getText());
		Assert.assertTrue(driver.findElement(chbHobbies).isSelected());
		//Assert.assertEquals(picture, driver.findElement(uppicture).getAttribute("value"));
		Assert.assertEquals(currentAddress, driver.findElement(lbcurrentAddress).getAttribute("value"));
		Assert.assertEquals(selectState, driver.findElement(dpselectState).getText());
		Assert.assertEquals(selectCity, driver.findElement(dpselectCity).getText());
	}

	public void clickonSubmit() {
		WebElement elementSubmit = driver.findElement(By.id("submit"));
		clickOnElementByJS(elementSubmit);
	}
	public void verifyDataAfterClickSubmit(String title, String label, String value, String sudentName, String valueSudentName) {
		Assert.assertEquals(title, driver.findElement(lbTitle).getText());
		Assert.assertEquals(label, driver.findElement(lblabel).getText());
		Assert.assertEquals(value, driver.findElement(lbValue).getText());
		Assert.assertEquals(sudentName, driver.findElement(studentName).getText());
		Assert.assertEquals(valueSudentName, driver.findElement(valueStudentName).getText());
		
	}
	public void clickonClose() {
		WebElement elementClose = driver.findElement(By.id("closeLargeModal"));
		clickOnElementByJS(elementClose);
	}
	
	
	

	/**
	 * 
	 * 
	 * @param date (01 August 1990)
	 */

	public void DatePicker(String date) {
		// bam ra ca phan tu
		String[] splittedDate = date.split(" ");
		driver.findElement(By.id("dateOfBirthInput")).click();
		WebElement monthElement = driver.findElement(By.xpath("//div/div[1]/select"));
		Select month = new Select(monthElement);
		month.selectByVisibleText(splittedDate[1]);

		WebElement yearElement = driver.findElement(By.xpath("//div/div[2]/select"));
		Select year = new Select(yearElement);
		year.selectByVisibleText(splittedDate[2]);

		String day = splittedDate[0];
		String newDay = "";
		if (day.charAt(0) == '0') {
			newDay = day.replaceAll("0", "");
		} else {
			newDay = day;
		}
		// lay xpath cua day
		// Cach lay xpath thu 2 = (//div[contains(@class,'react-datepicker__dayreact-datepicker__day--') and text()='%s'])[1]
		String xpathDay = String.format("(//div[@class='react-datepicker__week']/div[text()='%s'])[1]", newDay);
		WebElement dayElement = driver.findElement(By.xpath(xpathDay));
		dayElement.click();
	}

	public void zoomout() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.body.style.zoom ='0.6'");
	}
}
