package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class HomePage extends Page {

	public HomePage(WebDriver dr) {
		super(dr);
	}

	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	}
	
	public ElementsPage clickOnElements() {
		driver.findElement(By.xpath("//h5[text()='Elements']")).click();
		return new ElementsPage(driver);
	}
	public ElementsPage clickOnForms () {
		driver.findElement(By.xpath("//h5[text()='Forms']")).click();
		return new ElementsPage(driver);
	}
}
