package Assisnments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("http://leaftaps.com/opentaps/control/login");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();
        String text = driver.findElement(By.tagName("h2")).getText();
       		System.out.println(text);
        driver.findElement(By.linkText("CRM/SFA")).click();
        
        //click contacts tab
        driver.findElement(By.linkText("Contacts")).click();
        
        //click create contact
        driver.findElement(By.linkText("Create Contact")).click();
        
        //Enter first name field using id locator
        driver.findElement(By.id("firstNameField")).sendKeys("Krithika");
        
        // Enter LastName Field Using id Locator
        driver.findElement(By.id("lastNameField")).sendKeys("Mani");
        
        //Enter FirstName(Local) Field Using id Locator
        driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Adithi");
        
        //Enter LastName(Local) Field Using id Locator
        driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Bala");
        
        //Enter Department Field Using any Locator of Your Choice
        driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Quality");
        
        //Enter Description Field Using any Locator of your choice 
        driver.findElement(By.id("createContactForm_description")).sendKeys("Created");
        
        //Enter your email in the E-mail address Field using the locator of your choice
        driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("xyz@gmail.com");
        
        //Select State/Province as NewYork Using Visible Text
        WebElement generalSta = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId")); 
        new Select(generalSta).selectByVisibleText("New York");  
            
        //Click on Create Contact
        driver.findElement(By.name("submitButton")).click();
        
        //Click on edit button
        driver.findElement(By.linkText("Edit")).click();
        
        //Clear the Description Field using .clear
        driver.findElement(By.name("description")).clear();
        
        
        //Fill ImportantNote Field with Any text
        driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Description cleared");;        
        
        //Click on update button using Xpath locator
        driver.findElement(By.xpath("//input[@name='submitButton']")).click();
        
        //Get the Title of Resulting Page
        driver.findElement(By.id("sectionHeaderTitle_contacts")).click();
        String text2 = driver.findElement(By.id("sectionHeaderTitle_contacts")).getText();	// view contact as title
		System.out.println(text2);

	}
}
