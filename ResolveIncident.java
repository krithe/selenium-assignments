package assignmentsWeek4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResolveIncident {

	public static void main(String[] args) {

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
	       
	      //Search for the existing incident and navigate into the incident
//	       String incidentnum = driver.findElement(By.xpath("//input[@class='form-control']")).getText();
//	       System.out.println(incidentnum);
	       
	       driver.findElement(By.xpath("(//a[@class='linked formlink'])[3]")).click();
	       
	       //Update the state as Resolved and update the Resolution informations
	       
	       WebElement incidentstate = driver.findElement(By.id("incident.state")); 
	       new Select(incidentstate).selectByVisibleText("Resolved"); 
	       
	       //Resolution informations
	       
	                  //Resolution information tab
	       driver.findElement(By.xpath("(//span[@class='tab_caption_text'])[3]")).click();
	       
	                 //Resolution code
	       WebElement incidentclosecode = driver.findElement(By.id("incident.close_code")); 
	       new Select(incidentclosecode).selectByVisibleText("Solved (Work Around)"); 
	       
	                 // Resolution notes
	       driver.findElement(By.id("incident.close_notes")).sendKeys("Sample testing");
	           
	       // Resolve the incident and verify the State
	          
	          //click Resolve
	       driver.findElement(By.id("resolve_incident_bottom")).click();
	       
	         // verify the State
	       boolean isElementDisplayed = driver.findElement(By.xpath("//td[text() = 'Resolved']")). isDisplayed();
	       if(isElementDisplayed)
	    	   System.out.println("The State displays Resolved");
	       else
	    	   
	       System.out.println("The state is InProgress");
	       

	}

}
