package assignmentsWeek4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteIncident {

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
	       
	     //switch frame
	       driver.switchTo().frame(0);
	       Thread.sleep(3000);
	     
	    // search for existing incident
			WebElement textSelect = driver.findElement(By.className("form-control"));
			Select dropdown = new Select(textSelect);
			dropdown.selectByValue("zztextsearchyy");
			
			driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Krithi", Keys.ENTER);
			driver.findElement(By.xpath("//a[@class='linked formlink']")).click();

			// Get incident number
			String incidentNo = driver.findElement(By.xpath("//input[@class='form-control']")).getAttribute("value");
			System.out.println(incidentNo);

			// Clicking on delete button
			driver.findElement(By.xpath("//button[text()='Delete']")).click();
			driver.findElement(By.id("ok_button")).click();
		
			

			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentNo, Keys.ENTER);

			boolean delete = driver.findElement(By.xpath("//tr[@class='list2_no_records']//td[1]")).isDisplayed();
			
			// verification
			if (delete) {
				System.out.println("The incident is deleted successfully");
			} else {
				System.out.println("The incident is not deleted successfully");
			}
			driver.close();

		}

	}


