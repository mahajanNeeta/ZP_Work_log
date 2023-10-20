package com.avics.framework.keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchBrowser {
	String browser;
	String url;
	public LaunchBrowser(String browser, String url) {
		this.browser = browser;
		this.url = url;
	}
	
	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public WebDriver launch() {	
		String driverName = "webdriver.edge.driver";
		WebDriver driver = null;
		String baseLocation = "C:\\Framework\\drivers\\";
		String driverEXE = "msedgedriver.exe";
		if(this.browser.equalsIgnoreCase("edge")) {
			driverName = "webdriver.edge.driver";
			driverEXE = "msedgedriver.exe";
		} else if(this.browser.equalsIgnoreCase("chrome")) {
			driverName = "webdriver.chrome.driver";
			driverEXE = "chromedriver.exe";
		} else if(this.browser.equalsIgnoreCase("firefox")) {
			driverName = "webdriver.firefox.driver";
			driverEXE = "iedriver.exe";
		} else if(this.browser.equalsIgnoreCase("IE")) {
			driverName = "webdriver.ie.driver";
			driverEXE = "geckodriver.exe";
		}	
		
		System.setProperty(driverName, baseLocation + driverEXE);
		
		if(this.browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if(this.browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if(this.browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if(this.browser.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		}	
				
		driver.get(this.getUrl());
		driver.manage().window().maximize();
		return driver;
	}

}
