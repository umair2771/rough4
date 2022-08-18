package lab6testng;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
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

public class lab6testng {
	public String baseurl = "https://omayo.blogspot.in/";
	public WebDriver driver;
	public Actions actions;
	public WebDriverWait wait;

	@BeforeTest
	public void openWebPage() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Umair\\Downloads\\chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseurl);

		// Create Actions & Wait Objects
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	

	@Test(priority = 0)
	public void textfieldtest() {
		WebElement textarea1 = driver.findElement(
				By.xpath("//h2[contains(text(),'Text Area Field')]//following::textarea[contains(@id,'ta')]"));
		actions.sendKeys(textarea1, Keys.PAGE_DOWN).perform();
		textarea1.sendKeys("Muhammad Umair");

		WebElement textarea2 = driver.findElement(By.xpath(
				"//div[contains(@class,'widget-content')]//child::textarea[contains(@cols,'30') and contains(@rows,'10')]"));
		String text = textarea2.getText();
		System.out.println(text); // Printing the text field 2 text
		textarea2.clear();
		textarea2.sendKeys(" I like to Play Badminton ");
	}

	@Test(priority = 1)
	public void tabletextget() {
		WebElement scroll2 = driver.findElement(
				By.xpath("//div[contains(@class,'widget HTML')]//following::form[contains(@name,'form1')]"));
		actions.sendKeys(scroll2, Keys.PAGE_DOWN).perform();
		String tabletext = null;
		List<WebElement> allElements = driver.findElements(By.xpath("//table[contains(@id,'table1')]"));

		for (WebElement element : allElements) {
			tabletext = element.getText();
			System.out.println("Table Text is " + tabletext);

		}
	}

	@Test(priority = 2)
	public void logintest1() {
		WebElement username = driver
				.findElement(By.xpath("//form[contains(@name,'form1')]//child::input[contains(@type,'text')]"));
		username.sendKeys("Umair2771");
		WebElement password = driver
				.findElement(By.xpath("//form[contains(@name,'form1')]//child::input[contains(@type,'password')]"));
		password.sendKeys("Sample12345");
		WebElement login = driver
				.findElement(By.xpath("//form[contains(@name,'form1')]//child::button[contains(@value,'LogIn')]"));
		login.click();
	}

	@Test(priority = 3)
	public void frametest() {
		List<WebElement> frame = driver.findElements(By.xpath("//iframe[contains(@id,'frame')]"));
		driver.switchTo().frame(frame.get(0));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame.get(1));
		driver.switchTo().defaultContent();

	}

	@Test(priority = 4)
	public void logintest2() {
		WebElement scroll3 = driver.findElement(By.xpath("//p[contains(@title,'Free Selenium tutorials')]"));
		actions.sendKeys(scroll3, Keys.PAGE_DOWN).perform();
		// js.executeScript("arguments[0].scrollIntoView()", scroll3);

		WebElement username2 = driver
				.findElement(By.xpath("//form[contains(@name,'login')]//following::input[contains(@name,'userid')]"));
		username2.sendKeys("Selenium123");
		WebElement password2 = driver
				.findElement(By.xpath("//form[contains(@name,'login')]//following::input[contains(@name,'pswrd')]"));
		password2.sendKeys("Password12345");
		WebElement login2 = driver
				.findElement(By.xpath("//form[contains(@name,'login')]//following::input[contains(@value,'Login')]"));
		actions.click(login2).perform();
		driver.switchTo().alert().accept();
	}

	@Test(priority = 5)
	public void buttonstest() {
		WebElement select1 = driver.findElement(
				By.xpath("//select[contains(@id,'multiselect1')]//child::option[contains(@value,'Hyundaix')]"));
		actions.sendKeys(select1, Keys.PAGE_DOWN).perform();
		// actions.click(select1).perform(); test failed on this
		select1.click();
		WebElement select2 = driver
				.findElement(By.xpath("//select[contains(@name,'SiteMap')]//child::option[contains(@value,'jkl')]"));
		// actions.click(select2).perform();
		select2.click();
		// Thread.sleep(1500);

		WebElement pretext = driver.findElement(By.xpath("//input[contains(@name,'fname')]"));
		// js.executeScript("arguments[0].scrollIntoView()", pretext);
		actions.sendKeys(pretext, Keys.PAGE_DOWN).perform();
		pretext.clear();
		pretext.sendKeys("Hello World !");
		WebElement enabledbutton = driver.findElement(By.xpath("//button[contains(@id,'but2')]"));
		actions.click(enabledbutton).perform();

		WebElement b1 = driver.findElement(By.xpath("//button[text()='Submit']"));
		WebElement b2 = driver.findElement(By.xpath("//button[text()='Login']"));
		WebElement b3 = driver.findElement(By.xpath("//button[text()='Register']"));
		actions.click(b1).perform();
		actions.click(b2).perform();
		actions.click(b3).perform();

		// click text disappear button

		WebElement b4 = driver.findElement(By.xpath("//input[contains(@id,'alert2')]"));
		actions.click(b4).perform();
		driver.switchTo().alert().accept();
		System.out.println("");

	}

	@Test(priority = 6)
	public void popuptest() {
		WebElement popup = driver.findElement(By.xpath("//a[starts-with(@href,'JavaScript:newPopup')]"));
		popup.click();
		String mainwin = driver.getWindowHandle();

		// All Window handles

		Set<String> allWindowHandles = driver.getWindowHandles();

		// Iterator
		Iterator<String> iterator = allWindowHandles.iterator();

		// check if child window has other child windows
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainwin.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				// Thread.sleep(1000);
				String newtext = "";
				newtext = " " + driver.findElement(By.xpath("//p[@id='para1']")).getText();
				System.out.println(newtext);
				newtext = " " + driver.findElement(By.xpath("//p[@id='para2']")).getText();
				System.out.println(newtext);
				driver.close();
			}

		}
		driver.switchTo().window(mainwin); // switching to parent window
	}

	@Test(priority = 7)
	public void checkboxestest() throws InterruptedException {

		WebElement trybutton = driver.findElement(By.xpath("//button[text()='Try it']"));
		// js.executeScript("arguments[0].scrollIntoView()", trybutton);
		actions.click(trybutton).perform();
		Thread.sleep(3100);
		// doubleclick
		WebElement doubleclickbt = driver.findElement(By.xpath("//button[text()=' Double click Here   ']"));
		// js.executeScript("arguments[0].scrollIntoView();", doubleclickbt);
		actions.doubleClick(doubleclickbt).perform();
		driver.switchTo().alert().accept();
		// checkbutton
		WebElement checkbt = driver.findElement(By.xpath("//button[text()='Check this']"));
		// js.executeScript("arguments[0].scrollIntoView();", checkbt);
		actions.sendKeys(checkbt, Keys.PAGE_DOWN).perform();
		actions.click(checkbt).perform();
		// mroption

		WebElement mroption = driver.findElement(By.xpath("//input[@id='dte']"));
		// js.executeScript("arguments[0].scrollIntoView();", doubleclickbt);
		actions.sendKeys(mroption, Keys.PAGE_DOWN).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dte']")));
		actions.click(mroption).perform();
	}

	@Test(priority = 8)
	public void sidebartest() {
		WebElement gender = driver.findElement(By.xpath("//input[@value='male']"));
		// js.executeScript("arguments[0].scrollIntoView();", gender);
		actions.click(gender).perform();

		// clicktogetalert

		WebElement clickalert = driver.findElement(By.xpath(" //input[contains(@value,'ClickToGetAlert')]"));
		// js.executeScript("arguments[0].scrollIntoView();", clickalert);
		actions.click(clickalert).perform();
		driver.switchTo().alert().accept();

		// select/deselect colours

		WebElement orng = driver.findElement(By.xpath("//input[contains(@value,'orange')]")); // orange
		// js.executeScript("arguments[0].scrollIntoView();", orng);
		boolean orngselect = orng.isSelected();
		if (orngselect == true) { // Checkbox Validation
			actions.click(orng).perform();
		}

		WebElement blue = driver.findElement(By.xpath("//input[contains(@value,'blue')]")); // blue
		// js.executeScript("arguments[0].scrollIntoView();", blue);
		boolean blueselect = blue.isSelected(); // Checkbox Validation
		if (blueselect == false) {
			actions.click(blue).perform();
		}

		// ReadThisText

		WebElement textread = driver.findElement(By.xpath("//input[@id='rotb']"));
		String textget = "";
		textget = textread.getAttribute("value");
		System.out.println("Text is = " + textget);

		// click on get prompt

		WebElement promptbutton = driver.findElement(By.xpath("//input[contains(@id,'prompt')]"));
		// js.executeScript("arguments[0].scrollIntoView();", promptbutton);
		promptbutton.click();
		driver.switchTo().alert().sendKeys("Umair");
		// Thread.sleep(3000);
		driver.switchTo().alert().accept();

		// click confirmation button
		WebElement confirmbutton = driver.findElement(By.xpath("//input[contains(@id,'confirm')]"));
		// js.executeScript("arguments[0].scrollIntoView();", confirmbutton);
		confirmbutton.click();
		driver.switchTo().alert().accept();

		// Filling text Fields

		WebElement field1 = driver
				.findElement(By.xpath("//h2[text()='Locate using class']//following-sibling::div//input"));
		WebElement field2 = driver.findElement(By
				.xpath("//h2[text()='element having same class name of above field']//following-sibling::div//input"));
		// js.executeScript("arguments[0].scrollIntoView();", field1);

		field1.sendKeys("Text of Class 1"); // passing text in fields
		field2.sendKeys("Porsche");

		WebElement vehicle = driver.findElement(By.xpath("//input[contains(@value,'Car')]")); // select vehicle
		vehicle.click();

		// Selecting Bag Laptop De selecting Book
		// BOOK
		WebElement book = driver.findElement(By.xpath(" //input[contains(@value,'Book')]"));
		boolean bookselect = book.isSelected();
		if (bookselect == true) { // Checkbox Validation
			actions.click(book).perform();
		}

		// BAG
		WebElement bag = driver.findElement(By.xpath(" //input[contains(@value,'Bag')]"));
		boolean bagselect = bag.isSelected();
		if (bagselect == false) { // Checkbox Validation
			actions.click(bag).perform();
		}

		// LAPTOP
		WebElement laptop = driver.findElement(By.xpath(" //input[contains(@value,'Laptop')]"));
		boolean laptopselect = laptop.isSelected();
		if (laptopselect == false) { // Checkbox Validation
			actions.click(laptop).perform();
		}

	}

	@Test(priority = 9)
	public void dropdownbtntest() {
		// Double Click Drop Down Button

		WebElement dropbtn = driver.findElement(
				By.xpath(" //div[contains(@class,'dropdown')]//child::button[contains(@class,'dropbtn')]"));
		// js.executeScript("arguments[0].scrollIntoView();", dropbtn);
		actions.click(dropbtn).perform();

		// Selecting Flipkart
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'http://facebook.com')]")));
		WebElement flipkart = driver.findElement(By.xpath("//a[contains(@href,'http://flipkart.com/')]"));
		actions.click(flipkart).perform();
	}

	
	
	
	@AfterTest
	public void driverclosing() {

		driver.quit();
	}

}
