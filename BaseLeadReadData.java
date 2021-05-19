package week5.Hw1;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLeadReadData {
 ChromeDriver driver;
 
 @Parameters({"url","username","password"})
 @BeforeMethod
 public void userLogin(String url,String username,String password) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("decorativeSubmit")).click();
        String text = driver.findElement(By.tagName("h2")).getText();
       		System.out.println(text);
        driver.findElement(By.linkText("CRM/SFA")).click();	

    	driver.findElement(By.xpath("//a[text()='Leads']")).click();
       	}
   
	 @AfterMethod
	 public void tearDown() {
		 driver.close();
	 }
	 }
