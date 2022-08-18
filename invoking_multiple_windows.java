import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class invoking_multiple_windows {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.switchTo().newWindow(WindowType.TAB);

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElements(By.cssSelector("a[href*= 'https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		
		driver.switchTo().window(parentWindow);
		WebElement name= driver.findElement(By.xpath("//input[@name='name']"));
		name.sendKeys(courseName);
		//screenshot of particular webelement
	File file=		name.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, new File("D://screenshot.png"));
	
	//Height and width of webelement
	System.out.println(name.getRect().getDimension().getHeight());
	System.out.println(name.getRect().getDimension().getWidth());

	}

}
