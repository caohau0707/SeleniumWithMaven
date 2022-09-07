package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage extends Page{
	public TextBoxPage(WebDriver dr) {
		super(dr);
		
	}
	public By lbNameElement = By.id("name");
	//String expectPicture = lbNameElement.split("/")[lbNameElement.split("/").length - 1];
	
	public By lbEmailElement = By.id("email");
	public By lbcurrentAddressElement = By.id("currentAddress");
	public By lbpermanentAddressElement = By.id("permanentAddress");
	public By txtUserEmail = By.id("userEmail");
	
	public void inputData(String name, String email, String currentAddress, String permanentAddress ) {
		driver.findElement(By.id("userName")).sendKeys(name);
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id='currentAddress']")).sendKeys(currentAddress);
		driver.findElement(By.xpath("//*[@id='permanentAddress']")).sendKeys(permanentAddress);
		
	}
	public void submit() {
		WebElement elementSubmit = driver.findElement(By.id("submit"));
		clickOnElementByJS(elementSubmit);
		System.out.println(driver.findElement(lbNameElement).getText());
	//driver.findElement(By.xpath("//*[@id='submit']")).submit();
	}
	public boolean verifyData(By loacator, String expectedData) {
		boolean result = false;
		String actualData = driver.findElement(loacator).getText();
		if(actualData.equals(expectedData)) {
		result = true;
	}
	return result;
	
}

}
