package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserWindownsPage extends Page{
	public BrowserWindownsPage(WebDriver dr) {
		super (dr);
	}
	//click mo ra tap moi	
	public void newTap() {
		driver.findElement(By.id("tabButton")).click();
		//luu lai lop windown dau tien
		String MainWindown = driver.getWindowHandle();
		System.out.println(MainWindown);

        // Get all new opened tab Window.
        Set<String> windows = driver.getWindowHandles();

		//Set la mot collection de luuw cac phan tu gia tri khong trung lap
		//cach duyet tung phan tu khong trung lap trong collection (set)
		for (String window : windows) {
			System.out.println(window);
			if(!MainWindown.equals(window)) {
				//so sanh neu thang nao khac thang chinh (dau tien) thi chuyen huong qua no
				//switch to child windown
				driver.switchTo().window(window);
				System.out.println("Da chuyen den lop windown con");
				
				//Mot so ham ho tro 
				System.out.println(driver.switchTo().window(window).getTitle());
				System.out.println(driver.switchTo().window(window).getCurrentUrl());
			}
		}
	}
	public void newWindow() throws Throwable {
		driver.findElement(By.id("windowButton")).click();
		String MainWindow = driver.getWindowHandle();
		System.out.println(MainWindow);
		Set<String> windows = driver.getWindowHandles();
		for(String window: windows) {
			System.out.println(window);
			if(!MainWindow.equals(window)) {
				driver.switchTo().window(window);
				 Thread.sleep(2000);
				System.out.println("Da chuyen den windown con");
				System.out.println(driver.switchTo().window(window).getTitle());
				System.out.println(driver.switchTo().window(window).getCurrentUrl());
				driver.close();
			}
		}
	}
	
	public void newWindowMessage() {
		driver.findElement(By.id("messageWindowButton")).click();
		String MainWindow = driver.getWindowHandle();
		System.out.println(MainWindow);
		Set<String> windows = driver.getWindowHandles();
		for(String window: windows) {
			if(!MainWindow.equals(window)) {
				System.out.println(driver.switchTo().window(window).findElement((By.xpath("/html/body/text()"))).getText());
				System.out.println(driver.switchTo().window(window).getCurrentUrl());
				driver.close();
			}
		}
	}
	

}
