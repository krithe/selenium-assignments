package week5.Hw1;

import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLeadReadData extends BaseLeadReadData{
	
	@Test
	
	public void duplicatelead() throws InterruptedException {

		
        
        //click find leads
        driver.findElement(By.linkText("Find Leads")).click();
        
        //Click on Email
        driver.findElement(By.xpath("//span[text()='Email']")).click();
        
        //Enter Email
        driver.findElement(By.name("emailAddress")).sendKeys("abc@gmail.com");
        
        //Click find leads button
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        Thread.sleep(4000);
        
        //Capture name of First Resulting lead
        String LeadName = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).getText();
           
        
        //Click First Resulting lead
        driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a")).click();
        Thread.sleep(4000);
        
        //Click Duplicate Lead
        driver.findElement(By.linkText("Duplicate Lead")).click();
        Thread.sleep(4000);
        
        //Verify the title as 'Duplicate Lead'
        String title = driver.getTitle();
        if(title.contains("Duplicate Lead"))
        	System.out.println("The title is Duplicate Lead");
        else
        	System.out.println("The title is not Duplicate Lead");
                
        //Click Create Lead
        driver.findElement(By.linkText("Create Lead")).click();
        
        //Confirm the duplicated lead name is same as captured name
        String DupLeadName = driver.findElement(By.id("createLeadForm_firstName")).getText();
        if(LeadName.contentEquals(DupLeadName))
        	System.out.println("Lead Duplicated");
        else
        	System.out.println("Lead not Duplicated");
        
       

	}

}

