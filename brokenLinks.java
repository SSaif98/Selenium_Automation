import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class brokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,5000)");
		//li[class='gf-li'] a
		
		SoftAssert sa= new SoftAssert();
		
		//java methods will call url and get you the status code.

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		for(int i =0; i< links.size(); i++) {
			
			String url = links.get(i).getAttribute("href");
		
			HttpURLConnection	conn = (HttpURLConnection) new	URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int resCode = conn.getResponseCode();
			System.out.println(resCode);
			sa.assertTrue(resCode < 400, "The link with the text 'BrokenLink' : "+links.get(i).getText()+"  having response code: " + resCode);
	
		}

		sa.assertAll();

	}

}


//There is a class class called URL which exposes a method called openconnection
/*
 * 	WebElement footer = driver.findElement(By.id("gf-BIG"));
		WebElement footerColumn2 = footer.findElement(By.cssSelector("td:nth-child(2)"));
		System.out.println(footerColumn2.findElement(By.cssSelector("li:nth-child(2)")).getText());
		System.out.println(driver.findElement(By.cssSelector("#gf-BIG td:nth-child(2) li:nth-child(2)")).getText());
 */

/*
 * 		List<WebElement> totalurls = driver.findElements(By.cssSelector("#gf-BIG a"));
		String url;
		for(int i=0 ; i< totalurls.size();i++) {
			
			url = totalurls.get(i).getAttribute("href");
			HttpURLConnection	conn = (HttpURLConnection) new	URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			conn.getResponseCode();
			if(conn.getResponseCode() >= 400) {
			System.out.println(totalurls.get(i).getText())	;
			}
			else {
				System.out.println(totalurls.get(i).getText())	;
			}
		}
 */


/*
 * 		for(WebElement link : links) {
			String url = link.getAttribute("href");
			HttpURLConnection	conn = (HttpURLConnection) new	URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			conn.getResponseCode();
			if(conn.getResponseCode() > 400) {
			System.out.println(link.getText())	;
			}
		}
	
 * */
