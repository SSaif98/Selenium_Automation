import java.sql.Driver;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class login_automation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Scanner obj = new Scanner(System.in);
		System.out.print("Enter User Name: ");
		String userName= obj.nextLine();
		System.out.print("Enter Password: ");
		String password = obj.nextLine();

		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//Normal Tags:
		Assert.assertEquals(driver.findElement(By.cssSelector("form h1")).getText(),"Sign in");
		driver.findElement(By.id("inputUsername")).sendKeys(userName);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.className("signInBtn")).click();
		Assert.assertEquals(driver.findElement(By.className("error")).getText(), "* Incorrect username or password");
		System.out.println(driver.findElement(By.className("error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.cssSelector("form h2")).getText(), "Forgot password");
		
		//CSS Selectors:
		/*
		driver.findElement(By.cssSelector("input[placeholder = 'Name']")).sendKeys(userName);
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("saifali7522@gmail.com");//traversing from parent to child
		driver.findElement(By.cssSelector("input[placeholder*='Phone']")).sendKeys("+92 3333606114");
		driver.findElement(By.cssSelector("button[class*= 'reset']")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector(".infoMsg")).getText(), "Please use temporary password 'rahulshettyacademy' to Login.");
		driver.findElement(By.cssSelector(".go-to-login-btn")).click(); 
		*/
		//Xpath Selectors:
		driver.findElement(By.xpath("//input[@placeholder = 'Name']")).sendKeys("saif");
		driver.findElement(By.xpath("//input[@type ='text'][2]")).sendKeys("saifali7522@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("+92 3333606114");
		driver.findElement(By.xpath("//button[contains(@class, 'reset')]")).click();
		
		String passString = driver.findElement(By.xpath("//form/p")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
		String[] splittedStringNew = passString.split("'");
		
		Assert.assertEquals(passString, "Please use temporary password 'rahulshettyacademy' to Login.");		
		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
		
			//MIX LOCATORS
//		driver.findElement(By.xpath("//div[@class = 'overlay-panel overlay-right']/p")).getText();
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name = 'inputPassword']")).sendKeys(splittedStringNew[1]);
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
	

	

}
