package com.qa.quickstart.Task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Slider {
	
	WebDriver myDriver;
	
	public Slider(WebDriver myDriver) {
	
		this.myDriver = myDriver;
	}
	
	@FindBy(xpath = "//*[@id=\"slider-range-max\"]/span")
	private WebElement sliderIcon;
	
	public void sliderPull() {
		Actions action = new Actions(myDriver);
		WebDriverWait wait = new WebDriverWait(myDriver, 5);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"slider-range-max\"]/span")));
		
		action.moveToElement(sliderIcon).clickAndHold().moveByOffset(500, 0).release().perform();
		
	}
}
