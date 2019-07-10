/**
 * 
 */
package com.testautomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.testautomation.resource.SeleniumWaits;
import com.testautomation.utility.CommonFunctions;

/**
 * @author HamzaSohail
 *
 */
public class CountryChangePage {
	
	private static WebDriver driver;
	
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(CountryChangePage.class);

	//Locators of Web Page
	By USAFlag = By.xpath("/html/body/div/div/div[4]/div/div[2]/div[2]/div[2]/div[4]/div[2]/div");
    By helpButton=	By.xpath("//*[@id='___gatsby']/div/div[4]/div/a/div/div[2]/p");
	
	CommonFunctions CommonFunctions=new CommonFunctions();
	SeleniumWaits SeleniumWaits= new SeleniumWaits();

	
	//Function to Scroll to Bottom of the Page and Select the Flag 
	public void selctFlag()
	{	
		CommonFunctions.scrollToBottomOfPage(driver);
		SeleniumWaits.visibilityOfElementLocated(driver,USAFlag);
		
		WebElement countryFlag = getDriver().findElement(USAFlag);  
		CommonFunctions.scrollIntoView(driver, countryFlag);
		log.info("Clicking the Required Country Flag");
		countryFlag.click();
	}
	
	//Function that Verifies the Country/Language is selected
	public void checkCountryPage(String url)
	{
		log.info("Verifying Help Button");
		SeleniumWaits.visibilityOfElementLocated(driver,helpButton);
		
		log.info("Going to Verifying Page Url");
		CommonFunctions.verifyPage(driver, url);	
	}
	
	// Driver get function
	public static WebDriver getDriver() 
	{
		return driver;
	}
	
	// Driver set function
	public static void setDriver(WebDriver driver) 
	{
		CountryChangePage.driver = driver;
	}
	
	//constructor
	public CountryChangePage(WebDriver driver)
	{
		CountryChangePage.setDriver(driver);
		PageFactory.initElements(driver, this);
	}	
		
}
