import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/draggable/");
		driver.findElement(By.linkText("Droppable")).click();
		
	driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	driver.findElement(By.id("draggable")).click();
	WebElement source = driver.findElement(By.id("draggable"));
	WebElement target = driver.findElement(By.id("droppable"));
	
	Actions a = new Actions(driver);
	a.dragAndDrop(source, target).build().perform();
	driver.switchTo().defaultContent();
	driver.findElement(By.linkText("Accept")).click();

	

	}

}
