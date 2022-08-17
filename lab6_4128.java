package com.lab6_4128;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.beust.jcommander.JCommander.Builder;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class lab6_4128 {

	String baseurl= "https://omayo.blogspot.in/";
	public WebDriver driver;
	public Actions actions;
	public WebDriverWait wait;
	
	@BeforeTest
	public void launchwebsite() 
	{
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\Umair\\Downloads\\chromedriver_win32/chromedriver.exe");
		  System.out.println("Launching Chrome browser..."); 
	      WebDriver driver=new ChromeDriver();
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // wait object
	      //Actions actions = new Actions(driver);
		  driver.get(baseurl);    // loading Website link 
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Text Area Field')]//following::textarea[contains(@id,'ta')]"))); // wait for page to load
		  driver.manage().window().maximize();
	
		
	}
	
	@Test (priority=1)
	 public void checktextfield() {
	 WebElement textarea1 = driver.findElement(By.xpath("//h2[contains(text(),'Text Area Field')]//following::textarea[contains(@id,'ta')]"));
	 //actions.sendKeys(textarea1, Keys.PAGE_DOWN).perform();
	 textarea1.sendKeys("Muhammad Umair");
	 WebElement textarea2 = driver.findElement(By.xpath("//div[contains(@class,'widget-content')]//child::textarea[contains(@cols,'30') and contains(@rows,'10')]"));
	 String text = textarea2.getText();
	 System.out.println(text); // Printing the text field 2 text
	 textarea2.clear();
	 textarea2.sendKeys(" I like to Play Badminton ");
		
	}
	
	@Test (priority=2)
	 public void tabledata()
	{
		String tabletext = null;
		List<WebElement> allElements = driver.findElements(By.xpath("//table[contains(@id,'table1')]"));
		for (WebElement element : allElements)
		{
			tabletext = element.getText();
			System.out.println("Table Text is " + tabletext);

		}
		
	}
	
	}
	
	
	
	

