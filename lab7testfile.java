
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class lab7testfile {
	public String baseurl = "http://baseline01.curemd.com/curemd/datLogin.asp";
	public WebDriver driver;
	public Actions actions;
	public WebDriverWait wait;
	pomfile obj;

	@BeforeTest
	public void openWebPage() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\4128\\Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseurl);

		// Create Actions & Wait Objects
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='vchLogin_Name']")));
		
		obj=new pomfile(driver);
 
	}

	@Test(priority = 1)
	public void logincmd() 
	{
 
		obj.usernamecmd.sendKeys("receipt"); // passing username
		obj.passcmd.sendKeys("SuPPort.2014"); // passing password
		// obj.loginbtn.click();
		actions.click(obj.loginbtn).perform(); // clicking login button
		
		
	}
	
	@Test(priority = 2)
	public void addpatient()  
	{   
		
		
		String mainwin = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		// Iterator
		Iterator<String> iterator = allWindowHandles.iterator();
		// check if child window has other child windows
		while (iterator.hasNext())
		{
			String ChildWindow = iterator.next();
			if (!mainwin.equalsIgnoreCase(ChildWindow))
			{
				driver.switchTo().window(ChildWindow);
				
			}

		}
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("fraCureMD_Menu"); //switching the frame by ID
		wait.until(ExpectedConditions.visibilityOf(obj.toplogo)); //wait 
		obj.patientbtn.click();
		wait.until(ExpectedConditions.visibilityOf(obj.addptn)); //wait 
	    obj.addptn.click();
	    
		
	}
	
//	@Test(priority = 3)
//	public void addingpatient()  {
//		
//		
//		
//	}
//	
	
	@AfterTest
	public void driverclosing() {

		driver.quit();
	}
	
}
