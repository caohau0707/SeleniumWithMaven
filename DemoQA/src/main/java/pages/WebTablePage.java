package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTablePage extends Page {
	public WebTablePage(WebDriver dr) {
		super(dr);
	}
	public By firstName = By.xpath("(//div[@class='rt-tbody']//div[@role='row'])[1]/div[1]");
	public By lastName = By.xpath("(//div[@class='rt-tbody']//div[@role='row'])[1]/div[2]");
	public By age =By.xpath("(//div[@class='rt-tbody']//div[@role='row'])[1]/div[2]");
	public By Email = By.xpath("(//div[@class='rt-tbody']//div[@role='row'])[1]/div[2]");
	public By Salary = By.xpath("(//div[@class='rt-tbody']//div[@role='row'])[1]/div[2]");
	public By Department =By.xpath("(//div[@class='rt-tbody']//div[@role='row'])[1]/div[2]");
	

	public void inputSearchKeyWord(String searchKeyWord) {
		driver.findElement(By.id("searchBox")).sendKeys(searchKeyWord);
	}

	public boolean verifySearchResults(String keyword, String fieldName) {
		boolean result = true;
		List<WebElement> elementList = driver.findElements(getXpathByTableHeader(fieldName));
		for (WebElement e: elementList) {
			if(!e.getText().contains(keyword))//neu khong thoa man la false
				result = false;
		}
		return result;
		//// *[@role='row']/div[1]
		// lay dong //*[text()='First
		//// Name']/../../../following-sibling::div//div[@role='row']/div[1]
	}

	By getXpathByTableHeader(String fieldName) {
		By result = null;
		switch(fieldName)
		{
		case "First Name":
		{
			result = By.xpath("//*[@role='row']/div[1]");
			break;
		}
			
	   case "Last Name":
		{ 
			result = By.xpath("//*[@role='row']/div[2]");
			break;
		}
	   case "Age":
	   {
		   result = By.xpath("//*[@role='row']/div[3]");
			break;  
	   }
	   case "Email":
	   {
		   result = By.xpath("//*[@role='row']/div[4]");
			break;  
	   }
	   case "Salary":
	   {
		   result = By.xpath("//*[@role='row']/div[5]");
			break;  
	   }
	   case "Department":
	   {
		   result = By.xpath("//*[@role='row']/div[6]");
			break;  	
	   }
	   default: System.out.println("truyen sai field name");
		
	}
		return result;
	}
	
	public void clickonAdd() {
		driver.findElement(By.id("addNewRecordButton")).click();
	}
	public void inputDataRegistrationForm(String FirstName, String LastName, String Email, String Age, String Salary, String Department) {
		driver.findElement(By.id("firstName")).sendKeys(FirstName);
		driver.findElement(By.id("lastName")).sendKeys(LastName);
		driver.findElement(By.id("userEmail")).sendKeys(Email);
		driver.findElement(By.id("age")).sendKeys(Age);
		driver.findElement(By.id("salary")).sendKeys(Salary);
		driver.findElement(By.id("department")).sendKeys(Department);
		driver.findElement(By.id("submit")).click();
	}
	public boolean verifyDataAfterSubmit(By locator, String expectedData) {
		boolean result = false;
		String actualData = driver.findElement(locator).getText();
		if(actualData.equals(expectedData)) {
			return true;
		}
		return result;
	}
	
	
}


