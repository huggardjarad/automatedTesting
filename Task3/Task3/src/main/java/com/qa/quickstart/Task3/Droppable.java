package com.qa.quickstart.Task3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class Droppable {
	
	ChromeDriver myDriver;
	
	@FindBy(id = "draggableview")
	private WebElement draggablesquare;
	
	@FindBy(id = "droppableview")
	

	
	public void clickAndDrop() {
		Actions action = new Actions(myDriver);
		
		action.moveToElement(draggablesquare).clickAndHold();
	}
}
