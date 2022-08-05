import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class java_alert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");

		driver.findElement(By.xpath("//div[@id = 'divpaxinfo']")).click();
		
		Thread.sleep(3000);
		for(int i=0 ; i<9; i++) {
			driver.findElement(By.cssSelector("#hrefIncAdt")).click();
		}
		System.out.println(driver.switchTo().alert().getText());
		Assert.assertEquals(driver.switchTo().alert().getText(), "You are allowed a maximum of 9 passengers per booking online. If your party is larger than this, please call our reservation center.");
		driver.switchTo().alert().accept();
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice");
	}

}
