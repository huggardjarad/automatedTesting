package com.qa.quickstart.Task2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class automationPracticeTest {
	
	ChromeDriver myDriver;
	
	@BeforeClass 
	public static void init() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver.exe");
	}
	
	@Before
	public void setUp() {
		myDriver = new ChromeDriver();
		
		myDriver.manage().window().maximize();
		String url = "http://automationpractice.com/index.php";
		myDriver.navigate().to(url);
		
		assertEquals("http://automationpractice.com/index.php", myDriver.getCurrentUrl());
	}

	@Test
	public void test() {
		
		WebElement searchBar = myDriver.findElement(By.id("search_query_top"));
		searchBar.click();
		searchBar.sendKeys("Dress");
		
		WebElement searchButton = myDriver.findElement(By.xpath("//*[@id=\"searchbox\"]/button"));
		searchButton.click();
		
		WebElement pass = myDriver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"));
		assertEquals("Printed Summer Dress", pass.getText()); 
			
	}
	@After
	public void tearDown() {
		myDriver.close();
	}

}
