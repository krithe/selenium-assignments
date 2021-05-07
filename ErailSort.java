package week3day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	public static void main(String[] args) throws InterruptedException {
		
		       //Launch the browser and URL
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
		        driver.manage().window().maximize();
		        driver.get("https://erail.in/");
		        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		        
		        //Uncheck the check box - sort on date
		        driver.findElement(By.xpath("//input[@checked='checked']")).click();
		        
		        //clear and type in the source station
		        driver.findElement(By.id("txtStationFrom")).clear();
		        driver.findElement(By.id("txtStationFrom")).sendKeys("MAS",Keys.TAB);// to get drop down value keys.tab
		        
		        //clear and type in the destination station
		        driver.findElement(By.id("txtStationTo")).clear();
		        driver.findElement(By.id("txtStationTo")).sendKeys("BNC",Keys.TAB);
		        
		        //Add a java sleep for 2 seconds
		        Thread.sleep(3000);
		        
		        //Store all the train names in a list
		     //   WebElement table = driver.findElementByXPath("//table[@class = 'DataTable DataTableHeader TrainList TrainListHeader']");
		        List<WebElement> trainName = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[2]"));
		        List<String>list1 = new ArrayList<String>();
		        for(int i = 0; i < trainName.size(); i++) {
		        	String list = trainName.get(i).getText();
		        	list1.add(list);
		        	System.out.println(list);		      	
		          
		        
		       //Use Java Collections sort to sort it and then print it
		        
		        Collections.sort(list1);
		        System.out.println(list1);
	}

}}
