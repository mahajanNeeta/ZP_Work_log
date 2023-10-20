package com.avics.framework.keywords;

import java.io.UnsupportedEncodingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.avics.framework.constants.ScriptConstants;

public class ClickButton {
	String elementTag;
	String htmlElement;
	public ClickButton(String elementTag, String htmlElement) {
		super();
		this.elementTag = elementTag;
		this.htmlElement = htmlElement;
	} 
	
	public void click(WebDriver driver) throws UnsupportedEncodingException {
		switch (this.elementTag) {
		case ScriptConstants.XPATH:
			driver.findElement(By.xpath(this.htmlElement)).click();
			break;
		case ScriptConstants.ID:
			driver.findElement(By.id(this.htmlElement)).click();
			break;
		case ScriptConstants.NAME:
			driver.findElement(By.name(this.htmlElement)).click();
			break;
		case ScriptConstants.LINKTEXT:
			driver.findElement(By.linkText(this.htmlElement)).click();
			break;
		case ScriptConstants.TAGNAME:
			driver.findElement(By.tagName(this.htmlElement)).click();
			break;
		case ScriptConstants.CLASSNAME:
			driver.findElement(By.className(this.htmlElement)).click();
			break;
		case ScriptConstants.CSSSELECTOR:
			driver.findElement(By.cssSelector(this.htmlElement)).click();;
		case ScriptConstants.PARTIALTESTNAME:
			driver.findElement(By.partialLinkText(this.htmlElement)).click();
			break;
		}
		
	}
}
