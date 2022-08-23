package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonsPage extends Page{

	public ButtonsPage(WebDriver dr) {
		super(dr);
	}
	public By msg = By.id("doubleClickMessage");
	public void clickonButton1() {
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		act.doubleClick(ele).perform();
	}
	public boolean verifyData(By msg, String expectedResult) {
		boolean result = true;
		String actualResult = driver.findElement(msg).getText();
		if(actualResult.equals(expectedResult)) {
			result = true;
		}
		return result;
	}
	

}
