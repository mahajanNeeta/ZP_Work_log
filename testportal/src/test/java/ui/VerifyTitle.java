package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTitle {
	@Test
	public void TitleTest()
	{
		String expectedtitle="Electronics, Cars, Fashion, Collectibles & More | eBay";
		
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.ebay.com.au/");
		String actualtitle=driver.getTitle();
		
		Assert.assertEquals(actualtitle, expectedtitle);
	}
	

}
