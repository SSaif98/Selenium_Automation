
import java.time.Duration;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class handling_https_certification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
	//	options.addExtensions("Download Extension then paste path here");
	/*setting proxy
	 * 		Proxy proxy = new Proxy();
	 * options.setCapability("proxy", "value");
	 */

		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.expired.badssl.com");
		System.out.println(driver.getTitle());	

	}

}
