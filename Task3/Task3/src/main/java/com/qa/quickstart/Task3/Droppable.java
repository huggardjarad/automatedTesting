package com.qa.quickstart.Task3;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class Droppable {
	
	WebDriver myDriver;
	
	public Droppable(WebDriver myDriver) {
	
		this.myDriver = myDriver;
	}
	
	@FindBy(id = "draggableview")
	private WebElement draggablesquare;
	
	@FindBy(id = "droppableview")
	private WebElement dropsquare;
	

	
	public void clickAndDrop() {
		
		Actions action = new Actions(myDriver);
		
		action.moveToElement(draggablesquare).clickAndHold().moveToElement(dropsquare).release().perform();
	}
}
