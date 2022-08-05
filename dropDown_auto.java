import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class dropDown_auto {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement staticOptions = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select staticDropDown = new Select(staticOptions);
		staticDropDown.selectByIndex(2);		
		System.out.println(staticDropDown.getFirstSelectedOption().getText());
		
		staticDropDown.selectByValue("USD");
		System.out.println(staticDropDown.getFirstSelectedOption().getText());
		
		staticDropDown.selectByVisibleText("INR");
		System.out.println(staticDropDown.getFirstSelectedOption().getText());
		
		driver.findElement(By.xpath("//div[@class='paxinfo']")).click();
		
		Thread.sleep(2000);
		//Selecting 3 Adults [1 is already selected so we have to press the button 2 times]
	
		int j=0;
		while(j<2) {
			driver.findElement(By.cssSelector("span#hrefIncAdt")).click();
			j++;
		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("hrefDecAdt")).click();
		Thread.sleep(2000);
		//System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"2 Adult");
		
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		

		
		
	}

}
