/**
 * 
 */
package com.testautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * @author HamzaSohail
 *
 */
public class CommonFunctions {
	
	PropertiesFileReader obj = PropertiesFileReader.getInstance();
	private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(CommonFunctions.class);

	//Function takes and saves ScreenShot
	public static String captureScreenShot(WebDriver driver) throws IOException {
			TakesScreenshot screen = (TakesScreenshot) driver;
			File src = screen.getScreenshotAs(OutputType.FILE);
			String dest = "./Reports/ScreenShots/" + getcurrentdateandtime() + ".jpeg";
			File target = new File(dest);
			FileUtils.copyFile(src, target);
			return dest;
		}
		
	//Function to return current time and date
	public static String getcurrentdateandtime() {
			String str = null;
			try {
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
				Date date = new Date();
				str = dateFormat.format(date);
				str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
			} catch (Exception e) {
			}
			return str;
		}
		
	//Function to switch handler to the respective Tab
	public void switchHandler(WebDriver driver,int index){		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(index));
	}
	
	//Function to verify the Page URL
	public void verifyPage(WebDriver driver,String url)
	{		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String currentUrl = driver.getCurrentUrl();
		log.info("Current url"+currentUrl);	
		Assert.assertEquals(currentUrl, url, "Url is not that is expected" );
	}

	//Function to Scroll to Bottom of the Page
	public void scrollToBottomOfPage(WebDriver driver){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	//Function to Scroll to view
	public void scrollIntoView(WebDriver driver,WebElement element){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
	}
}