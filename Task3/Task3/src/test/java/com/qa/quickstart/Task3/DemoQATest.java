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
			test2.log(LogStatus.PASS, "Accessed Droppable Page");
		}catch (AssertionError g) {
			test2.log(LogStatus.FAIL, "Could Not Access Droppable Page");
			fail();
		}finally {
			test2.log(LogStatus.INFO, "Current URL: " + myDriver.getCurrentUrl());
			report.endTest(test2);
		}
		ExtentTest test3 = report.startTest("Moving box to location");
		Droppable demoDrop = PageFactory.initElements(myDriver, Droppable.class );
		demoDrop.clickAndDrop();
		test3.log(LogStatus.INFO, "Attempting to drag and drop box..");
		
		WebElement box = myDriver.findElement(By.xpath("//*[@id=\"droppableview\"]"));
		
		try {
			assertEquals("Dropped!", box.getText());
			test3.log(LogStatus.PASS, "Nice One!, Box Dropped in right place!");
		}catch (AssertionError j) {
			test3.log(LogStatus.FAIL, "Bad Luck! Your box was not moved or dropped in right place");
			fail();
		}finally {
			test3.log(LogStatus.INFO, "End of Test");
			report.endTest(test3);
		}	
	}
	
	@Test
	public void selectableTest() {
		ExtentTest test4 = report.startTest("Navigate to Selectable Page");
		HomePage demoHome2 = PageFactory.initElements(myDriver, HomePage.class);
		demoHome2.clickSelectableButton();
		test4.log(LogStatus.INFO, "Attempting to access selectable page");
		try {
			assertEquals("http://demoqa.com/selectable/", myDriver.getCurrentUrl());
			test4.log(LogStatus.PASS, "Accessed Selectable Page");
		}catch (AssertionError l) {
			test4.log(LogStatus.FAIL, "Could Not Access Selectable Page");
			fail();
		}finally {
			test4.log(LogStatus.INFO, "Current URL: " + myDriver.getCurrentUrl());
			report.endTest(test4);
		}
		ExtentTest test5 = report.startTest("Selecting boxes indivdually");
		Selectable select = PageFactory.initElements(myDriver, Selectable.class);
		select.clickBoxes();
		
		WebElement item7 = myDriver.findElement(By.xpath("//*[@id=\"selectable\"]/li[7]"));
		
		test5.log(LogStatus.INFO, "Attempting to select boxes");
		try { 
			assertEquals("ui-widget-content ui-corner-left ui-selectee ui-selected", item7.getAttribute("class"));
			test5.log(LogStatus.PASS, "Nice one!, Made it to last box!");
		}catch (AssertionError v) {
			test5.log(LogStatus.FAIL, "Could not select each box correctly!");
			fail();
		}finally {
			test5.log(LogStatus.INFO, "End of Test");
			report.endTest(test5);
		}
		ExtentTest test6 = report.startTest("Attempting to select all boxes");
		Selectable selectAll = PageFactory.initElements(myDriver, Selectable.class);
		selectAll.selectAll();
		test6.log(LogStatus.INFO, "Attempting to select all boxes at once");
		try { 
			assertEquals("ui-widget-content ui-corner-left ui-selectee ui-selected", item7.getAttribute("class"));
			test6.log(LogStatus.PASS, "Nice one!, Made it to last box!");
		}catch (AssertionError v) {
			test6.log(LogStatus.FAIL, "Could not select all boxes correctly!");
			fail();
		}finally {
			test6.log(LogStatus.INFO, "End of Test");
			report.endTest(test6);
		}
	}
	@Test 
	public void accordionTest() {
		ExtentTest test7 = report.startTest("Testing Accordion Page opens");
		HomePage demoHome3 = PageFactory.initElements(myDriver, HomePage.class);
		demoHome3.clickAccordionButton();
		test7.log(LogStatus.INFO, "Attempting to access accordion page");
		try {
			assertEquals("http://demoqa.com/accordion/", myDriver.getCurrentUrl());
			test7.log(LogStatus.PASS, "Accessed Accordion Page");
		}catch (AssertionError l) {
			test7.log(LogStatus.FAIL, "Could Not Access Accordion Page");
			fail();
		}finally {
			test7.log(LogStatus.INFO, "Current URL: " + myDriver.getCurrentUrl());
			report.endTest(test7);
		}
		
		ExtentTest test8 = report.startTest("Testing Accordion Elements");
		Accordion selectTabs = PageFactory.initElements(myDriver, Accordion.class);
		selectTabs.clickTabs();
		test8.log(LogStatus.INFO, "Attempting to open each tab");
		
		WebElement finalTabInfo = myDriver.findElement(By.id("ui-id-11"));
		try {
			assertEquals("ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom ui-accordion-content-active", finalTabInfo.getAttribute("class"));
			test8.log(LogStatus.PASS, "Nice One! You have Displayed all contents!");
		}catch (AssertionError z) {
			test8.log(LogStatus.FAIL, "Bad Luck! You have not displayed all contents!");
			fail();
		}finally {
			test8.log(LogStatus.INFO, "End of Accordion Test");
			report.endTest(test8);
		}
		
	}
		@Test
		public void autoCompleteTest() {
			
			ExtentTest test9 = report.startTest("Testing AutoComplete Page opens");
			HomePage demoHome4 = PageFactory.initElements(myDriver, HomePage.class);
			demoHome4.clickAutoCompleteButton();
			test9.log(LogStatus.INFO, "Attempting to access autoComplete page");
			try {
				assertEquals("http://demoqa.com/autocomplete/", myDriver.getCurrentUrl());
				test9.log(LogStatus.PASS, "Accessed AutoComplete Page");
			}catch (AssertionError m) {
				test9.log(LogStatus.FAIL, "Could Not Access AutoComplete Page");
				fail();
			}finally {
				test9.log(LogStatus.INFO, "Current URL: " + myDriver.getCurrentUrl());
				report.endTest(test9);
				
			}
			ExtentTest test10 = report.startTest("Testing AutoComplete Functions");
			AutoComplete select = PageFactory.initElements(myDriver, AutoComplete.class);
			select.selectAndSearch();
			select.selectDropDown();
			test10.log(LogStatus.INFO, "Attempting to complete AutoComplete");
			
			WebElement searchBar = myDriver.findElement(By.id("tagss"));
			
			try {
			assertEquals("BASIC", searchBar.getAttribute("value"));
			test10.log(LogStatus.PASS, "Autocomplete Successful!");
			}catch (AssertionError p) {
				test10.log(LogStatus.FAIL, "AutoComplete Unsuccessful");
				fail();
			}finally {
				test10.log(LogStatus.INFO, "Test Complete");
				report.endTest(test10);
			}
		}
		@Test
		public void datePickerTest() {
			
			ExtentTest test11 = report.startTest("Testing DatePicker Page opens");
			HomePage demoHome5 = PageFactory.initElements(myDriver, HomePage.class);
			demoHome5.clickDatePickerButton();
			test11.log(LogStatus.INFO, "Attempting to access DatePicker page");
			try {
				assertEquals("http://demoqa.com/datepicker/", myDriver.getCurrentUrl());
				test11.log(LogStatus.PASS, "Accessed DatePicker Page");
			}catch (AssertionError o) {
				test11.log(LogStatus.FAIL, "Could Not Access DatePicker Page");
				fail();
			}finally {
				test11.log(LogStatus.INFO, "Current URL: " + myDriver.getCurrentUrl());
				report.endTest(test11);
			}
			ExtentTest test12 = report.startTest("Testing DatePicker Functions");
			DatePicker datepick = PageFactory.initElements(myDriver, DatePicker.class);
			datepick.openDateSelection();
			datepick.pickAndCheckDate();
			test12.log(LogStatus.INFO, "Attempting to select date");
			
			WebElement dateBar = myDriver.findElement(By.id("datepicker1"));
			try {
				assertEquals("June 14, 2018", dateBar.getAttribute("value"));
				test12.log(LogStatus.PASS, "Found Correct Date Function Works!");
			}catch(AssertionError s) {
				test12.log(LogStatus.FAIL, "DatePicker Unsuccessful");
			}finally {
				test12.log(LogStatus.INFO, "Test Complete");
				report.endTest(test12);
			}
		}
		@Test 
		public void menuTest() {
			ExtentTest test13 = report.startTest("Testing Menu Page opens");
			HomePage demoHome6 = PageFactory.initElements(myDriver, HomePage.class);
			demoHome6.clickMenuButton();
			test13.log(LogStatus.INFO, "Attempting to access Menu page");
			try {
				assertEquals("http://demoqa.com/menu/", myDriver.getCurrentUrl());
				test13.log(LogStatus.PASS, "Accessed Menu Page");
			}catch (AssertionError o) {
				test13.log(LogStatus.FAIL, "Could Not Access Menu Page");
				fail();
			}finally {
				test13.log(LogStatus.INFO, "Current URL: " + myDriver.getCurrentUrl());
				report.endTest(test13);
			}
			ExtentTest test14 = report.startTest("Testing selections change color");
			Menu menuTask = PageFactory.initElements(myDriver, Menu.class);
			menuTask.mouseHover();	
			test14.log(LogStatus.INFO, "Testing if Menu box changes colour");
			WebElement homeBox2 = myDriver.findElement(By.xpath("//*[@id=\"navigate\"]/ul/li[1]"));
			try {
				assertEquals("rgba(255, 153, 0, 1)", homeBox2.getCssValue("background-color"));
				test14.log(LogStatus.PASS, "Menu Box Changed colour, nice one!");
			}catch (AssertionError e) {
				test14.log(LogStatus.FAIL, "Menu Box did not change colour!");
				fail();
			}finally {
				test14.log(LogStatus.INFO, "Test Complete");
				report.endTest(test14);
			}
		}
		@Test 
		public void sliderTest() {
			ExtentTest test15 = report.startTest("Testing Slider Page opens");
			HomePage demoHome7 = PageFactory.initElements(myDriver, HomePage.class);
			demoHome7.clickSliderButton();
			test15.log(LogStatus.INFO, "Attempting to access Slider page");
			try {
				assertEquals("http://demoqa.com/slider/", myDriver.getCurrentUrl());
				test15.log(LogStatus.PASS, "Accessed Slider Page");
			}catch (AssertionError o) {
				test15.log(LogStatus.FAIL, "Could Not Access Slider Page");
				fail();
			}finally {
				test15.log(LogStatus.INFO, "Current URL: " + myDriver.getCurrentUrl());
				report.endTest(test15);
			}
			ExtentTest test16 = report.startTest("Testing Slider Function");
			Slider sliderTest = PageFactory.initElements(myDriver, Slider.class);
			sliderTest.sliderPull();
			test16.log(LogStatus.INFO, "Testing Slider Function");
			WebElement amount = myDriver.findElement(By.id("amount1"));
			try {
				assertEquals("9", amount.getAttribute("value"));
				test16.log(LogStatus.PASS, "Nice one! Slider Works");
			}catch(AssertionError t) {
				test16.log(LogStatus.FAIL, "Bad Luck! Slider doesn't work");
				fail();
			}finally {
				test16.log(LogStatus.INFO, "Test Complete");
				report.endTest(test16);
			}
			
		}
	@After
	public void tearDown() {
		myDriver.close();
		report.flush();
	}

}
