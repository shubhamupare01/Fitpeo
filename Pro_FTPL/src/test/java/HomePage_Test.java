

import java.awt.AWTException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.HomePage;

public class HomePage_Test extends HomePage {
	
	HomePage homep;
	@BeforeMethod(alwaysRun = true)
	public void setup()
	{
		initialization();
		homep = new HomePage();
	}
	@Test(alwaysRun = false)
	public void VerifyURLTest() throws InterruptedException
		{
			String actualURL=homep.verifyurl();
			Assert.assertEquals(actualURL, "https://www.flipkart.com/");		
		}
	@Test(alwaysRun = false)
	public void verifyTitleTest()
		{
		String actualtitle = homep.verifyTitle();
		Assert.assertEquals(actualtitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		}
	@Test
	public void searchItemTest() throws InterruptedException, IOException, AWTException
		{
			String laptopName=homep.Search_item();
			Assert.assertFalse("Lenovo IdeaPad Slim 3 Intel Core i3 12th Gen".contains(laptopName));
		}
	@AfterMethod(alwaysRun = true)
	public void CloseBrowser()
	{
		driver.quit();
	}

}


//https://github.com/shubhamupare01/Fitpeo.git
