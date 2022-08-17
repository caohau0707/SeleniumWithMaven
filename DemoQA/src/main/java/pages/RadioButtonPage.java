package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonPage extends Page{

	public RadioButtonPage(WebDriver dr) {
		super(dr);
	}
	public void clickRadioButtonYes() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label")).click();
	}
	public boolean verifyText( String expected) {
		boolean result =false;
		WebElement divresult = driver.findElement(By.xpath("//span[text()='Yes']"));
		String resultData = "You have selected ";
		resultData +=divresult.getText();
		if(resultData.equals(expected)) {
			result=true;
		}
		return result;
		
	}
	public void clickRadioButtonImpressive() {
		driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
	}
	public boolean verifyTextImpressive(String expected) {
		boolean result =false;
		WebElement divresult = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p/span"));
		String resultData = "You have selected ";
		resultData +=divresult.getText();
		if(resultData.equals(expected)) {
			result = true;
		}
		return result;
	}

	

}
