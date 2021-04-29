package Assisnments;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPath {

	public static void main(String[] args) {
		
	//1.  launch url
		   WebDriverManager.chromedriver().setup();
		   ChromeDriver driver = new ChromeDriver();
		   driver.manage().window().maximize();
           driver.get("http://leaftaps.com/opentaps/control/login");
        
    //2. enter username based on its label
           //label[text() = 'username']/following-sibling::input
      
    //3. enter password based on its label
           //label[text() = 'password']/following-sibling::input
    
    //4.  click login
           //form[@id = 'login']//input[@value = ' login']
        
    //5.  click crmsfa link
          //div[@for = 'crmsfa']/a

    //6.   click on leads link
          //a[text() = 'Leads']
        
   //7.    click on merge leads link
          //a[text() = 'Merge Leads']
        
   //8.    click the first image icon
          (//img[@src = '/images/fieldlookup.gif'])[1]
        		  
   //9.      Select the first resulting lead
        	//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a
        		  
   //10.     Select second image icon
        	//(//img[@src='/images/fieldlookup.gif'])[2]
        		  
        		  
   //11.     Select the second resulting lead  
        	//div[@class = "x-grid3-cell-inner x-grid3-col-partyId"]/a	
        		  
   //12.     Click on merge lead(submit) button
        	//a[text()='Merge']
        		  
   //13.     get the company name text based on its label
        	//label[text()='Company Name:'])[2]/following::input	  
        		  
        		  
        		  
        		  
	}

}
