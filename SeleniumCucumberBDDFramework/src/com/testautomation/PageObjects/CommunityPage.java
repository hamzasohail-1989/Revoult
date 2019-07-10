/**
 * 
 */
package com.testautomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testautomation.resource.SeleniumWaits;
import com.testautomation.utility.CommonFunctions;

/**
 * @author HamzaSohail
 *
 */
public class CommunityPage{
	
	private static WebDriver driver;
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(CommunityPage.class);

	//Locators for Elements in the Web Page
	By searchButton = By.xpath("//*[@id='search-button']");
	By inputSearchCriteria=By.xpath("//input[contains(@id, 'search-term')]");
	By latestTitle=By.xpath("/html/body/section/div/div[2]/div[3]/div/section/ul/li[3]/a");
	By searchAutoFill=By.xpath("//*[@id='ember6']/header/div/div/div[2]/div/div/div/div/div[3]/div/div/ul/li[1]/a");
	By title=By.cssSelector("#topic-title > div > div > h1 > a.fancy-title");
	

	CommonFunctions CommonFunctions=new CommonFunctions();
	SeleniumWaits SeleniumWaits= new SeleniumWaits();
	
	
	//Function that clicks search button inserts string and searched it
	public void clickSearchButton(String searchString)
	{	
		 CommonFunctions.switchHandler(driver,1);
		 SeleniumWaits.visibilityOfElementLocated(driver, searchButton);
		 
		 log.info("Going to click on Search button");
		 getDriver().findElement(searchButton).click();
		 getDriver().findElement(inputSearchCriteria).sendKeys(searchString);
		 
		 SeleniumWaits.waitTillTextMatches(driver,searchAutoFill,searchString);
		 log.info("Clicking on the searched String");
		 
		 getDriver().findElement(searchAutoFill).click();	
		 log.info("Searched Successfull");
	}
	
	
	//Function that verifies the heading of the Topic
	public void verifyTopicHeading(String searchString)
	{
		log.info("Verifying the Title");
		String headingTitle=getDriver().findElement(title).getText();	
		Assert.assertEquals(searchString, headingTitle, "Heading Title is not same as that of Searched String");
	}

	//Function that verifies the Shortcuts
	public void verifyShortcut(String shortcut,String ExpectatedResult){
		CommonFunctions.switchHandler(driver,1);
		SeleniumWaits.waitForPageLoadComplete(driver, 10000);
		System.out.println("Shortcut giong to use" + shortcut);
		Actions action = new Actions(driver);
		switch(shortcut) {
		  case "Home":
			  action.sendKeys("g").sendKeys("h").perform();
			  
			  log.info("I have pressed" + shortcut);
			  SeleniumWaits.waitForPageLoadComplete(driver, 10000);	  
			  SeleniumWaits.visibilityOfElementLocated(driver, latestTitle);
			  
			  log.info("Verfying tha the shortcut worked");
			  CommonFunctions.verifyPage(driver, ExpectatedResult);
			  log.info("Shortcut worked");
		    break;
		  case "Latest":
			  action.sendKeys("g").sendKeys("l").perform();
			  
			  log.info("I have pressed" + shortcut);
			  SeleniumWaits.waitForPageLoadComplete(driver, 10000);
			  SeleniumWaits.visibilityOfElementLocated(driver, searchButton);
			  
			  log.info("Verfying tha the shortcut worked");
			  CommonFunctions.verifyPage(driver, ExpectatedResult);
			  log.info("Shortcut worked");
		    break;
		}
	}
	
	
	
	// Driver get function
	public static WebDriver getDriver() 
	{
		return driver;
	}
	
	// Driver set function
	public static void setDriver(WebDriver driver) 
	{
		CommunityPage.driver = driver;
	}
	
	//constructor
	public CommunityPage(WebDriver driver)
	{
		CommunityPage.setDriver(driver);
		PageFactory.initElements(driver, this);
	}	
	
}
