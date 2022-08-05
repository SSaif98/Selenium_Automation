import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class seleniumLocators {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		seleniumLocators obj = new seleniumLocators();
		obj.iteration1(driver);
		
	Thread.sleep(1000);
	driver.findElement(By.xpath("//form/div/button[1]")).click();
	driver.findElement(By.cssSelector("input[placeholder*='User']")).sendKeys("saif");
	Thread.sleep(1000);
	driver.findElement(By.cssSelector("input[name*='input']")).sendKeys("rahulshettyacademy");
	driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();	
	Thread.sleep(1000);
	String verificationText= driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();
	System.out.println(verificationText);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[text()= 'Log Out']")).click();
	Assert.assertEquals(driver.findElement(By.cssSelector("form h1")).getText(), "Sign in");
	System.out.println("You are now logged out");	 

	}

	public void iteration1(WebDriver driver) {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
	//	driver.findElement(By.id("inputUsername")).sendKeys("saif");
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("saif");		
		driver.findElement(By.name("inputPassword")).sendKeys("123");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();		
		//driver.findElement(By.className("signInBtn")).click();
		//driver.findElement(By.cssSelector("button.signInBtn")).click();
		driver.findElement(By.cssSelector(".signInBtn")).click();
		//Thread.sleep(1000);
		String errorMsg= driver.findElement(By.cssSelector("p[class='error']")).getText();
		System.out.println(errorMsg);			
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder = 'Name']")).sendKeys("Saif");	
		//cssSelector by index (Child)
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("saifali7522@gmail.com");		
		//Xpath by index
		driver.findElement(By.xpath("//input[@type= 'text'][3]")).sendKeys("03333606114");		
		driver.findElement(By.xpath("//form/div/button[2]")).click();
		String password = driver.findElement(By.cssSelector("form p")).getText();
		System.out.println(password);	
		
	}
	

}
