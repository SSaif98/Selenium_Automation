import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class end_to_end_AP {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.cssSelector("input[value = 'radio2']")).click();

		driver.findElement(By.id("dropdown-class-example")).click();
		WebElement options = driver.findElement(By.id("dropdown-class-example"));
		Select staticDD = new Select(options);
		staticDD.selectByIndex(2);
		driver.findElement(By.id("dropdown-class-example")).click();
		staticDD.selectByValue("option1");
		driver.findElement(By.id("dropdown-class-example")).click();
		staticDD.selectByVisibleText("Option3");

		driver.findElement(By.cssSelector("#checkBoxOption2")).click();

		driver.findElement(By.id("autocomplete")).sendKeys("pa");

		List<WebElement> countryList = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
		for (WebElement country : countryList) {
			if (country.getText().equalsIgnoreCase("Pakistan")) {
				country.click();
			}
		} 

		driver.findElement(By.id("alertbtn")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().dismiss();
		driver.findElement(By.id("name")).sendKeys("Saif");
		driver.findElement(By.id("alertbtn")).click();
		Assert.assertEquals(driver.switchTo().alert().getText(),
				"Hello Saif, share this practice page and share your knowledge");
		driver.switchTo().alert().accept();

 		driver.findElement(By.id("name")).sendKeys("Saif");
		driver.findElement(By.id("confirmbtn")).click();
		Assert.assertEquals(driver.switchTo().alert().getText(), "Hello Saif, Are you sure you want to confirm?");
		driver.switchTo().alert().accept();

		// Assert.assertTrue(driver.findElement(By.id("displayed-text")).getAttribute("style").contains("block"));
		driver.findElement(By.id("hide-textbox")).click();
		Assert.assertTrue(driver.findElement(By.id("displayed-text")).getAttribute("style").contains("none"));

	}

}
