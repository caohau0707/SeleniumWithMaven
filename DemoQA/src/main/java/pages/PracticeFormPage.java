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

	// public By genderElement = By.xpath("//input[@id='gender-radio-1']/..");
	public String genderXpath = "//*[text()='{@param}']/..";

	// Thanks form
	public By valueStudentName = By.xpath("//td[text()='Student Name']/following-sibling::td");
	public By valueStudentEmail = By.xpath("//td[text()='Student Email']/following-sibling::td");
	public By valueGender = By.xpath("//td[text()='Gender']/following-sibling::td");
	public By valueMobile = By.xpath("//td[text()='Mobile']/following-sibling::td");
	public By valueDateofBirth = By.xpath("//td[text()='Date of Birth']/following-sibling::td");
	public By valueSubjects = By.xpath("//td[text()='Subjects']/following-sibling::td");
	public By valueHobbies = By.xpath("//td[text()='Hobbies']/following-sibling::td");
	public By valuePicture = By.xpath("//td[text()='Picture']/following-sibling::td");
	public By valueAddress = By.xpath("//td[text()='Address']/following-sibling::td");
	public By valueStateandCity = By.xpath("//td[text()='State and City']/following-sibling::td");

	public void inputData(String firstName, String lastName, String email, String mobile, String date, String subjects,
			String picture, String currentAddress, String selectState, String selectCity, String gender) {
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("userEmail")).sendKeys(email);
		WebElement e = driver.findElement(createXpathByText(genderXpath, gender));
		e.click();
		driver.findElement(By.id("userNumber")).sendKeys(mobile);
		DatePicker(date);
		// setWidown();
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

//	public void verifyDataBeforeClickSubmit(String firstName, String lastName, String email, String mobile, String date,
//			String subjects, String picture, String currentAddress, String selectState, String selectCity) {
//		Assert.assertEquals(firstName, driver.findElement(lbFirstName).getAttribute("value"));

	public void clickonSubmit() {
		driver.findElement(By.xpath("//button[@id='submit']")).submit();
//		WebElement elementSubmit = driver.findElement(By.id("submit"));
//		clickOnElementByJS(elementSubmit);

	}

	public String getDataAfterSubmit(By locator) {

		return driver.findElement(locator).getText();
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
		
//		List<WebElement> dayList = driver.findElements(By.xpath("//div[@class='react-datepicker__week']/div"));
//		int[] index = new int[2];
//		int i = 0;
//		for (WebElement e : dayList) {
//			if (e.getText().equals("1")) {
//				index[i] = dayList.indexOf(e);
//				i++;
//			}
//		}
				

//		for (int k = index[0]; k < index[1] - 1; k++) {
//			System.out.println(dayList.get(k).getAttribute("aria-label"));
//			if (dayList.get(k).getText().equals(newDay)) {
//				dayList.get(k).click();
//			}
//		}
		// VD
		// String a = String.format("hello %s %d", "haucao", 8) => "hello haucao 8"
		String xpathDay = String.format("(//div[contains(@aria-label, ', %s %s')])[1]", splittedDate[1] ,newDay);
		WebElement dayElement = driver.findElement(By.xpath(xpathDay));
		dayElement.click();		

		// lay xpath cua day
		// Cach lay xpath thu 2 =
		// (//div[contains(@class,'react-datepicker__dayreact-datepicker__day--') and
		// text()='%s'])[1]
//		String xpathDay = String.format("(//div[@class='react-datepicker__week']/div[text()='%s'])[1]", newDay);
//		WebElement dayElement = driver.findElement(By.xpath(xpathDay));
//		dayElement.click();
	}

	public void zoomout() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.body.style.zoom ='0.6'");
	}

	public By createXpathByText(String locatorXpath, String text) {
		String elementXpath = locatorXpath.replace("{@param}", text);
		return By.xpath(elementXpath);

	}

}
