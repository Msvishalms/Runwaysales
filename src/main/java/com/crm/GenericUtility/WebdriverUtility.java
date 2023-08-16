package com.crm.GenericUtility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	/**
	 * This method is used to maximize browser
	 * @author Admin
	 * @param driver
	 */
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to wait for page load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * This method is used to wait until element to be visible 
	 * @param element
	 * @param driver
	 */
	public void waitUntillElement(WebElement element, WebDriver driver, int sec)
	{
		WebDriverWait wait = new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to handle drop-down using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method is used to handle drop-down using value
	 * @param element
	 * @param value
	 */
	public void select(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/** 
	 * This method is used to handle drop-down using text
	 * @param text
	 * @param element
	 */
	public void select(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method is used to perform mouse-hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	
	/**
	 * This method is used to perform drag and drop action
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dst)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst).click().perform();
	}
	
	/**
	 * This method is used to perform double click action on web page
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform right click on web page
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform right click on element 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform Press enter key
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * This method will perform Press enter key
	 * @param driver
	 * @throws Throwable
	 */
	public void enterKey(WebDriver driver) throws Throwable
	{
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method will perform release key
	 * @param driver
	 * @throws Throwable
	 */
	public void enterRelease(WebDriver driver) throws Throwable
	{
		Robot rb=new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method will switch the frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will switch the frame based on nameOrId
	 * @param driver
	 * @param nameOrID
	 */
	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	
	/**
	 * This method will switch the frame based on address 
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}

	/**
	 * This method will perform 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToWindow(WebDriver driver, String partialTitle)
	{
		//step1: use to get-window-handles to capture all window id's 
		Set<String> windows = driver.getWindowHandles();
		
		//step2: iterate through windows 
		Iterator<String> it = windows.iterator();
		
		//step3: check whether there is next window 
		while(it.hasNext())
		{
			//ste4: capture current window id 
			String winID = it.next();
		
			//step5: switch to current window and capture title
			String currentWinTitle = driver.switchTo().window(winID).getTitle();
			
			//step6:check whether current window is expected
			if(currentWinTitle.contains(partialTitle))
			{
				break;
			}
		}
	}
	
	public static String getScreenShot(WebDriver driver, String screenShotName) throws Throwable 
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\screenshot\\"+screenShotName+".png";
		File dst = new File(path);
		FileUtils.copyFile(src,dst);
		return path;
	}
	
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)","");
	}
	
	public void scrollBarAction (WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		jse.executeScript("window.scrolllBy(0,"+y+")",element);
	}
}

