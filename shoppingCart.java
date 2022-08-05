import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class shoppingCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter Vegetables: ");
		String[] itemNeeded = new String[3];
		int count = itemNeeded.length;
		int k = 0;
		for (int j = 0; j < 3; j++) {
			itemNeeded[j] = myObj.nextLine();
		}
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		List<WebElement> productNames = driver.findElements(By.className("product-name"));

		for (int i = 0; i < productNames.size(); i++) {

			String[] vegetableName = productNames.get(i).getText().split("-");
			String reqVeg = vegetableName[0].trim();

			List<String> litemList = Arrays.asList(itemNeeded);

			if (litemList.contains(reqVeg)) {
				driver.findElements(By.xpath("//div[@class = 'product-action']/button")).get(i).click();

				k++;
				if (k == count) {
					break;
				}
			}
		}

	}

}
