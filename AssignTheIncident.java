package assignmentsWeek4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignTheIncident {

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
	       
	      //click on open
	       driver.findElement(By.xpath("//div[text()='Open']")).click();
	       
	       //switch frame
	       driver.switchTo().frame(0);
	       Thread.sleep(2000);
	       
	      //Search for the existing incident and navigate into the incident
	       String incidentnum = driver.findElement(By.xpath("//input[@class='form-control']")).getText();
	       System.out.println(incidentnum);
	       
	       driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	       
	       // Assign the incident to  Software group
	       
	       driver.findElement(By.id("sys_display.incident.assignment_group")).clear();
			Thread.sleep(2000);
			driver.findElement(By.id("sys_display.incident.assignment_group")).sendKeys("Software",Keys.ENTER);
			Thread.sleep(2000);

			// selecting state as Inprogress
			driver.findElement(By.xpath("(//textarea[contains(@class,'sn-string-textarea form-control')])[3]")).sendKeys("Testing");
			Thread.sleep(2000);

			// update
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()='Update']")).click();
			driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentnum, Keys.ENTER);

			boolean group = driver.findElement(By.linkText("Software")).isDisplayed();
			
			// verification
			if (group) {
				System.out.println("The incident is updated successfully");
			} else {
				System.out.println("The incident is not updated successfully");
			}
			driver.close();
           
         
	        	}
	       
	}


