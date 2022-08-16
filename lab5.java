package lab5;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.beust.jcommander.JCommander.Builder;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class lab5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\4128\\\\Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // wait object
		Actions actions = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver; // for scrolling
		driver.manage().window().maximize();

		// step 0

		String baseurl = "https://omayo.blogspot.in/";
		driver.get(baseurl); // load page

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h2[contains(text(),'Text Area Field')]//following::textarea[contains(@id,'ta')]"))); // wait
																													// for
																													// page
																													// to
																													// load

		// step 1

		WebElement textarea1 = driver.findElement(
				By.xpath("//h2[contains(text(),'Text Area Field')]//following::textarea[contains(@id,'ta')]"));
		// js.executeScript("arguments[0].scrollIntoView()", textarea1);
		actions.sendKeys(textarea1, Keys.PAGE_DOWN).perform();
		textarea1.sendKeys("Muhammad Umair");

		WebElement textarea2 = driver.findElement(By.xpath(
				"//div[contains(@class,'widget-content')]//child::textarea[contains(@cols,'30') and contains(@rows,'10')]"));
		String text = textarea2.getText();
		System.out.println(text); // Printing the text field 2 text
		textarea2.clear();
		textarea2.sendKeys(" I like to Play Badminton ");
		System.out.println("");
		// Thread.sleep(1000);

		// step 2

		WebElement scroll2 = driver.findElement(
				By.xpath("//div[contains(@class,'widget HTML')]//following::form[contains(@name,'form1')]"));
		// js.executeScript("arguments[0].scrollIntoView()", scroll2);
		actions.sendKeys(scroll2, Keys.PAGE_DOWN).perform();

		String tabletext = null;
		// List<WebElement> tableelements=(List<WebElement>)
		// driver.findElement(By.xpath("//table[contains(@id,'table1')]"));
		List<WebElement> allElements = driver.findElements(By.xpath("//table[contains(@id,'table1')]"));

		for (WebElement element : allElements) {
			tabletext = element.getText();
			System.out.println("Table Text is " + tabletext);

		}

		// Thread.sleep(1000);

		WebElement username = driver
				.findElement(By.xpath("//form[contains(@name,'form1')]//child::input[contains(@type,'text')]"));
		username.sendKeys("Umair2771");
		WebElement password = driver
				.findElement(By.xpath("//form[contains(@name,'form1')]//child::input[contains(@type,'password')]"));
		password.sendKeys("Sample12345");
		WebElement login = driver
				.findElement(By.xpath("//form[contains(@name,'form1')]//child::button[contains(@value,'LogIn')]"));
		login.click();
		// Thread.sleep(1000);
		List<WebElement> frame = driver.findElements(By.xpath("//iframe[contains(@id,'frame')]"));

		driver.switchTo().frame(frame.get(0));
		// Action mouseOverHome = actions.moveByOffset(250, 45).build();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame.get(1));
		driver.switchTo().defaultContent();

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
		login2.click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

//step 4

		WebElement select1 = driver.findElement(
				By.xpath("//select[contains(@id,'multiselect1')]//child::option[contains(@value,'Hyundaix')]"));
		// js.executeScript("arguments[0].scrollIntoView()", select1);
		actions.sendKeys(select1, Keys.PAGE_DOWN).perform();
		Thread.sleep(500);
		select1.click();
		WebElement select2 = driver
				.findElement(By.xpath("//select[contains(@name,'SiteMap')]//child::option[contains(@value,'jkl')]"));
		select2.click();
		Thread.sleep(1500);

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
		js.executeScript("arguments[0].scrollIntoView()", b3);
		actions.click(b1).perform();
		actions.click(b2).perform();
		actions.click(b3).perform();

		// click text disappear button

		WebElement b4 = driver.findElement(By.xpath("//input[contains(@id,'alert2')]"));
		js.executeScript("arguments[0].scrollIntoView()", b4);
		actions.click(b4).perform();
		// Thread.sleep(1000);
		driver.switchTo().alert().accept();
		System.out.println("");

		// Popup click
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
		driver.switchTo().window(mainwin);
		// trybutton
		WebElement trybutton = driver.findElement(By.xpath("//button[text()='Try it']"));
		js.executeScript("arguments[0].scrollIntoView()", trybutton);
		actions.click(trybutton).perform();
		Thread.sleep(3100);
		// doubleclick
		WebElement doubleclickbt = driver.findElement(By.xpath("//button[text()=' Double click Here   ']"));
		js.executeScript("arguments[0].scrollIntoView();", doubleclickbt);
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
		// Thread.sleep(2000);

		// step 5

		// genderselect
		WebElement gender = driver.findElement(By.xpath("//input[@value='male']"));
		js.executeScript("arguments[0].scrollIntoView();", gender);
		actions.click(gender).perform();

		// clicktogetalert

		WebElement clickalert = driver.findElement(By.xpath(" //input[contains(@value,'ClickToGetAlert')]"));
		js.executeScript("arguments[0].scrollIntoView();", clickalert);
		actions.click(clickalert).perform();
		driver.switchTo().alert().accept();

		// select/deselect colours

		WebElement orng = driver.findElement(By.xpath("//input[contains(@value,'orange')]")); // orange
		js.executeScript("arguments[0].scrollIntoView();", orng);
		boolean orngselect = orng.isSelected();
		if (orngselect == true) { // Checkbox Validation
			actions.click(orng).perform();
		}

		WebElement blue = driver.findElement(By.xpath("//input[contains(@value,'blue')]")); // blue
		js.executeScript("arguments[0].scrollIntoView();", blue);
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
		js.executeScript("arguments[0].scrollIntoView();", promptbutton);
		promptbutton.click();
		driver.switchTo().alert().sendKeys("Umair");
		// Thread.sleep(3000);
		driver.switchTo().alert().accept();

		// click confirmation button
		WebElement confirmbutton = driver.findElement(By.xpath("//input[contains(@id,'confirm')]"));
		js.executeScript("arguments[0].scrollIntoView();", confirmbutton);
		confirmbutton.click();
		driver.switchTo().alert().accept();

		// Filling text Fields

		WebElement field1 = driver
				.findElement(By.xpath("//h2[text()='Locate using class']//following-sibling::div//input"));
		WebElement field2 = driver.findElement(By
				.xpath("//h2[text()='element having same class name of above field']//following-sibling::div//input"));
		js.executeScript("arguments[0].scrollIntoView();", field1);

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

		// Double Click Drop Down Button

		WebElement dropbtn = driver.findElement(
				By.xpath(" //div[contains(@class,'dropdown')]//child::button[contains(@class,'dropbtn')]"));
		js.executeScript("arguments[0].scrollIntoView();", dropbtn);
		actions.click(dropbtn).perform();

		// Selecting Flipkart
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'http://facebook.com')]")));
		WebElement flipkart = driver.findElement(By.xpath("//a[contains(@href,'http://flipkart.com/')]"));
		actions.click(flipkart).perform();

		// Upload File
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'uploadfile')]")));
		WebElement upload = driver.findElement(By.xpath("//input[contains(@id,'uploadfile')]"));
		// actions.sendKeys(upload,Keys.PAGE_DOWN).perform();
		js.executeScript("arguments[0].scrollIntoView();", upload);
		upload.sendKeys("C:\\\\Users\\\\4128\\\\Desktop/download.png");

	}

}
