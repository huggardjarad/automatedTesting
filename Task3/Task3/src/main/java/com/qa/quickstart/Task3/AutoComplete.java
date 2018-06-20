package com.qa.quickstart.Task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AutoComplete {
	
	WebDriver myDriver;
	
	public AutoComplete(WebDriver myDriver) {
	
		this.myDriver = myDriver;
	}
	@FindBy(id = "tagss")
	private WebElement searchBar;
	
	@FindBy(id = "ui-id-7")
	private WebElement dropDownBasic;
	
	public void selectAndSearch() {
		Actions action = new Actions(myDriver);
		
		action.moveToElement(searchBar).click().sendKeys("b").perform();
	}
	public void selectDropDown() {
		Actions action2 = new Actions(myDriver);
		
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		action2.moveToElement(dropDownBasic).click().perform(); 
	}
	
}
