package week3.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		WebElement womenEle = driver.findElementByXPath("(//a[text()='Women'][1])");
		Actions builder = new Actions(driver);
		builder.moveToElement(womenEle).perform();
		driver.findElementByXPath("//a[text()='Jackets & Coats']").click();

		// getting total count of Jackets and coats

		String text = driver.findElementByXPath("//span[@class='title-count']").getText();
		String total = text.replaceAll("\\D", "");
		System.out.println("The Total Value of Jackets : " + total);
		int overall = Integer.parseInt(total);

		// getting total count of Jackets
		String int1 = driver.findElementByXPath("(//span[@class='categories-num'])[1]").getText();
		String value1 = int1.replaceAll("\\D", "");
		int add1 = Integer.parseInt(value1);

		// getting total count of coats
		String int2 = driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();
		String value2 = int2.replaceAll("\\D", "");
		int add2 = Integer.parseInt(value2);

		int sumOfJack = add1 + add2;
		System.out.println(sumOfJack);

		if (overall == sumOfJack) {
			System.out.println("The Count Matches");
		} else {
			System.out.println("The Count Doesnt Matches");
		}

		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();
		driver.findElementByXPath("//div[@class='brand-more']").click();
		driver.findElementByXPath("//input[@class='FilterDirectory-searchInput']").sendKeys("MANGO");
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[11]").click();
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();

		
		List<WebElement> listOfNames = driver.findElementsByXPath("//h3[text()='MANGO']");

//		for (WebElement allNames : listOfNames) {
//			System.out.println(allNames.getText());
//
//		}
//
		for (int i = 0; i < listOfNames.size(); i++) {
			if(listOfNames.get(i).getText().equals("MANGO")) {
				System.out.println("All Brand Matches");		
			}else {
				System.out.println("All Brand Doesnt Matches");
				}
		}
		WebElement sortEle = driver.findElementByXPath("//div[@class='sort-sortBy']");
		builder.moveToElement(sortEle).perform();
		driver.findElementByXPath("//label[text()='Better Discount']").click();
		List<WebElement> costOfProd = driver.findElementsByXPath("//span[@class='product-discountedPrice']");
		String costValue = costOfProd.get(0).getText();
		System.out.println("The Price of the Product : " + costValue);
		WebElement imgMouse = driver.findElementByXPath("(//img[@class='img-responsive'])[1]");
		builder.moveToElement(imgMouse).perform();
		driver.findElementByXPath("//span[@class='product-wishlistFlex product-actionsButton product-wishlist '][1]").click();;
		
		driver.close();

	}

	}

