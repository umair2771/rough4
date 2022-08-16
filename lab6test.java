package lab6package;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class lab6test {
	
	String baseurl = "https://www.globalsqa.com/angularJs-protractor/BankingProject";
	 public WebDriver driver;
	 
	 
  
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\4128\\\\Downloads/chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get(baseurl);
		
  }
  @Test
  public void managerlogin() {
	  
	  
	  
  }
 

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
