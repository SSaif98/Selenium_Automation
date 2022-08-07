import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class link_click_task_ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//System.out.println(driver.findElements(By.xpath("//a")).size());
		//1. Get all the links on the page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
	//	System.out.println(driver.findElements(By.xpath("//li[@class='gf-li']/a")).size());
		//2. Get all the links on the page that is in footer
		WebElement	footer= driver.findElement(By.id("gf-BIG"));    //limiting webdriver scope.
		System.out.println(	footer.findElements(By.tagName("a")).size());
		
	/*	WebElement	footerColumn1= driver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul"));		
		System.out.println(	footerColumn1.findElements(By.tagName("a")).size());  */
		//3. Get all the links on the page that is in footer's 1st column

		WebElement	footerColumn1New =	footer.findElement(By.xpath("//tbody/tr/td[1]/ul"));		
		System.out.println(footerColumn1New.findElements(By.tagName("a")).size());
	
			Actions a = new Actions(driver);
			
		for(int i=1; i< footerColumn1New.findElements(By.tagName("a")).size() ;i++) {
					
			a.moveToElement(footerColumn1New.findElements(By.tagName("a")).get(i)).keyDown(Keys.CONTROL).click().build().perform();
		
			/*String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);		
			coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			*/

		}

		Set<String>	windows =	driver.getWindowHandles();
		Iterator<String>	it=	windows.iterator();
	
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			}
		
/*	Set<String>	windows =	driver.getWindowHandles();
	Iterator<String>	it=	windows.iterator();

	String parentId =	it.next();
	String	child1 =	it.next();
	String	child2 =	it.next();
	String	child3 =	it.next();
	String	child4 =	it.next();
	*/
		/*
	driver.switchTo().window(child1);
	System.out.println("Child#1 " + driver.getTitle());
	
	driver.switchTo().window(child2);	
	System.out.println("Child#2 " + driver.getTitle());

	driver.switchTo().window(child3);	
	System.out.println("Child#3 " + driver.getTitle());

	driver.switchTo().window(child4);	
	System.out.println("Child#4 " + driver.getTitle());

	*/
	}

}
