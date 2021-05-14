package assignmentsWeek4.Prorosal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewProposal {

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
	       
	//Enter proposal in filter navigator 
	       driver.findElement(By.id("filter")).sendKeys("Proposal",Keys.ENTER);
	       driver.findElement(By.xpath("//div[text()='My Proposals']")).click();
	       
	//Switch to frame
	       driver.switchTo().frame(0); 
	       
	       
	//Click new to create new proposal
	   	      
	   	       driver.findElement(By.id("sysverb_new")).click();
	       
	// Open new Proposal by filling mandatory fields and click 'Submit'Button 
	   	       
	   	    String proposalnumber = driver.findElement(By.id("std_change_proposal.number")).getAttribute("value");
	   	    System.out.println("Number: " + proposalnumber);
			System.out.println(" ");      
			
	//fill in mandatory fields
			driver.findElement(By.id("std_change_proposal.short_description")).sendKeys("New Proposal submitted");
			
	//click change request
			driver.findElement(By.xpath("//span[text()='Change Request values']")).click();	
			
	//select short description
			driver.findElement(By.xpath("//td[@data-value='Short description']//input[1]"));
			//driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("Short description");	
			driver.findElement(By.xpath("//input[@class='filerTableInput form-control']")).clear();
			driver.findElement(By.xpath("//input[@class='filerTableInput form-control']")).sendKeys("Test Proposal Created");
			
			//click submit
			driver.findElement(By.id("sysverb_insert_bottom")).click();
			
		//Verify the successful creation of new Proposal
			
			//WebElement filteroption = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
			//new Select(filteroption).selectByVisibleText("Template description"); 
			
			//String text = driver.findElement(By.xpath("//input[@class='form-control']")).getAttribute("value");
			//driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("New Proposal Submitted");
			
			driver.findElement(By.xpath("//input[@class = 'form-control']")).sendKeys(proposalnumber,Keys.ENTER);
			String createdProposal = driver.findElement(By.xpath("//a[@class = 'linked formlink']")).getText();
			
			if(proposalnumber.equals(createdProposal)) {
				System.out.println("New proposal is created");
			}else {
				System.out.println("New proposal is not created");
			}
			driver.close();
			
			
	}}	
