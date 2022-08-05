import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoSuggestive_dd {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("autosuggest")).sendKeys("pa");
		Thread.sleep(4000);
		List<WebElement> countryList = driver.findElements(By.cssSelector("li[class= 'ui-menu-item'] a"));

		for (WebElement country : countryList) {

			if (country.getText().equalsIgnoreCase("Pakistan")) {
				country.click();
				break;
			}
		}

	}

}
