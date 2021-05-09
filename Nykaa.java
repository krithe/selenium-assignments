package Assisnments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);

		// open https://www.myntra.com/
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Mouse over on Brands
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(brands).build().perform();
		
		//Mouse Over on Popular
		WebElement popular = driver.findElement(By.xpath("//a[text()='Popular']"));
		Actions action = new Actions(driver);
		builder.moveToElement(popular).build().perform();
		
		//Click on L'oreal Paris
		driver.findElement(By.xpath("//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']")).click();
		
		//Window Handles
		Set<String> allWindows =driver.getWindowHandles();
		List<String> listOfWindows = new ArrayList<String>(allWindows);
		driver.switchTo().window(listOfWindows.get(1));
		
		//Confirm the Title 
		String title = driver.getTitle();
		if(title.contains("L'Oreal Paris"))
		{
			System.out.println("Tile is L'Oreal Paris");
		}
		//Select Top rated using Sort By option
		driver.findElement(By.xpath("//span[text()='Sort By : ']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(2000);
		//Click on Category
		driver.findElement(By.xpath("//div[@class='pull-right filter-options-toggle']")).click();
		
		driver.findElement(By.xpath("//div[@class='filter-options-toggle']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//div[@class='control__indicator']")).click();
		String text = driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']/li")).getText();
		//System.out.println(text);
		if(text.contains("Shampoo")) {
			System.out.println("Filtered with Shampoo");
		}
		driver.findElement(By.xpath("//div[@id='listingContainer']/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[11]/div[1]/a[1]/div[1]/div[2]/div[1]/h2[1]/span[1]")).click();
		
		//Switch to new window
		allWindows = driver.getWindowHandles();
		listOfWindows=new ArrayList<String>(allWindows);
		driver.switchTo().window(listOfWindows.get(2));
		
		//Choose 175ml and get the price
		driver.findElement(By.xpath("//span[text()='175ml']")).click();
		String price = driver.findElement(By.xpath("//span[@class='post-card__content-price-offer']")).getText();
		//price=price.replaceAll("\\D", "").trim();
		price=price.replaceAll("\\D", " ");
		System.out.println("Price of Shampoo is:"+price);
		
		//Add to Bag Icon
		driver.findElement(By.xpath("//button[text()='ADD TO BAG']")).click();
		driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
		Thread.sleep(2000);
		
		//Get the Grand Total
		String grandTotal = driver.findElement(By.xpath("//div[text()='Grand Total']/following::div")).getText();
		grandTotal=grandTotal.replaceAll("\\D", "").trim();
		int Total=Integer.parseInt(grandTotal);
		System.out.println("Grand Total:"+Total);
         
		Thread.sleep(3000);
		//Click on Proceed and Continue as Guest
		driver.findElement(By.xpath("//button[@type='button']//span[1]")).click();
		//driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']")).click();
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		
		//Get the total 
		String totalVal = driver.findElement(By.xpath("//div[text()='Grand Total']/following::span")).getText();
		totalVal=totalVal.replaceAll("\\D", "").trim();
		int total=Integer.parseInt(totalVal);
		System.out.println("Grand Total at the end:"+total);
		
		//Check if it is same as grand Total
		if(Total==total) {
			System.out.println("Price amount is same");
		}
		
		driver.close();
		driver.switchTo().window(listOfWindows.get(1)).close();
		driver.switchTo().window(listOfWindows.get(0)).close();

			
				
				
				
		}
	
	
		


	}
