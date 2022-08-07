
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		WebElement move =driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		Actions a = new Actions(driver);
		
		//Composite Action
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		//Move to specific element
		a.moveToElement(move).build().perform();
		a.moveToElement(move).contextClick().build().perform();
		
		//Handle Child Window also switching between Parent Window and child window
		
		
	}

}
