package assignmentsWeek4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ArticleMandatoryfields {

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
	       
	   // Enter Knowledge  in filter navigator and press enter
	       driver.findElement(By.id("filter")).sendKeys("Knowledge",Keys.ENTER);
	       driver.findElement(By.xpath("//div[text()='My Knowledge Articles']")).click();
	       
	       //switch to frame
	       driver.switchTo().frame(0);
	       
	       //Click new
	       driver.findElement(By.id("sysverb_new")).click();
	       
	       //get incident number
	       String number = driver.findElement(By.id("sys_readonly.kb_knowledge.number")).getAttribute("value");
	       System.out.println(number);
	   	    
	       
	  // select knowledge as IT
	       driver.findElement(By.id("sys_display.kb_knowledge.kb_knowledge_base")).sendKeys("IT",Keys.TAB);
	       Thread.sleep(1000);
	  //category as java
	       
	       //driver.findElement(By.id("sys_display.kb_knowledge.kb_category")).sendKeys("Java");
	       
	   //Update the other mandatory fields - short description
	       
	       driver.findElement(By.id("kb_knowledge.short_description")).sendKeys("Article Created and Updated");
	       
	    //Click submit
	       driver.findElement(By.id("sysverb_insert_bottom")).click();
	       
	       //verify
	       
	       WebElement forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
	       new Select(forTextNum).selectByValue("short_description"); 
	       
	       String description = driver.findElement(By.xpath("(//td[@class='vt'])[2]")).getText();
	       System.out.println(description);
	       
	       if (description.equalsIgnoreCase("Article Created and Updated")) {
				System.out.println("The Article is updated successfully");
			}else {
				System.out.println("The Article is not updated successfully");
			}
	       
	       
	      	}

}
