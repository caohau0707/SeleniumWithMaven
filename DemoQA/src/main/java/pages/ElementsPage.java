package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class ElementsPage extends Page{
	public ElementsPage(WebDriver dr) {
		super(dr);
	}

	public TextBoxPage clickonTextBox() {
		driver.findElement(By.xpath("//span[text() ='Text Box']")).click();
		return new TextBoxPage(driver);
	}
	public CheckBoxPage clickonCheckBox() {
		driver.findElement(By.xpath("//span[text() ='Check Box']")).click();
		return new CheckBoxPage(driver);
	}
	public RadioButtonPage clickonRadioButton() {
		driver.findElement(By.xpath("//span[text()='Radio Button']")).click();
		return new RadioButtonPage(driver);
	}

}
