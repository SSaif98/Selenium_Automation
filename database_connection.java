import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class database_connection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host = "localhost";
		String port = "3306";

		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo", "root", "root");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from credentials where scenario ='rewardscard'");
		
		while(rs.next())
		{
			System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://rahulshettyacademy.com/locatorspractice/");

			driver.findElement(By.id("inputUsername")).sendKeys(rs.getString("username"));
			driver.findElement(By.name("inputPassword")).sendKeys("password");
		}		

	}

}
