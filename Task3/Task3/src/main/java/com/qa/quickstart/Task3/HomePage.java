package com.qa.quickstart.Task3;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage {


	@FindBy(xpath = "//*[@id=\"menu-item-141\"]/a") 
	private WebElement droppableButton;
	
	
	
	public void clickDroppableButton() {
		
		droppableButton.click();
	}
	
	@FindBy(xpath = "//*[@id=\"menu-item-142\"]/a")
	private WebElement selectableButton;
	
}

	