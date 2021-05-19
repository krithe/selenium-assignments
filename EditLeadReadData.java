package week5.Hw1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class EditLeadReadData extends BaseLeadReadData {
	@DataProvider(name="EditLeadReadData")

	public Object[][] fetchData() throws InvalidFormatException, IOException 
	{
		
		String [][] data = ReadExcelData.readExcel("Edit lead");
		
		return data;

	}
@Test(dataProvider="EditLeadReadData")
	
	public void editLead(String PhoneNumber,String CompanyName) throws InterruptedException
 {
		        
	driver.findElementByLinkText("Find Leads").click();
	driver.findElementByXPath("//span[text()='Phone']").click();
	driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(PhoneNumber);
	driver.findElementByXPath("//button[text()='Find Leads']").click();
	Thread.sleep(2000);
	driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
	driver.findElementByLinkText("Edit").click();
	driver.findElementById("updateLeadForm_companyName").sendKeys(CompanyName);
	driver.findElementByName("submitButton").click();

}
}