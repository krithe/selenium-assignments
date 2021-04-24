package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
        driver.get("http://leaftaps.com/opentaps");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();
        String text = driver.findElement(By.tagName("h2")).getText();
       		System.out.println(text);
        driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElementByLinkText("Create Lead").click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Krithika");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Mani");
		WebElement dropDown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dd = new Select(dropDown);
		dd.selectByVisibleText("Partner");
		WebElement dropDown1 = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select dd1 = new Select(dropDown1);
		dd1.selectByVisibleText("Automobile");
		//driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("7358572399");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Krithika");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("Mani");
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Mrs");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("05/25/83");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Trainee");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Quality");
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("5L");
		WebElement dropDown2 = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select dd2 = new Select(dropDown2);
		dd2.selectByVisibleText("Computer Software");
		WebElement dropDown3 = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select dd3 = new Select(dropDown3);
		dd3.selectByVisibleText("Corporation");
		WebElement dropDown4 = driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select dd4 = new Select(dropDown4);
		dd4.selectByVisibleText("INR - Indian Rupee");
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("1000");
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("AKMNH0");
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("NYSE");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Register created");
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("Name to be changed");
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("91");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("2526242526");
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("001");
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("vijay");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("121");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("www.testleaf.com");
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Krithika");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Adithi");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("The Crossings");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Fremont");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Santa Clara");
		WebElement dropDown5 = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dd5 = new Select(dropDown5);
		dd5.selectByVisibleText("California");
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("95035");
		WebElement dropDown6 = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select dd6 = new Select(dropDown6);
		dd6.selectByVisibleText("United States");
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("3256");
		driver.findElementByName("submitButton").click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Cognizant");
		driver.findElementByName("submitButton").click();
		String text2 = driver.findElement(By.id("viewLead_companyName_sp")).getText();	// cognizant(12220)
		System.out.println(text2);
	
	if (text2.contains("Cognizant")) {
		System.out.println("Duplicate lead is created successfully");
	}else {
		System.out.println("Duplicate lead is not created successfully");
	}
	
	
	
	
	
	}

}	




		
		
		
		
		
		
		
		
		
		
		
		



