import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class greenKart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Scanner obj= new Scanner(System.in);
		System.out.println("Enter Vegetable Names: ");
		String[] itemNeeded = new String[4];
		int count= itemNeeded.length;
		for(int i=0; i<itemNeeded.length;i++) {
			itemNeeded[i] =  obj.nextLine();
		}
		
		int k=0;
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		greenKartProcess(driver, count, itemNeeded, k);
		
		driver.findElement(By.xpath("//a[@class ='cart-icon']/img")).click();
		driver.findElement(By.cssSelector("div[class='cart-preview active'] button[type = 'button']")).click();
		driver.findElement(By.xpath("//input[@placeholder = 'Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class = 'promoBtn']")).click();
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		
		
		Assert.assertEquals(driver.findElement(By.className("promoInfo")).getText(), "Code applied ..!");
		Assert.assertEquals(driver.findElement(By.className("discountPerc")).getText(), "10%");
		driver.findElement(By.xpath("//button[text() = 'Place Order']")).click();
		driver.findElement(By.xpath("//button[text() = 'Proceed']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='errorAlert']/b")).getText(), "Please accept Terms & Conditions - Required");
		
		driver.findElement(By.xpath("//div/select")).click();
		WebElement countryList = driver.findElement(By.xpath("//div/select"));
		Select options = new Select(countryList);
		options.selectByValue("Pakistan");
		driver.findElement(By.className("chkAgree")).click();
		
		driver.findElement(By.xpath("//button[text() = 'Proceed']")).click();
		}

	public static void greenKartProcess(WebDriver driver,int count, String[] itemNeeded, int k) {
		

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		List<WebElement> productNames = 	driver.findElements(By.className("product-name"));
		
		for(int j= 0 ; j< productNames.size();j++) {
			
		String[] productName =	productNames.get(j).getText().split("-");
		String splittedString = productName[0].trim();
		
		List<String> listItems = Arrays.asList(itemNeeded);
		
		if(listItems.contains(splittedString)) {
			driver.findElements(By.xpath("//div[@class = 'product-action']/button")).get(j).click();
			k++;
			if (k ==count) {
				break;
			}
			
		}
				}
	
	}
	
}