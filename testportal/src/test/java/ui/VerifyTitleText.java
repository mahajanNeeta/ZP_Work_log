package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyTitleText {
	@Test
	public void TitleTest()
	{
		SoftAssert softassert= new SoftAssert();
		String expectedtitle="Electronics, Cars, Fashion, Collectibles & More | eBay";
		String expectedtext="Search";
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.ebay.com.au/");
		String actualtitle=driver.getTitle();
		
		softassert.assertEquals(actualtitle, expectedtitle);
		String actualtext=driver.findElement(By.xpath("//input[@id='gh-btn']")).getAttribute("value");
		softassert.assertEquals(actualtext, expectedtext,"Test verification faild");
	}
	

}
