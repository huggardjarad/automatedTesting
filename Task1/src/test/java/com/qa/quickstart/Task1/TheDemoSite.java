package com.qa.quickstart.Task1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TheDemoSite {
	

	ChromeDriver myDriver;
	
	@BeforeClass 
	public static void init() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver.exe");
	
	}
	
	@Before
	public void setUp() {
		myDriver = new ChromeDriver();
		
		myDriver.manage().window().maximize();
		String url = "http://thedemosite.co.uk/index.php";
		myDriver.navigate().to(url);
		
		assertEquals("http://thedemosite.co.uk/index.php", myDriver.getCurrentUrl());
	}
	
	@Test
	
	public void navigatetoUser() {
		
	WebElement checkElement = myDriver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
			
	checkElement.click();
	assertEquals("http://thedemosite.co.uk/addauser.php", myDriver.getCurrentUrl());
	
		WebElement userNameBox = myDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		
		userNameBox.click();
		userNameBox.sendKeys("jaradbot1");
		
		WebElement passwordBox = myDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		
		passwordBox.click();
		passwordBox.sendKeys("Pa55word1");
		
		WebElement sendElements = myDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
		sendElements.click();
	}
	
	@After
	public void navigatetoLogin() {
		
		WebElement login = myDriver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
		
		login.click();
		
		WebElement loginUser = myDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		
		loginUser.click();
		loginUser.sendKeys("jaradbot1");
		
		WebElement loginPass = myDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		loginPass.click();
		loginPass.sendKeys("Pa55word1");
		
		WebElement loginButton = myDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
		loginButton.click();
		
		WebElement pass = myDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		assertEquals("**Successful Login**",pass.getText());
		
		myDriver.close();
	}
	

}
