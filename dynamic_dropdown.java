import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamic_dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		/*
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		driver.findElement(By.linkText("Lakhimpur (IXI)")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@value = 'BOM'])[2]")).click();
		*/
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();

		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value = 'AIP']")).click();
	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value = 'UDR']")).click();
		
		
		
		
	}

}
