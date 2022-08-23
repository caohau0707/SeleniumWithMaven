package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {

	public static WebDriver driver;

	public Page(WebDriver dr) {
		this.driver = dr;
	}
	public void clickOnElementByJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
}
