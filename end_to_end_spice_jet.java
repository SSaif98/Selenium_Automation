import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class end_to_end_spice_jet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		
		WebElement currencyOptions = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select currency = new Select(currencyOptions);
		currency.selectByIndex(2);
		System.out.println(currency.getFirstSelectedOption().getText());
		currency.selectByIndex(3);
		System.out.println(currency.getFirstSelectedOption().getText());
		currency.selectByIndex(1);
		System.out.println(currency.getFirstSelectedOption().getText());

		driver.findElement(By.xpath("//div[@id = 'divpaxinfo']")).click();
		
		Thread.sleep(3000);
		for(int i=0 ; i<5; i++) {
			driver.findElement(By.cssSelector("#hrefIncAdt")).click();
		}
		int j=0;
		while(j<2) {
			driver.findElement(By.id("hrefIncChd")).click();
			j++;
		}
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "6 Adult, 2 Child");
		
		driver.findElement(By.cssSelector("input[value = 'Done']")).click();
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		
		
		driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value = 'JAI']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value = 'PAT']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		
		driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isSelected());
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		driver.findElement(By.xpath("(//a[text()= '30'])[1]")).click();
		
		driver.findElement(By.id("autosuggest")).sendKeys("pa");
		Thread.sleep(4000);
		List<WebElement> countryList	= driver.findElements(By.cssSelector("li[class = 'ui-menu-item'] a"));
		
		for(WebElement country : countryList) {
				if(country.getText().equalsIgnoreCase("Pakistan")) {
					country.click();
					break;
				}
		}
		
//driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"); if any thing is disabled and on UI it is clickable then we can use this.
	
	}

}
