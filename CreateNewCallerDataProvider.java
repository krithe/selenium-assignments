package week5.Hw1;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewCallerDataProvider extends BaseTest1DataProvider {
	
	@DataProvider(name = "Testdata")
	
	public String[][] fetchData(){
		String[][] data = new String[3][3];
		
		data[0][0] = "Adithi";
		data[0][1] = "Bala";
		data[0][2] = "abc@gmail.com";
		
		data[1][0] = "Nitin";
		data[1][1] = "Sai";
		data[1][2] = "abc@hotmail.com";
		
		data[2][0] = "Rithvik";
		data[2][1] = "Sai";
		data[2][2] = "abcd@gmail.com";
		
		return data;
	}
	
	@Test(dataProvider = "Testdata")
	public void createnewcaller(String first_name,String last_name, String email)throws InterruptedException {
		
		
	       //Enter first name
	       driver.findElement(By.id("sys_user.first_name")).sendKeys(first_name);
	       
	       //Enter Last Name
	       driver.findElement(By.id("sys_user.last_name")).sendKeys(last_name);
	       
	       //Email ID
	       driver.findElement(By.id("sys_user.email")).sendKeys(email);
	       
	       //Phone
	       driver.findElement(By.id("sys_user.phone")).sendKeys("9123546854");
	       
	       //Mobile phone
	       driver.findElement(By.id("sys_user.mobile_phone")).sendKeys("9225468596");
	       
	       	       
	       //Submit
	       driver.findElement(By.id("sysverb_insert_bottom")).click();
	       
	       //Verify
	       
	       //select first name from dropdown
	       WebElement FirstName = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
	       new Select(FirstName).selectByValue("first_name"); 
	       
	       //search with first name
	       driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Adithi",Keys.ENTER);
	       
	       //verification
	       //String verificationName = driver.findElement(By.xpath("(//table[@id='sys_user_table']/tbody//td[@class='vt'])[2]")).getText();
			//System.out.println(verificationName);
			//if (verificationName.equalsIgnoreCase("Adithi")) {
			//	System.out.println("The caller is created successfully");
			//}else {
				//System.out.println("The caller is not created successfully");
	       
	       WebElement newEntry = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[3]"));
		   String lastName = newEntry.getText();
		   System.out.println("Last name : " +lastName);
		   if(newEntry.isDisplayed())
		   System.out.println("Verified");
		   else
		   {
			   System.out.println("Not verified");
		   }
			}
	       
	}


