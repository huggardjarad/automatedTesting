package com.qa.quickstart.Task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Accordion {
	
WebDriver myDriver;
	
	public Accordion(WebDriver myDriver) {
	
		this.myDriver = myDriver;
	}
	
	@FindBy(id ="ui-id-4")
	private WebElement section1;
	@FindBy(id = "ui-id-6")
	private WebElement section2;
	@FindBy(id = "ui-id-8")
	private WebElement section3;
	@FindBy(id = "ui-id-10")
	private WebElement section4;
	
	public void clickTabs() {
		
		Actions action = new Actions(myDriver);
		
		action.moveToElement(section1).click().perform();
		action.moveToElement(section2).click().perform();
		action.moveToElement(section3).click().perform();
		action.moveToElement(section4).click().perform();
	}
}
