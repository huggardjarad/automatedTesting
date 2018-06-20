package com.qa.quickstart.Task3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DatePicker {

	WebDriver myDriver;
	
	public DatePicker(WebDriver myDriver) {
	
		this.myDriver = myDriver;
	}
	
	@FindBy(id ="datepicker1")
	private WebElement datePicker;
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]/a")
	private WebElement date;
	
	public void openDateSelection() {
		Actions action = new Actions(myDriver);
		
		action.moveToElement(datePicker).click().perform();
	}
	public void pickAndCheckDate() {
		
		Actions action2 = new Actions(myDriver);
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		action2.moveToElement(date).click().perform();
	}
}
