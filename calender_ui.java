import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calender_ui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.path2usa.com/travel-companions");
	
		//14 August
		driver.findElement(By.xpath(".//*[@id='travel_date']")).click();


		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May 2024"))
		{
		driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}

		
		List<WebElement>	days =	driver.findElements(By.className("day"));
		String day = "14";
		
		for(int i=0; i<days.size() ;i++) {
			
			if(days.get(i).getText().equalsIgnoreCase(day)) {
				days.get(i).click();
				break;
			}
		}
	}

}


/*
driver.get("https://www.sastaticket.pk/airline/pakistan-international-airlines");
driver.findElement(By.xpath("//label[text() = 'Departing']")).click();	
while(!(driver.findElement(By.xpath("//div[@class ='react-datepicker__header ']/div[@class= 'react-datepicker__current-month']")).getText().contains("December 2022")))
{
driver.findElement(By.xpath("//button[contains (text(),'Next Month')]")).click();
}
*/
