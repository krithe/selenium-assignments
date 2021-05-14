package assignmentsWeek4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateExistingIncident {

	private static final boolean Moderate = false;

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
	       driver.findElement(By.xpath("//div[text()='Open']")).click();
	       
	//Search for the existing incident and click on the incident
	       
	       //driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("INC0010543",Keys.ENTER);
	       driver.switchTo().frame(0);
	       Thread.sleep(3000);
	       
	      String incidentnum = driver.findElement(By.xpath("//input[@class='form-control']")).getText();
	       System.out.println(incidentnum);
	       driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	       
	// Update the incidents with Urgency as High and State as In Progress  
	       WebElement incidentstate = driver.findElement(By.id("incident.state")); 
	       new Select(incidentstate).selectByValue("2"); 
	       
	      	       
	       WebElement incidenturgency = driver.findElement(By.id("incident.urgency")); 
	       new Select(incidenturgency).selectByValue("1"); 
	       
	     driver.findElement(By.id("sysverb_update_bottom")).click();
	      
	// Verify the priority and state 
	     Thread.sleep(2000);
		
			driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentnum, Keys.ENTER);

			boolean moderate = driver.findElement(By.xpath("//td[contains(text(),'Moderate')]")).isDisplayed();
			boolean progress = driver.findElement(By.xpath("//td[contains(text(),'Progress')]")).isDisplayed();

			// verification
			if (moderate && progress) {
				System.out.println("The incident is updated successfully");
			} else {
				System.out.println("The incident is not updated successfully");
			}
			driver.close();

	    	}

}
