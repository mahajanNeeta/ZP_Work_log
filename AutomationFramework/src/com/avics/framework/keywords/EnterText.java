package com.avics.framework.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.avics.framework.constants.ScriptConstants;

public class EnterText {
	String elementTag;
	String htmlElement;
	String inputText;

	public EnterText(String elementTag, String htmlElement, String inputText) {
		super();
		this.elementTag = elementTag;
		this.htmlElement = htmlElement;
		this.inputText = inputText;
	}

	public void enter(WebDriver driver) {
		switch (this.elementTag) {
		case ScriptConstants.XPATH:
			driver.findElement(By.xpath(this.htmlElement)).sendKeys(this.inputText);
			break;
		case ScriptConstants.ID:
			driver.findElement(By.id(this.htmlElement)).sendKeys(this.inputText);
			break;
		case ScriptConstants.NAME:
			driver.findElement(By.name(this.htmlElement)).sendKeys(this.inputText);
			break;
		case ScriptConstants.LINKTEXT:
			driver.findElement(By.linkText(this.htmlElement)).sendKeys(this.inputText);
			break;
		case ScriptConstants.TAGNAME:
			driver.findElement(By.tagName(this.htmlElement)).sendKeys(this.inputText);
			break;
		case ScriptConstants.CLASSNAME:
			driver.findElement(By.className(this.htmlElement)).sendKeys(this.inputText);
			break;
		case ScriptConstants.CSSSELECTOR:
			driver.findElement(By.cssSelector(this.htmlElement)).sendKeys(this.inputText);
			break;
		case ScriptConstants.PARTIALTESTNAME:
			driver.findElement(By.partialLinkText(this.htmlElement)).sendKeys(this.inputText);
			break;
		}
	}
}
