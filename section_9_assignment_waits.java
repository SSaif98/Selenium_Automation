import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class section_9_assignment_waits {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		String[] impNote = driver.findElement(By.xpath("//p[@class = 'text-center text-white']")).getText().split("and");
		String[] trimmedUser = impNote[0].split("is");		
		String userName= trimmedUser[1].trim();
		
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//span[contains (text(),'User')]")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(4));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		
		driver.findElement(By.id("okayBtn")).click();
		
		WebElement op = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select options= new Select(op);
		
		options.selectByValue("consult");
		driver.findElement(By.id("terms")).click();
		
		driver.findElement(By.id("signInBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("ProtoCommerce")));
	
	List<WebElement> mobileCartList = 	driver.findElements(By.xpath("//div[@class='card-footer']"));
	for(int i=0; i<mobileCartList.size();i++) {
		driver.findElements(By.cssSelector(".btn.btn-info")).get(i).click();
	}
	driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();
	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-success']")));
	driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
	
	driver.findElement(By.id("country")).sendKeys("pa");
	
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(8));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='suggestions']/ul/li/a")));

	List<WebElement> countryList =  driver.findElements(By.xpath("//div[@class='suggestions']/ul/li/a"));
	
	for(WebElement country : countryList) {
		if(country.getText().equalsIgnoreCase("Pakistan")) {
			country.click();
		}
	}
	Thread.sleep(2000);
	driver.findElement(By.id("checkbox2")).click();
	driver.findElement(By.xpath("//input[@value='Purchase']")).click();
	Assert.assertEquals(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText(), "Success! Thank you! Your order will be delivered in next few weeks :-).");

	}

}
