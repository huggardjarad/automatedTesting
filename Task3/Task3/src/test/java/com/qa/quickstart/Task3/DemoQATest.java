package com.qa.quickstart.Task3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

public class DemoQATest {
	
	ChromeDriver myDriver;
	
	static ExtentReports report;
	
	ExtentTest test;
	ExtentTest test2;
	
	@BeforeClass 
	public static void init() {	
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver.exe");
			report = new ExtentReports("C:\\Users\\Admin\\Reports\\DemoQAReport.html", true);
	}
	@Before
	public void setUp() {
		
		ExtentTest test = report.startTest("Verify Webpage");
		myDriver = new ChromeDriver();
		
		myDriver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser Started");
		String url = "http://demoqa.com/";
		myDriver.navigate().to(url);
		test.log(LogStatus.INFO, "URL Found");
		
		try{
			assertEquals("http://demoqa.com/", myDriver.getCurrentUrl());
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
	public void dropTest() {
		HomePage demoHome = PageFactory.initElements(myDriver, HomePage.class);
		ExtentTest test2 = report.startTest("Navigate to Droppable Page");
		demoHome.clickDroppableButton();
		test2.log(LogStatus.INFO, "Attempting to access droppable page...");
		try {
			assertEquals("http://demoqa.com/droppable/",myDriver.getCurrentUrl());
			test2.log(LogStatus.PASS, "Access Droppable Page");
		}catch (AssertionError g) {
			test2.log(LogStatus.FAIL, "Could Not Access Droppable Page");
		}finally {
			test2.log(LogStatus.INFO, "Current URL: " + myDriver.getCurrentUrl());
			report.endTest(test2);
		}
		
	}
	@After
	public void tearDown() {
		myDriver.close();
		report.flush();
	}

}