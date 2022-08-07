import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class section11_assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("checkBoxOption2")).click();

		String checkOp = driver.findElement(By.xpath("//label[@for='benz']")).getText();
		System.out.println(checkOp);

		driver.findElement(By.id("dropdown-class-example")).click();
		WebElement options = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(options);
		dropdown.selectByVisibleText(checkOp);

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("name"))).click().sendKeys(checkOp).build().perform();

		driver.findElement(By.id("alertbtn")).click();
		String alertMsg = driver.switchTo().alert().getText();
		if(alertMsg.contains(checkOp)) {
			System.out.println("Alert Successfull");
			driver.switchTo().alert().accept();

		}
		else {
			System.out.println("Alert Error");
			driver.switchTo().alert().dismiss();
		}
		
		}

}
