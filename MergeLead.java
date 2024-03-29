package week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead extends BaseTest{
	@Test

			public void mergelead() throws InterruptedException {
					
		
		driver.findElementByLinkText("Merge Leads").click();
		String oldWindow = driver.getWindowHandle();
		driver.findElementByXPath("//span[text()='From Lead']/following::img").click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> currentWindow=new ArrayList<String>(windowHandles);
		String newWindow = currentWindow.get(1);
		driver.switchTo().window(newWindow);
		driver.findElementByXPath("//input[@name='firstName']").sendKeys("Krithi");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
		driver.switchTo().window(oldWindow);
		driver.findElementByXPath("//span[text()='To Lead']/following::img").click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> currentWindow2=new ArrayList<String>(windowHandles2);
		String newWindow2 = currentWindow2.get(1);
		driver.switchTo().window(newWindow2);
		driver.findElementByXPath("//input[@name='firstName']").sendKeys("John");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(4000);
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
		driver.switchTo().window(oldWindow);
		
		driver.findElementByXPath("(//table[@class='twoColumnForm']//a)[3]").click();
		//driver.findElementByClassName("buttonDangerous").click();
		//driver.findElementByLinkText("Merge").click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String title = driver.getTitle();
		System.out.println(title);

	}

}