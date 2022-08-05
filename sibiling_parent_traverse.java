import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sibiling_parent_traverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Sibling - Parent Traversing
	 //	https://rahulshettyacademy.com/AutomationPractice/
		System.setProperty("webdriver.chrome.driver" , "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// Sibling Travering:

		driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[2]")); //Sign up Button Clicked
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[2]")).getText());	
		
		driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")); //Login Button Clicked
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
	
		System.out.println(driver.findElement(By.xpath("//header/div/a/button")).getText());
		driver.findElement(By.xpath("//header/div/a/button")).click();  //Home Button Clicked

		//Parent Traversing
		  //header/div/button[2]/parent::div
		//Parent_tag/child_tag/child_tag/parent::parent_tag

		//  Parent-Child-Parent-Child
		//header/div/button[2]/parent::div/button[2]/following-sibling::button
		//Parent_tag/child_tag/child_tag/parent::parent_tag/child_tag/following-sibling::sibling_tag

		//  Parent-Child-Parent-Grand Parent
		//header/div/button[2]/parent::div/parent::header
		//Parent_tag/child_tag/child_tag/parent::parent_tag/parent::grandParent_tag
		driver.manage().window().minimize();
		
	
	}
	

}
