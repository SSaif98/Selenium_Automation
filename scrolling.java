import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class scrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		List<WebElement>	values =	driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int value=0;
		for(int i =0 ; i< values.size() ;i++) {
			value  += Integer.parseInt(values.get(i).getText());
		}
		System.out.println(value);
		Integer  totalAmount = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());	
		Assert.assertEquals(totalAmount, value);
		

		int priceSum=0;
	List<WebElement>	coursePrices= driver.findElements(By.cssSelector("table[name='courses'] td:nth-child(3)"));
	for(int i =0; i<coursePrices.size() ; i++) {
		  priceSum +=	Integer.parseInt(coursePrices.get(i).getText());
	}
	System.out.println(priceSum);

	}

}
