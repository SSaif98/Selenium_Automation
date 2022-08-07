import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class count_links_onPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//1. Get all the links on the page
		//2. Get all the links on the page that is in footer
		//3. Get all the links on the page that is in footer's 1st column
		//4. Click all the links on the page that is in footer's 1st column and get there titles.
		
		//Ans# 1
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//Ans#2
		WebElement footer = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		//Ans#3	
		WebElement footerC1 = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(	footerC1.findElements(By.tagName("a")).size());
		
		//Ans#4
		
		Actions a= new Actions(driver);
		for(int i =1; i< footerC1.findElements(By.tagName("a")).size();i++) {
			
			a.moveToElement(footerC1.findElements(By.tagName("a")).get(i)).keyDown(Keys.CONTROL).click().build().perform();
		}
		
		Set<String>	windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext()) {
		driver.switchTo().window(it.next());
		System.out.println(driver.getTitle());
		}
		
		
	
		
	}

}
