package week5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead extends BaseTest {
	@Test(enabled = false)
	public void deleteLead() throws InterruptedException {
	        
        
        
        //click find leads
        driver.findElement(By.linkText("Find Leads")).click();
        
        //Click on Phone
        driver.findElement(By.xpath("//span[text()='Phone']")).click();
        
        //Enter phone number
        driver.findElement(By.name("phoneAreaCode")).sendKeys("021");
        
        //Click find leads button
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        Thread.sleep(4000);
        
        //Capture lead ID of First Resulting lead
        String leadID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).getText();
        System.out.println(leadID);
        
        //Click First Resulting lead
        driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
        Thread.sleep(4000);
        
        //Click Delete
        driver.findElement(By.linkText("Delete")).click();
        
        //Click Find leads
        driver.findElement(By.linkText("Find Leads")).click();
        
        //Enter captured lead ID
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
        
        //Click find leads button
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        
        //Verify message "No records to display" in the Lead List. This message confirms the successful deletion
        
        boolean isElementDisplayed = driver.findElement(By.xpath("//div[text() = 'No records to display']")). isDisplayed();
        if(isElementDisplayed)
        	System.out.println("Lead is deleted");
        else
        	System.out.println("Lead is not deleted");
      
	}

}
