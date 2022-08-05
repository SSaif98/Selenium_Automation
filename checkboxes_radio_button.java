import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class checkboxes_radio_button {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",  "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//System.out.println(driver.findElement(By.cssSelector("input[id = 'ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id = 'ctl00_mainContent_chk_friendsandfamily']")).isSelected());
			driver.findElement(By.cssSelector("input[id = 'ctl00_mainContent_chk_friendsandfamily']")).click();
		//	System.out.println(driver.findElement(By.cssSelector("input[id = 'ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id = 'ctl00_mainContent_chk_friendsandfamily']")).isSelected());	
			System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
			
	}

}
