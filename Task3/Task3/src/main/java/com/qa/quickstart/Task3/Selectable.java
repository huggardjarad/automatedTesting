package com.qa.quickstart.Task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Selectable {
	
	WebDriver myDriver;
	
	public Selectable(WebDriver myDriver) {
	
		this.myDriver = myDriver;
	}
	
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[1]")
	private WebElement item1Box;
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[2]")
	private WebElement item2Box;
	@FindBy(xpath ="//*[@id=\"selectable\"]/li[3]")
	private WebElement item3Box;
	@FindBy(xpath ="//*[@id=\"selectable\"]/li[4]")
	private WebElement item4Box;
	@FindBy(xpath ="//*[@id=\"selectable\"]/li[5]")
	private WebElement item5Box;
	@FindBy(xpath ="//*[@id=\"selectable\"]/li[6]")
	private WebElement item6Box;
	@FindBy(xpath ="//*[@id=\"selectable\"]/li[7]")
	private WebElement item7Box;
	
	
	public void clickBoxes() {
		Actions action = new Actions(myDriver);
		
		action.moveToElement(item1Box).click().perform();
		action.moveToElement(item2Box).click().perform();
		action.moveToElement(item3Box).click().perform();
		action.moveToElement(item4Box).click().perform();
		action.moveToElement(item5Box).click().perform();
		action.moveToElement(item6Box).click().perform();
		action.moveToElement(item7Box).click().perform();

	}
	public void selectAll() {
		
		Actions action2 = new Actions(myDriver);
		
		action2.moveToElement(item1Box).clickAndHold().moveToElement(item7Box).release().perform();
		
	}
}
