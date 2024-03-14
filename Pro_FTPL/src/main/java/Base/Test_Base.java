package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Base {

	
	public static WebDriver driver;  //WebDriver instance: Declares a static WebDriver instance driver.
	public void initialization()  //Method to initialize WebDriver: Describes the purpose of the initialization() method.

	{
		WebDriverManager.edgedriver().setup();//Set up EdgeDriver using WebDriverManager: Uses WebDriverManager to set up the EdgeDriver.

		driver = new EdgeDriver();//Initialize WebDriver with EdgeDriver: Creates a new instance of EdgeDriver and assigns it to driver.

//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); //Delete all cookies: Clears all cookies before navigating to the website.

		driver.manage().window().maximize();  //Maximize window: Maximizes the browser window.

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//Implicit wait: Sets an implicit wait of 20 seconds for locating elements.

		driver.get("https://www.flipkart.com"); //Open the Flipkart website: Navigates to the Flipkart website using get() method.

}}

//Call initialization method in different class: Calls the initialization() method to set up WebDriver and open the website
//Create an instance of TestClass: Creates an instance of the TestClass.