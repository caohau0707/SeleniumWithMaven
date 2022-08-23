package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends Page {

	public HomePage(WebDriver dr) {
		super(dr);
	}

	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	}
	
	public ElementsPage clickOnElements() {
		WebElement element = driver.findElement(By.xpath("//div[@class='category-cards']/div[1]"));
		clickOnElementByJS(element);
		return new ElementsPage(driver);
	}
	public ElementsPage clickOnForms () {
		driver.findElement(By.xpath("//div[@class='category-cards']/div[2]")).click();
		return new ElementsPage(driver);
	}
	
}
