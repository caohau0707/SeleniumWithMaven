package common;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public ChromeDriver driver;
	
	
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/admin/Documents/01Tool/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
	}

}
