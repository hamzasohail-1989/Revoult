/**
 * 
 */
package com.testautomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.testautomation.resource.SeleniumWaits;
import com.testautomation.utility.CommonFunctions;

/**
 * @author HamzaSohail
 *
 */
public class HomePage {
	
	private static WebDriver driver;
	
	
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HomePage.class);

	//Locators of the Web Page
	By helpMenu = By.xpath("//*[@id='___gatsby']/div/div[2]/div/div/div[2]/div[2]/div[4]/div[1]");
	By communitySubMenu = By.xpath("//*[@id='___gatsby']/div/div[2]/div/div/div[2]/div[2]/div[4]/div[2]/div/div[1]/a");
	By helpButton=	By.xpath("//*[@id='___gatsby']/div/div[4]/div/a/div/div[2]/p");
	By UKflag =By.xpath("/html/body/div/div/div[5]/div/a/div/div[1]");
	By crossButtonFlex=By.cssSelector("svg.rvl-Icon--size-xs:nth-child(1)");
	
	CommonFunctions CommonFunctions=new CommonFunctions();
	SeleniumWaits SeleniumWaits= new SeleniumWaits();

	//This Function finds the web element in the menu and clicks it
	public void clickHelpMenu()
	{	
		log.info("Clicking Help Button");
		SeleniumWaits.visibilityOfElementLocated(driver, helpMenu);
		getDriver().findElement(helpMenu).click();
		log.info("Clicked on Help Menu");
		
	}
	
	//This Function finds the web element in the Sub menu and clicks it
	public void clickCommunitySubMenu()
	{
		log.info("Clicking Community in Sub Menu");
		SeleniumWaits.visibilityOfElementLocated(driver,communitySubMenu);
		getDriver().findElement(communitySubMenu).click();
		log.info("Clicked on Community in Sub Menu");
	}
	
	//This Function Selects Flag by scrolling down and then selecting respective flag
	public void slectCountryFlag(){
		
		Actions action = new Actions(driver);			
		SeleniumWaits.visibilityOfElementLocated(driver,crossButtonFlex);
		
		action.moveToElement(driver.findElement(crossButtonFlex)).build().perform();
		getDriver().findElement(crossButtonFlex).click();
		
		log.info("Going to select Flag of Country");
		SeleniumWaits.visibilityOfElementLocated(driver,UKflag);
		CommonFunctions.scrollToBottomOfPage(driver);
		WebElement countryFlag = getDriver().findElement(UKflag);  
		CommonFunctions.scrollIntoView(driver, countryFlag);
		countryFlag.click();		
	}
	
	// Driver get function
	public static WebDriver getDriver() 
	{
		return driver;
	}
	
	// Driver set function
	public static void setDriver(WebDriver driver) 
	{
		HomePage.driver = driver;
	}
	
	//constructor
	public HomePage(WebDriver driver)
	{
		HomePage.setDriver(driver);
		PageFactory.initElements(driver, this);
	}	

	
}
