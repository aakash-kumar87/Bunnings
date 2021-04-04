package com.bunnings.accelarator;


import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bunnings.reporting.Reporting;

public class ActionDriver {
	protected boolean flag;
	protected WebDriver driver;
	protected WebDriverWait wait;

	public ActionDriver(WebDriver incomingDriver) {
		driver = incomingDriver;
		wait = new WebDriverWait(driver, 10);
	}
	
	/**
	 * verifies the presence of element
	 * @author Aakash Kumar
	 * @param Locator
	 * @throws IOException, AWTException
	 * @return boolean
	 */
	
	public boolean isElementPresent(By locator) throws IOException, AWTException {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			driver.findElement(locator);
			return true;
		} catch (Exception e) {
			Reporting.logResults(driver, "Alert", "is element present", "unable to locate element");
			return false;
		}
		
	}
	
	/**
	 * performing the click on element
	 * @author Aakash Kumar
	 * @param Locator, locator name
	 * @throws IOException, AWTException
	 * @return boolean
	 */
	
	public boolean click(By locator, String locatorName) throws IOException, AWTException {

		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			driver.findElement(locator).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			flag = true;
			Reporting.logResults(driver, "Pass", "Verify the click element ", "succesfully clicked on " + locatorName);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Reporting.logResults(driver, "FAIL", "Verify the click Element", "Unable to click on " + locatorName +" " + locator);
			return false;
		}

	}
	
	/**
	 * performing enter command on element
	 * @author Aakash Kumar
	 * @param Locator, value, locator name
	 * @throws IOException, AWTException
	 * @return boolean
	 */
	
	public boolean enter(By locator, String value, String locatorname) throws IOException, AWTException {
		flag = false;
		try {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(value);
			Reporting.logResults(driver, "Pass", "Enter Text", "Succesfully entered text in " + locatorname);
			flag = true;

		} catch (Exception e) {
			Reporting.logResults(driver, "FAIL", "Enter text", "Unable to enter text in " + locatorname);
			return false;
		}
		return flag;

	}
	

	/**
	 * get attribute value of an element
	 * @author Aakash Kumar
	 * @param Locator, attribute name
	 * @return Attribute value as string
	 */

	public String getAttribute(By locator, String attribute) {
		return driver.findElement(locator).getAttribute(attribute);
	}
	
	/**
	 * perform wait on system
	 * @author Aakash Kumar
	 */

	public void longWait() throws InterruptedException {
		Thread.sleep(4000);
	}
	
	/**
	 * get text value of an element
	 * @author Aakash Kumar
	 * @param Locator
	 * @return text value as string
	 */
	
	public String getText(By locator) {
		String value = null;
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			value = driver.findElement(locator).getText();
			if (value == null)
				throw new NullPointerException();
			else
				return value;
	
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
