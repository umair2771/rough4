

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pomfile {
	
	 WebDriver driver;
	 
	 @FindBy(xpath="//input[@name='vchLogin_Name']")
	    WebElement usernamecmd;
	 
	 @FindBy(xpath="//input[@name='vchPassword']")
	    WebElement passcmd;
	 
	 @FindBy(xpath="//button[contains(text(),'Login')]")
	    WebElement loginbtn;
	 @FindBy(xpath="//img[contains(@title,'Patient')]")
	    WebElement patientbtn;
	 @FindBy(xpath="//img[contains(@id,'topImgTest')]")
	    WebElement toplogo;
	 @FindBy(xpath="//img[contains(@alt,'Add Patient')]")
	    WebElement addptn;
	
	 public pomfile(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
		 
		 
	 }
	 
	
	

}
