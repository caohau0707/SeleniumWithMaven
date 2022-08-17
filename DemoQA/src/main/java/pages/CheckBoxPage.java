package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxPage extends Page{

	public CheckBoxPage(WebDriver dr) {
		super(dr);
	}
	public By checkboxHome = By.xpath("//span[@class='rct-title']");
	public By iconTick = By.xpath("//*[@class='rct-icon rct-icon-expand-close']");
	public By checkBoxDestop = By.xpath("//span[text()='Desktop']");
	public By olElement = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol");
	public By inputCheckBoxHome = By.id("tree-node-home");
	//public By checkboxHome = By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label/span[1]");
	
	public boolean observeScreen(By locator) {
		boolean result = driver.findElement(locator).isSelected();
		return result;
	}
	public void clickonCheckBoxHome() {
		driver.findElement(checkboxHome).click();
	}
	public boolean verifyCheckBoxHome(String expectedData) {
		boolean result =false;
		WebElement divResult = driver.findElement(By.id("result"));
		List<WebElement> listspan = divResult.findElements(By.className("text-success"));
		String resultData ="You have selected : ";
		for(WebElement spantext: listspan) {
			resultData +=spantext.getText() + " ";
		}
		resultData=resultData.trim();
		if(resultData.equals(expectedData)) {
			result = true;
		}
		return result;
	}
	public void clickIconTick() {
		driver.findElement(iconTick).click();
	}
	public boolean dataDisplayed(By locator) {
		boolean result = driver.findElement(locator).isDisplayed();
		return result;	
	}
	public boolean isCheckedAll() {
		boolean result =true;
		WebElement olResult = driver.findElement(olElement);
		List<WebElement> listspan = olResult.findElements(By.tagName("input"));
		for(WebElement span: listspan) {
			if(span.isSelected()==false) {//neu span.isSelected = false thi thuc hien trong if
				result = false;
				break;
			}		
		}
		return result;
		
	}
	public void clickOffCheckBox() {
		driver.findElement(checkboxHome).click();
	}
	public boolean uncheckAll() {
		boolean result = false;
		WebElement olResult = driver.findElement(olElement);
		List <WebElement> listspan = olResult.findElements(By.tagName("input"));
		for(WebElement span: listspan) {
			if(span.isSelected()== true) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	}
	

	
	

