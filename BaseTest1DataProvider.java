package week5.Hw1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest1DataProvider {

	ChromeDriver driver;
	 @BeforeMethod
	 
		public void setup() throws InterruptedException {
			
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://dev103117.service-now.com/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.switchTo().frame(0);
		 driver.findElement(By.id("user_name")).sendKeys("admin");
		 driver.findElement(By.id("user_password")).sendKeys("India@123");
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 driver.findElement(By.id("filter")).sendKeys("Callers",Keys.ENTER);
		 driver.findElement(By.xpath("//div[text()='Callers']")).click();
		 driver.switchTo().frame(0);
		 Thread.sleep(3000);
		 driver.findElement(By.id("sysverb_new")).click();	WebDriverManager.chromedriver().setup();
		    
	       	}
	   
		 @AfterMethod
		 public void tearDown() {
			 driver.close();
		 }
		 }
	
	


