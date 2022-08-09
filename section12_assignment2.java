import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class section12_assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
Actions a = new Actions(driver);
	a.moveToElement(driver.findElement(By.id("autocomplete"))).click().sendKeys("pa").build().perform();

		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
	    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);	   
	    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
	    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);	
	    /*
	List<WebElement>	countryList =	driver.findElements(By.cssSelector(".ui-menu-item"));
	for(int i=0; i<countryList.size(); i++) {
		if(countryList.get(i).getText().equalsIgnoreCase("Pakistan")) {
			a.moveToElement(countryList.get(i)).click().build().perform();
		}
	}
	*/
	System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
//Assert.assertEquals(driver.findElement(By.id("autocomplete")).getAttribute("value"), "Pakistan");

	}

}
