import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigation_automation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//If we use bellow method then it will wait until complete page and its content is loaded
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		//If we use bellow method then it will wait for the  page to be open as soon as it is loaded it will move to other script
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		driver.navigate().back();
		driver.navigate().refresh();
		driver.navigate().forward();
		
		
	}

}
