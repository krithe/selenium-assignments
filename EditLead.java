package Assisnments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
        driver.get("http://leaftaps.com/opentaps");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        
       driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();
        String text = driver.findElement(By.tagName("h2")).getText();
       		System.out.println(text);
        driver.findElement(By.linkText("CRM/SFA")).click();
        
        //click leads link
        driver.findElement(By.linkText("Leads")).click();
        
        //click find leads
        driver.findElement(By.linkText("Find Leads")).click();
        
        //enter first name
        driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Krithika");
        
        //click find leads button
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        
           //click find leads button
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        
        Thread.sleep(3000);
        
        // click first resulting lead
        driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
      
        
        //verify title
              
        System.out.println("The title is :" +driver.getTitle());
        
        if(driver.getTitle().contains("View Lead")) {
        	System.out.println("I confirm the title has View Lead");
            	}else {
            		System.out.println("The title does not have View Lead");
            		
    	}
    	

		// click edit tab
		driver.findElement(By.linkText("Edit")).click(); 
		
		// enter new company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Microsoft");
		
		//Click update
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
		//confirm changed name appears
		String text2 = driver.findElement(By.id("updateLeadForm_companyName")).getText();	// Microsoft
		System.out.println(text2 );
		
		//close the browser
		driver.close();
		
	}}


