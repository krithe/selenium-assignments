package assignmentsWeek4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewIncident2 {

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
	    
	       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    //login the app
	       
	       driver.switchTo().frame(0);
	       driver.findElement(By.id("user_name")).sendKeys("admin");
	       driver.findElement(By.id("user_password")).sendKeys("India@123");
	       driver.findElement(By.xpath("//button[@type='submit']")).click();
	       
	       // Enter Incident in filter navigator and press enter   
	       
	       driver.findElement(By.id("filter")).sendKeys("Incident",Keys.ENTER);
	       
	     //click create new 
	       driver.findElement(By.xpath("//div[text()='Create New']")).click();
	    
	       
	       //switch frame
	       driver.switchTo().frame(0);
	       Thread.sleep(3000);
	       
	   	       
	      //Search for the existing incident and navigate into the incident
	       String incidentnum = driver.findElement(By.xpath("//input[@class='form-control']")).getAttribute("value");
	       System.out.println(incidentnum);
	       
	              	            
	       // click update
	       driver.findElement(By.id("sysverb_insert_bottom")).click();
	       
	        // Verify the error message displayed on the top
	       	       
	       boolean Errormsg = driver.findElement(By.className("outputmsg_text")).isDisplayed();
	
	    		   if(Errormsg) {
	   	        	System.out.println("The following mandatory fields are not filled in: Short description, Caller");
	    		   }else {
	   	        	System.out.println("Error message not displayed");
	}
	driver.close();
	
	}}
	
	


