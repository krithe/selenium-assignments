package assignmentsWeek4;

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

public class CreateNewIncident {

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
	       
	       
	       //Click on Create new option and fill the manadatory fields
	       
	       driver.findElement(By.xpath("//div[text()='Create New']")).click();
	     
	       driver.switchTo().frame(0);
	       String incidentNo  = driver.findElement(By.xpath("//input[@class='form-control']")).getAttribute("value");
			System.out.println(incidentNo);

		//fill in caller field
	              
	       // Click on the Search icon 
	       driver.findElement(By.id("lookup.incident.caller_id")).click();
	       
	       //get all the windows and save in the set 
	       Set<String> allWindowHandles = driver.getWindowHandles();
	       
	       //convert set in to list 
	       List<String> lstWindows = new ArrayList<String>(allWindowHandles);
	      
	       
	       //switch  to the new window
	       String secondWindowHandles = lstWindows.get(1);
	       driver.switchTo().window(secondWindowHandles);
	     
	      
	       // Click on the first caller value
	       
	       driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[2]")).click();
	       
	       //once we handled the window we need to get back to the primary window and switch back to the frame.
	       driver.switchTo().window(lstWindows.get(0));
	       driver.switchTo().frame(0);
	     	          
			
		//short description
			driver.findElement(By.id("incident.short_description")).sendKeys("krithi's new incident");
			Thread.sleep(2000);
			
			//click submit 
			driver.findElement(By.id("sysverb_insert_bottom")).click();
								
				
			//copy incident number in search box
			
			driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNo,Keys.ENTER);
			
			
			boolean displayed = driver.findElement(By.xpath("//a[@class='linked formlink']")).isDisplayed();

			// verification
			if (displayed) {
				System.out.println("The incident is created successfully");
			} else {
				System.out.println("The incident is not created successfully");
			}
			driver.close();

			}
			
			
	}


