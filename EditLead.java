package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead{

ChromeDriver driver;
	
	@Given("Launch Chrome browser")

	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("http://leaftaps.com/opentaps/control/login");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}
	
	@When("Load URL {string}")
	public void loadurl(String url) {
		driver.get(url);
	}
	
	@And("Type username as {string}")
	public void typeUserName(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}
	@And("Type Password as {string}")
	public void typePassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	
}

    @And("Click Login Button")
    public void clickOnSubmit() {
	driver.findElement(By.className("decorativeSubmit")).click();
}
    @And("Click CRMSFA")

	public void clickCrmSfa() {
		driver.findElement(By.linkText("CRM/SFA")).click();

	}

    @And("Click Leads Tab")
	public void clickLeadsTab() {
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
	}
    @When("Click Find Leads Link")
    public void clickFindLeadsLink() {
    	driver.findElement(By.linkText("Find Leads")).click();
    }

    @When("Click Phone Tab")
    public void clickPhoneTab() {
    	driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[2]")).click();
    }
    @And("Type Phone Number as (.*)$")
    public void typePhoneNumber( String phonenumber) {
    	driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(phonenumber);
    }
    @And("Click Find Leads Button")
    public void clickFindLeadsButton() throws InterruptedException {
    	driver.findElementByXPath("//button[text()='Find Leads']").click();
    	Thread.sleep(2000);
    }
    @And("Click on the First Resulting Lead")
    public void clickResultingLead() {
    	driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
    }
    
    @And("Click on Edit Tab")
    public void clickEditTab() {
    	driver.findElementByLinkText("Edit").click();
    }
    
    @And("Clear Company name")
    public void clearCompanyName() {
    	driver.findElementById("updateLeadForm_companyName").clear();
    }
    
    @And("Type Company name as(.*)$")
    public void typeCompanyName(String companyname) {
    	driver.findElementById("updateLeadForm_companyName").sendKeys(companyname);
    } 
    
    @And("Click on update button")
    public void clickUpdateButton() {
    	driver.findElementByName("submitButton").click();
    }
 
		}
      
    
    
    
    
    
