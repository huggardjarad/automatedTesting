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
	
	public void clickSelectableButton() {
		selectableButton.click();
	}
	
	@FindBy(xpath = "//*[@id=\"menu-item-144\"]/a")
	private WebElement accordionWidget;
	
	public void clickAccordionButton() {
		accordionWidget.click();
	}
	@FindBy(xpath = "//*[@id=\"menu-item-145\"]/a")
	private WebElement autocompleteWidget;
	
	public void clickAutoCompleteButton() {
		autocompleteWidget.click();
	}
	@FindBy(xpath = "//*[@id=\"menu-item-146\"]/a")
	private WebElement datePickerWidget;
	
	public void clickDatePickerButton() {
		datePickerWidget.click();
	}
	
}

	
