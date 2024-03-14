package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base.Test_Base;

public class HomePage extends Test_Base {
	
	@FindBy(xpath = "//input[@type='text']")private WebElement Searchtextbox;  
	@FindBy(xpath = "//div[contains(text(),'Lenovo')][1]")private WebElement laptop;
	@FindBy(xpath = "//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]")private WebElement cartButton;
	@FindBy(xpath = "//input[@placeholder='Enter Delivery Pincode']")private WebElement pincodeTextbox;
	//Declares WebElements using @FindBy annotations for various elements on the page.

	
public HomePage()
{
	PageFactory.initElements(driver, this); //Initializes PageFactory elements in the constructor.
}
public String verifyTitle() //Method to verify page title: Returns the title of the current page.
{
	return driver.getTitle();
}
public String verifyurl()//Method to verify page URL: Returns the URL of the current page.
{
	return driver.getCurrentUrl();
}
public String Search_item() throws InterruptedException, IOException, AWTException
//Method to search for an item, select it, and add it to the cart: Performs the sequence of actions to search for an item, select it, enter pincode, and add it to the cart.

{
	Searchtextbox.sendKeys("laptop");
//	Searchtextbox.submit();
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
//	both Searchtextbox.submit(); and the Robot class approach achieve the same goal of triggering an action (such as submitting a form or triggering a search) by simulating pressing the "Enter" key. However, the Robot class approach offers more flexibility and control over the key press event and can be used in situations where submit() method may not be applicable or effective.
	
	String explaptopname = laptop.getText();
	
	laptop.click();
	
	String mainid = driver.getWindowHandle();
	Set <String> allid = driver.getWindowHandles();
	for(String refid : allid) {
		if (! mainid.equals(refid));
		{
			driver.switchTo().window(refid);
		}
	}
	pincodeTextbox.sendKeys("500001"); 
	pincodeTextbox.submit();
	Thread.sleep(2000);
	cartButton.click();
	Thread.sleep(5000);
	

	return explaptopname;
}
}

