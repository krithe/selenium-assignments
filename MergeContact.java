package Assisnments;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {


		 // Launch URL 
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();

			driver.get("http://leaftaps.com/opentaps/control/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  
			  // Enter UserName and Password Using Id Locator
			driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");

			  
			  //Click on Login Button using Class Locator
			driver.findElement(By.className("decorativeSubmit")).click();

			  
			  //Click on CRM/SFA Link
			driver.findElement(By.linkText("CRM/SFA")).click();

			  
			  // Click on contacts Button
			driver.findElement(By.linkText("Contacts")).click();
		  	
			  // Click on Merge Contacts using Xpath Locator
			
			driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
			  
			  // Click on Widget of From Contact
			
			driver.findElement(By.xpath("(//a//img[@alt='Lookup'])[1]")).click();
			
			  // Click on First Resulting Contact
			
			//To get the window handles 
			
			Set<String> allWindowHandles=driver.getWindowHandles();
			System.out.println(allWindowHandles.size());
			
	  //To get the second window handle and switch to it
			
			List<String> lstWindows=new ArrayList<String>(allWindowHandles);
			System.out.println(lstWindows.size());
			
			String firstwindow=lstWindows.get(1);
			driver.switchTo().window(firstwindow);
			Thread.sleep(1000);
			System.out.println(driver.getCurrentUrl());
			
			driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		
					
			//Switching to parent window 
			String Parentwindow=lstWindows.get(0);

			driver.switchTo().window(Parentwindow);

			  // Click on Widget of To Contact
			Thread.sleep(2000);

			driver.findElement(By.xpath("(//a//img[@alt='Lookup'])[2]")).click();

		  //Click on Second Resulting Contact
			Thread.sleep(1000);

			allWindowHandles=driver.getWindowHandles();
			System.out.println(allWindowHandles.size());
			lstWindows=new ArrayList<String>(allWindowHandles);
			System.out.println(lstWindows.size());
			String secondcontactselect=lstWindows.get(1);
			Thread.sleep(1000);

			driver.switchTo().window(secondcontactselect);
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
			  
			 // Click on Merge button using Xpath Locator
			Parentwindow=lstWindows.get(0);

				driver.switchTo().window(Parentwindow);
		  driver.findElement(By.xpath("//a[text()='Merge']")).click();
		  
		  //Accept the Alert
		  
		  		Alert alert=driver.switchTo().alert();
		  			alert.accept();

		  
			  // Verify the title of the page
		 
		  			System.out.println(driver.getTitle());

		  			driver.close();
		}

	}