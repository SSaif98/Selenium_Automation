import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class section12_assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//Number of Rows and Columns
		//Print 2nd Row Data
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		//Number of Rows 
		int rows =	driver.findElements(By.cssSelector("table[name='courses'] tr")).size();
		System.out.println("Number of Rows are: "+rows);
		//Number of Columns 
		int columns =	driver.findElements(By.cssSelector("table[name='courses'] th")).size();
		System.out.println("Number of Rows are: "+rows);
		
	System.out.println(driver.findElement(By.cssSelector("table[name='courses'] tr:nth-child(3)")).getText());
	
	}

}


/*  Teacher Example
 WebElement table=driver.findElement(By.id("product"));
System.out.println(table.findElements(By.tagName("tr")).size());
System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
System.out.println(secondrow.get(0).getText());
System.out.println(secondrow.get(1).getText());
System.out.println(secondrow.get(2).getText());
 */