import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class login_automation_method {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Scanner obj = new Scanner(System.in);
		System.out.print("Enter User Name: ");
		String userName= obj.nextLine();
	
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		login_automation_method obj1 = new login_automation_method();
		String password=  obj1.getPassword(driver);
		Thread.sleep(2000);		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name = 'inputPassword']")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".submit")).click();
		Thread.sleep(1000);
		String verificationText= driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();
		Assert.assertEquals(verificationText, "Hello " + userName+",");
		System.out.println(verificationText);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()= 'Log Out']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("form h1")).getText(), "Sign in");
		System.out.println("You are now logged out"); 

	}

	public String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@class, 'reset')]")).click();
		String passString = driver.findElement(By.xpath("//form/p")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
		String[] splittedStringNew = passString.split("'");
		
		String password= splittedStringNew[1];
		return password;
	}
	
}
