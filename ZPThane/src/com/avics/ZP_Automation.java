package com.avics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class ZP_Automation {

	ZP_Automation() throws InterruptedException, IOException {
		WebDriver driver = this.launchBrowser();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("verifyLogo " + verifyLogo(driver));
		this.loginSuccessful(driver);

		// logout(driver);
		// loginFailuer(driver);
		mainInfoValidation(driver);
		vibhagInfoTest(driver);
		validateErrorMessageVibhagInfo(driver);
		validateTalukaInfo(driver);
		validateGramPanchayat(driver);
		closeWindow(driver);

	}

	// Launching browser
	private WebDriver launchBrowser() {
		System.setProperty("webdriver.edge.driver", "C:\\Framework\\drivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://143.110.187.115:8080/TrackingDashboardProd/#/login");
		driver.manage().window().maximize();
		return driver;

	}

	private void validateErrorMessageVibhagInfo(WebDriver driver) {
		// driver.findElement(By.id("inputtext")).click();

		/*
		 * driver.findElement(By.xpath("//span[text()='साठवा']")).click(); String
		 * expectedOutput = "वरील माहिती आवश्यक आहे";
		 * 
		 * String actualOutout = driver .findElement(By.xpath(
		 * "//following::div[text()=' वरील माहिती आवश्यक आहे '][@class='text-red-500 ng-star-inserted']]"
		 * )) .getText().toString().trim(); if (actualOutout.contains(expectedOutput)) {
		 * System.out.println("Check Vibhag Test : Pass --------"); } else {
		 * System.out.println("Check Vibhag Test : Fail XXXXXXXX"); }
		 */

	}

	private void mainInfoValidation(WebDriver driver) {

		driver.findElement(By.xpath(
				"//span[@class='p-menuitem-text ng-star-inserted'][text()='मुख्य माहिती ']//preceding::span[@class='p-menuitem-icon pi pi-fw pi-th-large mr-3 ng-star-inserted']"))
				.click();

	}
	private boolean verifyLogo(WebDriver driver){
		int logoCount = driver.findElements(By.xpath("//a/img[@src='assets/images/logo.JPG']")).size();
		return logoCount == 2 ? true : false;
	}

	private void loginSuccessful(WebDriver driver) throws InterruptedException {
		driver.findElement(By.name("email")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.className("p-button-label")).click();
		Thread.sleep(4000);
		String ExpectedText = "ठाणे जिल्हा परिषद";
		String ActualText = driver.findElement(By.xpath("//span[text()=' ठाणे जिल्हा परिषद ']")).getText().toString()
				.trim();
		Assert.assertEquals(ActualText, ExpectedText);
		/* Login Verified Successfully */

		/*
		 * String eletext1 = driver.findElement(By.
		 * xpath("//*[text()='मुख्य माहिती'][@class='p-menuitem-text ng-star-inserted']"
		 * )).getText(); System.out.println("ElementText = " + eletext1);
		 */

	}

	private void vibhagInfoTest(WebDriver driver) throws IOException {

		driver.findElement(By.xpath("//*[text()='विभाग माहिती'][@class='p-menuitem-text ng-star-inserted']")).click();

		driver.findElement(By.xpath("//button[@class='p-element p-ripple p-2 text-sm p-button p-component']")).click();
		driver.findElement(By.id("inputtext")).click();
		driver.findElement(By.className("p-button-label")).click();
		String expectedOutput = "वरील माहिती आवश्यक आहे";

		String actualOutout = driver.findElement(By.xpath("//div[text()=' वरील माहिती आवश्यक आहे ']")).getText()
				.toString().trim();
		if (actualOutout.contains(expectedOutput)) {
			System.out.println("Check Vibhag Test : Pass --------");
		} else {
			System.out.println("Check Vibhag Test : Fail XXXXXXXX");
		}
		driver.findElement(By.name("dhName")).click();
		driver.findElement(By.className("p-button-label")).click();
		String expectedOutput1 = "वरील माहिती आवश्यक आहे";

		String actualOutout1 = driver
				.findElement(
						By.xpath("//div[text()=' वरील माहिती आवश्यक आहे '][@class='text-red-500 ng-star-inserted']"))
				.getText().toString().trim();
		if (actualOutout1.contains(expectedOutput1)) {
			System.out.println("Check Vibhag Test : Pass --------");
		} else {
			System.out.println("Check Vibhag Test : Fail XXXXXXXX");
		}

		String vibhag = "Bandhkam Vibhag";
		String vibhagPramukh = "PWD Adhikari";
		driver.findElement(By.id("inputtext")).sendKeys(vibhag);
		driver.findElement(By.name("dhName")).sendKeys(vibhagPramukh);
		driver.findElement(By.xpath("//span[@class='p-button-label'][1]")).click();

		// Find the Row Size
		int tableRows = driver.findElements(By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr")).size();

		// Find the Column Size
		int tableColumns = driver.findElements(By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr[1]/td"))
				.size();
		String cellValue;
		boolean firstColumnMatch;
		boolean secondColumnMatch;
		int rowIdToDelete = 0;
		int columnIdToDelete = 0;
		// Iterate through row / columns
		for (int row = 1; row <= tableRows; row++) {
			firstColumnMatch = false;
			secondColumnMatch = false;
			for (int column = 1; column <= tableColumns; column++) {
				cellValue = driver
						.findElement(By.xpath(
								"//tbody[@class='p-element p-datatable-tbody']/tr[" + row + "]/td[" + column + "]"))
						.getText().trim();
				// Read and Check each row/column value with added value
				if ((column == 1 && cellValue.equals(vibhag))) {
					firstColumnMatch = true;
				}
				if ((column == 2 && cellValue.equals(vibhagPramukh))) {
					secondColumnMatch = true;
				}
				if (firstColumnMatch && secondColumnMatch) {
					rowIdToDelete = row;
					columnIdToDelete = column;
					System.out.println(vibhag + " and " + vibhagPramukh + "  --> साठवा ");
					break;
				}

			}
			// If row already match then no need to contiune with next row verification.
			if (firstColumnMatch && secondColumnMatch) {
				break;
			}
		}
		/*
		 * TakesScreenshot scrShot =((TakesScreenshot)driver); File
		 * SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		 * 
		 * File DestFile=new File("c://test.png");
		 * 
		 * //Copy file at destination
		 * 
		 * FileUtils.copyFile(SrcFile, DestFile);
		 */
		// Edit Row
		driver.findElement(By.xpath(
				"//tbody[@class='p-element p-datatable-tbody']/tr[" + rowIdToDelete + "]/td[" + columnIdToDelete + "]"))
				.click();

		driver.findElement(By.xpath("//span[@class='p-button-label'][text()='सुधारा']")).click();
		vibhag = vibhag.concat("1");
		vibhagPramukh = vibhagPramukh.concat("1");
		driver.findElement(By.id("inputtext")).clear();
		driver.findElement(By.id("inputtext")).sendKeys(vibhag);
		driver.findElement(By.name("dhName")).clear();
		driver.findElement(By.name("dhName")).sendKeys(vibhagPramukh);
		driver.findElement(By.xpath("//span[@class='p-button-label'][1]")).click();
		System.out.println(vibhag + " and " + vibhagPramukh + "  --> सुधारा ");

		// Delete the Row
		driver.findElement(By.xpath(
				"//tbody[@class='p-element p-datatable-tbody']/tr[" + rowIdToDelete + "]/td[" + columnIdToDelete + "]"))
				.click();
		driver.findElement(By.xpath("//span[@class='p-button-label'][text()='हटवा']")).click();
		driver.findElement(By.xpath("//span[@class='p-button-label'][text()='Yes']")).click();
		System.out.println(vibhag + " and " + vibhagPramukh + "  --> हटवा ");

	}

	public static void main(String[] args) throws InterruptedException {
		try {
			new ZP_Automation();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void validateTalukaInfo(WebDriver driver){
		
		driver.findElement(By.xpath(
				"//span[@class='p-menuitem-text ng-star-inserted'][text()='मुख्य माहिती ']//preceding::span[@class='p-menuitem-icon pi pi-fw pi-th-large mr-3 ng-star-inserted']"))
				.click();

		driver.findElement(By.xpath("//span[@class='p-menuitem-text ng-star-inserted'][text()='तालुका माहिती']"))
				.click();
		driver.findElement(By.xpath("//button[@class='p-element p-ripple p-2 text-sm p-button p-component']")).click();

		driver.findElement(By.id("inputtext")).click();
		driver.findElement(By.xpath("//span[@class='p-button-label'][text()='साठवा']")).click();
		String expectedOutput = "वरील माहिती आवश्यक आहे";

		String actualOutout = driver.findElement(By.xpath("//div[text()=' वरील माहिती आवश्यक आहे ']")).getText()
				.toString().trim();
		if (actualOutout.contains(expectedOutput)) {
			System.out.println("Taluka Validation Pass");
		} else {
			System.out.println("Taluka Validation Pass " + actualOutout);
		}
		String Taluka = "Jalgaon";
		/* Save Taluka */
		driver.findElement(By.id("inputtext")).sendKeys(Taluka);
		driver.findElement(By.xpath("//span[@class='p-button-label'][text()='साठवा']")).click();

		/* Search Taluka */

		// driver.findElement(By.xpath("//input[@class='p-inputtext p-component
		// p-element text-sm']")).click();
		driver.findElement(By.xpath("//input[@class='p-inputtext p-component p-element text-sm']")).sendKeys(Taluka);

		int tableRows = driver.findElements(By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr")).size();
		String rowValue = "";
		boolean matchRow = false;
		for (int row = 1; row <= tableRows; row++) {
			
			rowValue = driver.findElement(By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr[" + row + "]"))
					.getText().trim();
			if (rowValue != null && rowValue.contains(Taluka)) {
				matchRow = true;
			} else {
				matchRow = false;
				System.out.println("Taluka Search test failed for " + rowValue);
				break;
			}
		}
		if (matchRow) {
			System.out.println("Taluka Search Successfully Tested");
		}

		driver.findElement(By.xpath("//div[@class='ng-star-inserted'][text()=' Jalgaon ']")).click();
		driver.findElement(By.xpath("//span[@class='p-button-label'][text()='हटवा']")).click();
		driver.findElement(By.xpath("//button[@class='p-element p-ripple ng-tns-c55-39 p-confirm-dialog-accept p-button p-component ng-star-inserted']")).click();

	}
	



	private void validateGramPanchayat(WebDriver driver) {
		driver.findElement(By.xpath(
				"//span[@class='p-menuitem-text ng-star-inserted'][text()='मुख्य माहिती ']//preceding::span[@class='p-menuitem-icon pi pi-fw pi-th-large mr-3 ng-star-inserted']"))
				.click();
		driver.findElement(By.xpath("//span[@class='p-menuitem-text ng-star-inserted'][text()='ग्रामपंचायत माहिती']"))
				.click();
		driver.findElement(By.xpath("//button[@class='p-element p-ripple p-1 text-sm p-button p-component']")).click();
		driver.findElement(By.id("inputtext")).click();
		driver.findElement(By.xpath("//span[@class='p-button-label'][text()='साठवा']")).click();

		String expectedOutput = "वरील माहिती आवश्यक आहे";

		String actualOutout = driver.findElement(By.xpath("//div[text()=' वरील माहिती आवश्यक आहे ']")).getText()
				.toString().trim();
		if (actualOutout.contains(expectedOutput)) {
			System.out.println("Check gramPanchayat error message Test : Pass --------");
		} else {
			System.out.println("Check gramPanchayat error message Test : Fail XXXXXXXX");
		}
		driver.findElement(By.id("inputtext")).sendKeys("Thane");
		driver.findElement(By.name("gpDescription")).click();
		driver.findElement(By.xpath("//span[@class='p-button-label'][text()='साठवा']")).click();
	
		//driver.findElement(By.name("gpDescription")).click();
		//driver.findElement(By.name("gpDescription")).sendKeys("abc");
		

		

		String expectedOutput1 = "वरील माहिती आवश्यक आहे";
		//driver.findElement(By.name("gpDescription")).clear();
		String actualOutout1 = driver.findElement(By.xpath("//div[text()=' वरील माहिती आवश्यक आहे ']")).getText()
				.toString().trim();
		if (actualOutout1.contains(expectedOutput1)) {
			System.out.println("Check gramPanchayat 2 field error message Test : Pass --------");
		} else {
			System.out.println("Check gramPanchayat 2 field error message Test : Fail XXXXXXXX");
		}
		//driver.findElement(By.name("gpDescription")).clear();
		driver.findElement(By.name("gpDescription")).sendKeys("abc");
		driver.findElement(By.
			  xpath("//div[@class='p-dropdown p-component']//following::div[@class='p-dropdown p-component']")).click();
		driver.findElement(By.
				  xpath("//span[@class='ng-star-inserted'][text()='कल्याण']")).click();
		//  WebElement drpTalukaEle=driver.findElement(By.
		//  xpath("//div[@class='p-dropdown p-component']//following::div[@class='p-dropdown p-component']"));
		//  Select drpTaluka=new Select(drpTalukaEle); 
		//  drpTaluka.selectByVisibleText("कल्याण");
		  driver.findElement(By.xpath("//span[@class='p-button-label'][text()='साठवा']"
		  )).click();
	

	}
	
	private boolean logout() {
		//TO-Do
		return true;
	}
	private void closeWindow(WebDriver driver) {
		this.logout();
		driver.close();
		
	}

}
