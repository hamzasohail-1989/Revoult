package com.testautomation.StepDef;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.testautomation.PageObjects.CommunityPage;
import com.testautomation.PageObjects.CountryChangePage;
import com.testautomation.PageObjects.HomePage;
import com.testautomation.listeners.ExtentReportListener;
import com.testautomation.utility.BrowserUtility;
import com.testautomation.utility.CommonFunctions;
import com.testautomation.utility.PropertiesFileReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class RevoultStepDef extends ExtentReportListener{
	
	public WebDriver driver;
	PropertiesFileReader obj= PropertiesFileReader.getInstance(); 
	CommonFunctions CommonFunctions = new CommonFunctions();
	ExtentTest logInfo=null;
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(RevoultStepDef.class);
	Properties properties=obj.getProperty();
	
	//Step definition for ""Open browser and enter url"
	@Given("^Open browser and enter url$")
	public void open_browser_and_enter_url() throws Throwable 
	{
		
		try {
			test = extent.createTest(Feature.class, "Revolut Testing Suite");							
			test=test.createNode(Scenario.class, "Search String and Verify the Search Result");						
			
			logInfo=test.createNode(new GherkinKeyword("Given"), "Open browser and enter url");
			
			driver=BrowserUtility.OpenBrowser(driver, properties.getProperty("browser.name"), properties.getProperty("browser.baseURL"), properties.getProperty("OS"));

			logInfo.pass("Opened browser and entered url");
			logInfo.addScreenCaptureFromPath(CommonFunctions.captureScreenShot(driver));			

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}		   

	}
	
	//Step definition for "Click on Help in Menu"
	@Then("^Click on Help in Menu$")
	public void click_on_help_menu() throws IOException 
	{
	try {
		logInfo=test.createNode(new GherkinKeyword("Then"), "Click on Help in Menu");
		
		new HomePage(driver).clickHelpMenu();   
		
		logInfo.pass("Help Menu Clicked");
		logInfo.addScreenCaptureFromPath(CommonFunctions.captureScreenShot(driver));
		
	}catch (AssertionError | Exception e) {
		testStepHandle("FAIL",driver,logInfo,e);			
	}		   
	}

	//Step definition for "Click on Community Sub Menu"
	@Then("Click on Community Sub Menu")
	public void click_on_Community() {
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "Click on Community Sub Menu");
			
			new HomePage(driver).clickCommunitySubMenu();   
			
			logInfo.pass("Successfully clicked on Community Sub Menu");
			logInfo.addScreenCaptureFromPath(CommonFunctions.captureScreenShot(driver));
			
		}catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}		   
	}

	//Step definition for "Click on Search and Search the topic"
	@Then("Click on Search and Search the topic {string}")
	public void test(String searchString) {
		try {
			
			logInfo=test.createNode(new GherkinKeyword("Then"), "Click on Search and Search the topic");
			new CommunityPage(driver).clickSearchButton(searchString);   
			
			logInfo.pass("Clicked on Search and Searched the topic Successfully");
			logInfo.addScreenCaptureFromPath(CommonFunctions.captureScreenShot(driver));
			
		}catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}		   
	}

	//Step definition for "Verify heading of selected topic"
	@Then("Verify heading of selected topic {string}")
	public void verify_text(String searchString) {
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "Verify heading of selected topic");
			
			new CommunityPage(driver).verifyTopicHeading(searchString);   
			
			logInfo.pass("Verified heading of selected topic");
			logInfo.addScreenCaptureFromPath(CommonFunctions.captureScreenShot(driver));
			
		}catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}		   
	}
	
	//Step definition for "Scroll to Page Bottom and Click UK Flag"
	@Then("Scroll to Page Bottom and Click UK Flag")
	public void scroll_to_Page_Bottom_and_Click_UK_Flag() throws InterruptedException {
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "Scroll to Page Bottom and Click UK Flag");
			
		new HomePage(driver).slectCountryFlag();
		
		logInfo.pass("Scrolled to Page Bottom AND selected UK Flag");
		logInfo.addScreenCaptureFromPath(CommonFunctions.captureScreenShot(driver));
		
	}catch (AssertionError | Exception e) {
		testStepHandle("FAIL",driver,logInfo,e);			
	}		   
	}
	
	//Step definition for "Verify Shortcut"
	@Then("Verify {string} {string}")
	public void verify_shortcut(String shortcut,String AssertionExpectation) throws InterruptedException {
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "Verify Shortcut");
			
			new CommunityPage(driver).verifyShortcut(shortcut,AssertionExpectation);
		
		logInfo.pass("Veirfied Shortcut");
		logInfo.addScreenCaptureFromPath(CommonFunctions.captureScreenShot(driver));
		
	}catch (AssertionError | Exception e) {
		testStepHandle("FAIL",driver,logInfo,e);			
	}		   
	}
	
	//Step definition for "Scrolled Down and Clicked on Flag"
	@Then("Scroll to USA Flag and Click on the Flag")
	public void scroll_to_USA_Flag_and_Click_on_the_Flag() {
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "Scrolled Down and Clicked on Flag");
	   
			new CountryChangePage(driver).selctFlag();	
	   
	   logInfo.pass("Scrolled Down and Clicked on Flag");
	   logInfo.addScreenCaptureFromPath(CommonFunctions.captureScreenShot(driver));
		
	}catch (AssertionError | Exception e) {
		testStepHandle("FAIL",driver,logInfo,e);			
	}		   
	}

	//Step definition for "Verifying the page"
	@Then("Verify the Page with url {string}")
	public void verify_the_Page(String url) {
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"), "Verifying the page");
	   
		new CountryChangePage(driver).checkCountryPage(url);

		   logInfo.pass("Verified the page");
		   logInfo.addScreenCaptureFromPath(CommonFunctions.captureScreenShot(driver));
			
		}catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}		   
	}
	
}