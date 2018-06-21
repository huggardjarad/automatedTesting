package com.qa.quickstart.Task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Menu {
	
	WebDriver myDriver;
	
	public Menu(WebDriver myDriver) {
	
		this.myDriver = myDriver;
	}
	@FindBy(xpath = "//*[@id=\"navigate\"]/ul/li[1]")
	private WebElement homeBox;


	public void mouseHover() {
		Actions action = new Actions(myDriver);
		
		action.moveToElement(homeBox).perform();
		
		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
