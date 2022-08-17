package lab6package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
 
import java.util.List;
 
 
import org.openqa.selenium.interactions.Actions;


public class lab6test {
	
	String baseurl = "https://omayo.blogspot.in/";
	public WebDriver driver;
	public Actions actions;
	public WebDriverWait wait;
		 
	 
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\4128\\Downloads/chromedriver.exe");
	  System.out.println("Launching Chrome browser..."); 
	  WebDriver driver=new ChromeDriver();
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // wait object
	  //Actions actions = new Actions(driver);
	  driver.get(baseurl);    // loading Website link 
	  WebElement textarea1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Text Area Field')]//following::textarea[contains(@id,'ta')]"))); // wait for page to load
	  driver.manage().window().maximize(); 
	 
  }
  
  @Test(priority=1)
  public void a() {
	     WebElement textarea3= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Text Area Field')]//following::textarea[contains(@id,'ta')]")));
	     //WebElement textarea1 = driver.findElement(By.xpath("//h2[contains(text(),'Text Area Field')]//following::textarea[contains(@id,'ta')]"));
	     textarea3.sendKeys("Muhammad Umair");
		 WebElement textarea2 = driver.findElement(By.xpath("//div[contains(@class,'widget-content')]//child::textarea[contains(@cols,'30') and contains(@rows,'10')]"));
		 String text = textarea2.getText();
		 System.out.println(text); // Printing the text field 2 text
		 textarea2.clear();
		 textarea2.sendKeys(" I like to Play Badminton ");
	  
  }
  @Test(priority=2)
  public void b() {
	  //get tabel data
	  String tabletext = null;
		// List<WebElement> tableelements=(List<WebElement>)
		// driver.findElement(By.xpath("//table[contains(@id,'table1')]"));
		List<WebElement> allElements = driver.findElements(By.xpath("//table[contains(@id,'table1')]"));

		for (WebElement element : allElements) {
			tabletext = element.getText();
			System.out.println("Table Text is " + tabletext);

		}
	  
	  
  }
 

//  @AfterTest
//  public void afterTest() {
//	  driver.close();
//  }

}
