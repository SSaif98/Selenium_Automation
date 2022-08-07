import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class section10_assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		
	Set<String>	windows = driver.getWindowHandles();
	 Iterator<String> it =	windows.iterator();
	String parentId = it.next();
	String childId = it.next();
	
	driver.switchTo().window(childId);
	System.out.println(driver.findElement(By.xpath("//div[@class = 'example']/h3")).getText());
	driver.switchTo().window(parentId);
	System.out.println(driver.findElement(By.xpath("//div[@class = 'example']/h3")).getText());

	
	}

}
