package com.qa.quickstart.Task2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class automationPracticeTest {
	
	ChromeDriver myDriver;
	
	static ExtentReports report;
	
	ExtentTest test; 
	
	ExtentTest test2;
	
	@BeforeClass 
	public static void init() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver.exe");
		report = new ExtentReports("C:\\Users\\Admin\\Reports\\automationPractiseReport.html", true);
	}
	
	@Before
	public void setUp() {
		
		ExtentTest test = report.startTest("Verify Webpage");
		myDriver = new ChromeDriver();
		
		myDriver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser Started");
		String url = "http://automationpractice.com/index.php";
		myDriver.navigate().to(url);
		test.log(LogStatus.INFO, "URL Found");
		
		try{
			assertEquals("http://automationpractice.com/index.php", myDriver.getCurrentUrl());
			test.log(LogStatus.PASS, "Nice one, Webpage Found!");
		}catch(AssertionError e) {
			test.log(LogStatus.FAIL, "Bad Luck, Webpage Not Found");
			fail();
		}finally {
			test.log(LogStatus.INFO, "Current URL:" + myDriver.getCurrentUrl() );
			report.endTest(test);
		}
	}

	@Test
	public void test() {
		
		ExtentTest test2 = report.startTest("Search for Dress");
		 
		WebElement searchBar = myDriver.findElement(By.id("search_query_top"));
		searchBar.click();
		searchBar.sendKeys("Dress");
		test2.log(LogStatus.INFO, "Searched for Dress in Search Bar");
		
		WebElement searchButton = myDriver.findElement(By.xpath("//*[@id=\"searchbox\"]/button"));
		searchButton.click();
		test2.log(LogStatus.INFO, "Executed Search");
		
		WebElement pass = myDriver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"));
		try{
			assertEquals("Printed Summer Dress", pass.getText()); 
			test2.log(LogStatus.PASS, "Nice One!, Dress Found");
		}catch(AssertionError f) {
			test2.log(LogStatus.FAIL, "Bad Luck!, Dress Not Found");
			fail();
		}finally {
			test2.log(LogStatus.INFO, "Test Complete" +"\nCurrent Url: " + myDriver.getCurrentUrl());
			report.endTest(test2);
		}
	}
	@After
	public void tearDown() {
		myDriver.close();
		report.flush();
	}

}
