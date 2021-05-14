package assignmentsWeek4_Caller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewCaller {

	public static void main(String[] args) throws InterruptedException {
		
		//precondition: chromedriver need to be downloaded and set to path
		
	       WebDriverManager.chromedriver().setup();
	       
     // launch chrome driver
	
	       ChromeDriver driver = new ChromeDriver();

    //url load

         driver.get("https://dev103117.service-now.com/");
	
     //maximize

	       driver.manage().window().maximize();
	    
     //implicit wait
	    
	       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    //login the app
	       
	       driver.switchTo().frame(0);
	      // driver.findElement(By.id("user_name")).clear();
	       driver.findElement(By.id("user_name")).sendKeys("admin");
	       
	      // driver.findElement(By.id("user_name")).clear();
	       driver.findElement(By.id("user_password")).sendKeys("India@123");
	       
	       driver.findElement(By.xpath("//button[@type='submit']")).click();
	       
	    // Enter Callers in filter navigator and press enter 
	       
	       driver.findElement(By.id("filter")).sendKeys("Callers",Keys.ENTER);
	       driver.findElement(By.xpath("//div[text()='Callers']")).click();
	       
	       driver.switchTo().frame(0);
	       Thread.sleep(3000);
	       
	    // Create new Caller by filling all the fields and click 'Submit'
	       driver.findElement(By.id("sysverb_new")).click();
	       
	       //Enter first name
	       driver.findElement(By.id("sys_user.first_name")).sendKeys("Adithi");
	       
	       //Enter Last Name
	       driver.findElement(By.id("sys_user.last_name")).sendKeys("Bala");
	       
	       //Email ID
	       driver.findElement(By.id("sys_user.email")).sendKeys("abc@gmail.com");
	       
	       //Phone
	       driver.findElement(By.id("sys_user.phone")).sendKeys("9123546854");
	       
	       //Mobile phone
	       driver.findElement(By.id("sys_user.mobile_phone")).sendKeys("9225468596");
	       
	       	       
	       //Submit
	       driver.findElement(By.id("sysverb_insert_bottom")).click();
	       
	       //Verify
	       
	       //select first name from dropdown
	       WebElement FirstName = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
	       new Select(FirstName).selectByValue("first_name"); 
	       
	       //search with first name
	       driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Adithi",Keys.ENTER);
	       
	       //verification
	       String verificationName = driver.findElement(By.xpath("(//table[@id='sys_user_table']/tbody//td[@class='vt'])[2]")).getText();
			System.out.println(verificationName);
			if (verificationName.equalsIgnoreCase("Adithi")) {
				System.out.println("The caller is created successfully");
			}else {
				System.out.println("The caller is not created successfully");
			}
	       
	}
}

