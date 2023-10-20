package com.avics.framework.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.avics.framework.constants.ScriptConstants;

public class VerifyImage {
	String elementByTag; /* e.g XPATH, ID, NAME */
	String htmlElement; /* e.g actual id, xpath, name etc */

	public String getElementByTag() {
		return elementByTag;
	}

	public void setElementByTag(String elementByTag) {
		this.elementByTag = elementByTag;
	}

	public String getHtmlElement() {
		return htmlElement;
	}

	public void setHtmlElement(String htmlElement) {
		this.htmlElement = htmlElement;
	}

	public VerifyImage(String elementByTag, String htmlElement) {
		super();
		this.elementByTag = elementByTag;
		this.htmlElement = htmlElement;
	}

	public boolean verify(WebDriver driver) {
		int logoCount = 0;
		switch (this.elementByTag) {
		case ScriptConstants.XPATH:
			logoCount = driver.findElements(By.xpath(this.htmlElement)).size();
			break;
		case ScriptConstants.ID:
			logoCount = driver.findElements(By.id(this.htmlElement)).size();
			break;
		case ScriptConstants.NAME:
			logoCount = driver.findElements(By.name(this.htmlElement)).size();
			break;
		case ScriptConstants.LINKTEXT:
			logoCount = driver.findElements(By.linkText(this.htmlElement)).size();
			break;
		case ScriptConstants.TAGNAME:
			logoCount = driver.findElements(By.tagName(this.htmlElement)).size();
			break;
		case ScriptConstants.CLASSNAME:
			logoCount = driver.findElements(By.className(this.htmlElement)).size();
			break;
		case ScriptConstants.CSSSELECTOR:
			logoCount = driver.findElements(By.cssSelector(this.htmlElement)).size();
			break;
		case ScriptConstants.PARTIALTESTNAME:
			logoCount = driver.findElements(By.partialLinkText(this.htmlElement)).size();
			break;
		}
		return logoCount >= 1 ? true : false;
	}

}
