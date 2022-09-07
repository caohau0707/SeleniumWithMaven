package pages;

import org.openqa.selenium.Dimension;
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
	public void setWidown () {
		Dimension dm= new Dimension(700,1000);
		driver.manage().window().setSize(dm);
	}
	public void navigateTo(String url) {
		driver.navigate().to(url);
		
	}

}
