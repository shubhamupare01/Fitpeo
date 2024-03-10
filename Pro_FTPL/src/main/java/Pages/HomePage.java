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

	
public HomePage()
{
	PageFactory.initElements(driver, this);
}
public String verifyTitle()
{
	return driver.getTitle();
}
public String verifyurl()
{
	return driver.getCurrentUrl();
}
public String Search_item() throws InterruptedException, IOException, AWTException
{
	Searchtextbox.sendKeys("laptop");
//	Searchtextbox.submit();
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	
	String explaptopname = laptop.getText();
//	System.out.println(explaptopname);
	
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
