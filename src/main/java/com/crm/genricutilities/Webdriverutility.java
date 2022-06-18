package com.crm.genricutilities;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;
import com.google.common.io.Files;

public class Webdriverutility
{
/**
 * it will wait for 10 seconds till the page gets load.
 * @param driver
 */
	public void WaitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * it will wait for JS Element.
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
	/**
	 * it will check for the element in the GUI for polling time of 500ms.
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClikable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * it will check for the title in the GUI for polling time of 500ms
	 * @param driver
	 * @param title
	 */
	public void waitForTitlecontains(WebDriver driver, String title )
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * here we can change the polling time from default 500ms to any polling time
	 * @param driver
	 * @param pollingTime
	 * @param element
	 */
	public void waitForElementToCustomer(WebDriver driver,int pollingTime,WebElement element)
	{
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * we are giving custom timeout
	 * @param element
	 * @throws InterruptedException 
	 */
	public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count=0;
	   while(count<10)
	   {
		try {
			element.click();
		}catch(Exception e) {
			Thread.sleep(1000);
			count++;
		}
	}
	}
	/**
	 * used to switch from one window to another window
	 * @param driver

	 * @param partialWindow
	 */
public void switchToWindow(WebDriver driver,String partialWindow)
{
Set<String> set = driver.getWindowHandles();
Iterator<String> it = set.iterator();
while(it.hasNext())
{
	String wTle = it.next();
	driver.switchTo().window(wTle);
	String currentwindow = driver.getTitle();
	if(currentwindow.contains(partialWindow))
	{
		break;
	}
}
}
/**
 * switch from one frame to another frame by using index
 * @param driver
 * @param index
 */
public void switchToFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}
/**
 * switch from one frame to another frame by using id_attribute
 * @param driver
 * @param id_attribute
 */
public void switchToFrame(WebDriver driver,String id_attribute)
{
	driver.switchTo().frame(id_attribute);
}
/**
 * switch from one frame to another frame by using absolute_path
 * @param driver
 * @param element
 */
public void switchToFrame(WebDriver driver,WebElement element )
{
	driver.switchTo().frame(element);
}
/**
 * its used to switch back from one child frame to parent frame
 * @param driver
 */
public void switchBackToParentFrame(WebDriver driver)
{
	driver.switchTo().defaultContent();
}
/**
 * its used to switch to alert pop up and accept
 * @param driver
 */
public void switchToAlertPopupAndAccept(WebDriver driver)
{
driver.switchTo().alert().accept();
}
/**
 * its used to switch to alert pop up and dismiss
 * @param driver
 */
public void switchToAlertPopupAndDismiss(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/**
 * its used to switch to select dropdown by using index
 * @param element
 * @param index
 */
public void selectDropDown(WebElement element,int index)
{
	Select sel=new Select(element);
	sel.selectByIndex(index);
}
/**
 * its used to switch to select dropdown by using value
 * @param element
 * @param value
 */
public void selectDropDown(WebElement element,String value)
{
	Select sel=new Select(element);
	sel.selectByValue(value);
}
/**
 * its used to switch to select dropdown by visible_text
 * @param element
 * @param visible_text
 */
public void selectDropDownVtext(WebElement element,String visible_text)
{
	Select sel=new Select(element);
	sel.selectByVisibleText(visible_text);
}
/**
 * its used to mouse over an element
 * @param driver
 * @param element
 */
public void mouseOverAnElement(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}
/**
 * it is used to right click on element
 * @param driver
 * @param element
 */
public void rightClickOnElement(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.contextClick(element).perform();
}
/**
 * it is used to click on enter button using keyboard actions 
 * @param driver
 */
public void clickOnEnterButton(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.sendKeys(Keys.ENTER).perform();
}
/**
 * it is used to take screenshot
 * @param driver
 * @param screenShotName
 * @throws IOException
 */
public void takeScreenShot(WebDriver driver,String screenShotName) throws IOException
{
	TakesScreenshot takesscreenshot=(TakesScreenshot)driver;
	File src = takesscreenshot.getScreenshotAs(OutputType.FILE);
	File dst = new File(".\\screenshot/"+screenShotName+".PNG");
	Files.copy(src, dst);
	
}
/**
 * it is used to perform scrollBar actions
 * @param driver
 */
public void scrollBarAction(WebDriver driver)
{
	JavascriptExecutor javascript = (JavascriptExecutor)driver;
	javascript.executeScript("window,scrollBy(0,500)");
	
}
}

	

			
		
					
			
