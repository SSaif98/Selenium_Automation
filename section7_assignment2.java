import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class section7_assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("//div[@class = 'form-group'] //input[@name='name']")).sendKeys("Syed Saif Ali");
		//(//input[@name = 'name'])[1]
		driver.findElement(By.cssSelector("div[class = 'form-group'] input[name='email']")).sendKeys("abc123@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder ='Password']")).sendKeys("abcd####");
		driver.findElement(By.id("exampleCheck1")).click();
		Assert.assertTrue(driver.findElement(By.id("exampleCheck1")).isSelected());
		
		driver.findElement(By.id("exampleFormControlSelect1")).click();
		WebElement options = driver.findElement(By.id("exampleFormControlSelect1"));
		Select staticOptions = new Select(options);
		staticOptions.selectByVisibleText("Male");
	//	System.out.println(staticOptions.getFirstSelectedOption().getText());
		Assert.assertEquals(staticOptions.getFirstSelectedOption().getText(), "Male");
		driver.findElement(By.id("inlineRadio2")).click();		
		Assert.assertFalse(driver.findElement(By.id("inlineRadio3")).isEnabled());
		
		driver.findElement(By.xpath("//input[@name = 'bday']")).sendKeys("12/24/2022");
		driver.findElement(By.cssSelector(".btn")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
	}

}
