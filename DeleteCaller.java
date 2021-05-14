package assignmentsWeek4_Caller;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteCaller {

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
	       driver.findElement(By.id("user_name")).sendKeys("admin");
	       driver.findElement(By.id("user_password")).sendKeys("India@123");
	       driver.findElement(By.xpath("//button[@type='submit']")).click();
	       
	    // Enter Callers in filter navigator and press enter 
	       
	       driver.findElement(By.id("filter")).sendKeys("Callers",Keys.ENTER);
	       driver.findElement(By.xpath("//div[text()='Callers']")).click();
	       
	       driver.switchTo().frame(0);
	       Thread.sleep(3000);
	       
	       //search the existingcaller
            
	        WebElement forTextLastNameFirst = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
	        new Select(forTextLastNameFirst).selectByIndex(1); 
     
	        driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Bala",Keys.ENTER);
      
          //delete the caller
	        driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	        driver.findElement(By.id("sysverb_delete_bottom")).click();
	        
	      //Verify the deleted caller  
	        boolean verification = driver.findElement(By.xpath("//td[text()='No records to display']")).isDisplayed();
	    	
	    	
			if (verification) {
			System.out.println("The caller is deleted successfully");
			}else {
				System.out.println("The caller is not deleted successfully");
    

	}

}}
