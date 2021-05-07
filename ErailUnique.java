package week3day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {
		
		//Set the system property and Launch the URL
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://erail.in/");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        
        //Click the 'sort on date' checkbox
        driver.findElement(By.id("chkSelectDateOnly")).click();
        
        //clear and type in the from station text field
        driver.findElement(By.id("txtStationFrom")).clear();
        driver.findElement(By.id("txtStationFrom")).sendKeys("MAS",Keys.TAB);
        
        //clear and type in the to station text field
        driver.findElement(By.id("txtStationTo")).clear();
        driver.findElement(By.id("txtStationTo")).sendKeys("BNC",Keys.TAB);
        
        //Add a java sleep for 2 seconds
        Thread.sleep(3000);
        
        //Store all the train names in a list          
        List<WebElement> trainnames = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[2]"));
        
        List<String> lst = new ArrayList<String>();
        for(int i = 0; i < trainnames.size(); i++) {
        	String List = trainnames.get(i).getText();
        	lst.add(List);
        }
       
      //And print the size of it
        System.out.println(lst.size());
        HashSet<String> set = new HashSet<String>(lst);
        
      //put in set and print size
        
        for(String train : lst) {
        	set.add(train);
        }
        
        System.out.println(set);
        System.out.println(set.size());
	}}
            
       
        
        
        
        
        
        
        
        
        
        
        
        
        

	


