import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
	Set<String>	windows =	driver.getWindowHandles();
	Iterator<String> it = windows.iterator();
	String parentId= it.next();
	String childId = it.next();
	driver.switchTo().window(childId);
	
	System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
	
/*	String[] text= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at");
	String[] splittedText = text[1].split("with");
	String trimText = splittedText[0].trim();
	System.out.println(trimText); */
	
	String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].split("with")[0].trim();
	driver.switchTo().window(parentId);
	driver.findElement(By.id("username")).sendKeys(emailId);

		
	}

}
