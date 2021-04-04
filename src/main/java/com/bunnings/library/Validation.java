package com.bunnings.library;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bunnings.accelarator.ActionDriver;
import com.bunnings.reporting.Reporting;


public class Validation extends ActionDriver {
	
	public Validation(WebDriver incomingDriver) {
		super(incomingDriver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Validate the attribute ( for example, placeholder text) for the field taking the expected data from External Source (ConstantDetails for this example)
	 * @author Aakash Kumar
	 * @param locator
	 * @param attribute
	 * @param expectedvalue  specify the expected value from external source or file 
	 * @param locatorname
	 * @return boolean
	 * @throws IOException
	 * @throws AWTException
	 */
	public boolean validateAttribute(By locator, String attribute, String expectedvalue, String locatorname)
			throws IOException, AWTException {
		flag = false;
		try {

			String label = getAttribute(locator, attribute);

			// Validate the actual label against the Expected label from ConstantDeatils file
			
			if (label.equals(expectedvalue)) {
				Reporting.logResults(driver, "Pass", "Validate Attribute", "value is correct for: " + locatorname +" "+ attribute);
				flag = true;
			} else {
				Reporting.logResults(driver, "FAIL", "Validate Attribute",
						"value is incorrect for: " + locatorname + " " + attribute + ", Expected value is :" + expectedvalue  + " Actual value is :" + label);
				flag = false;
			}

		} catch (Exception e) {
			Reporting.logResults(driver, "FAIL", "Validate Attribute",
					"No Expected value present or Unable to locate the locator for: " + locatorname);
			flag = false;
		}
		return flag;

	}

	/**
	 * Validate the text value of an element
	 * @author Aakash Kumar
	 * @param locator
	 * @param expectedvalue  specify the expected value from external source or file 
	 * @param locatorname
	 * @return boolean
	 * @throws IOException
	 * @throws AWTException
	 */
	
	public boolean validateText(By locator, String expectedvalue, String locatorname)
			throws IOException, AWTException {
		flag = false;
		try {
			longWait();
			String actualvalue = getText(locator);

			// Validate the actual label against the Expected label from ConstantDeatils file
			
			if (actualvalue.equals(expectedvalue)) {
				Reporting.logResults(driver, "Pass", "Validate text ", "value is correct for: " + locatorname);
				flag = true;
			} else {
				Reporting.logResults(driver, "FAIL", "Validate text",
						"value is incorrect for: " + locatorname + ", Expected value is :" + expectedvalue  + " Actual value is :" + actualvalue);
				flag = false;
			}

		} catch (Exception e) {
			Reporting.logResults(driver, "FAIL", "Validate text",
					"No Expected value present or Unable to locate the locator for: " + locatorname);
			flag = false;
		}
		return flag;

	}
	
	/**
	 * Switch to a browser alert, verify its message and accept it
	 * @author Aakash Kumar
	 * @param expectedvalue  specify the expected value from external source or file 
	 * @param locatorname
	 * @return boolean
	 * @throws IOException
	 * @throws AWTException
	 */
	
	public boolean validateAlertText(String expectedvalue, String locatorname)
			throws IOException, AWTException {
		flag = false;
		try {
			// Get a handle to the open alert, prompt or confirmation
			Alert alert = driver.switchTo().alert();
			// Get the text of the alert or prompt
			String actualvalue = alert.getText();


			// Validate the Alert Text against the Expected value from ConstantDetails file
			
			if (actualvalue.equals(expectedvalue)) {
				Reporting.logResults(driver, "Pass", "Validate Alert Text ", "value is correct for: " + locatorname);
				flag = true;
			} else {
				Reporting.logResults(driver, "FAIL", "Validate Alert Text",
						"value is incorrect for: " + locatorname + ", Expected value is :" + expectedvalue  + " Actual value is :" + actualvalue);
				flag = false;
			}
			
			// And acknowledge the alert (equivalent to clicking "OK")
			alert.accept();

		} catch (Exception e) {
			Reporting.logResults(driver, "FAIL", "Validate Alert Text",
					"No Expected value present or Unable to locate the locator for: " + locatorname);
			flag = false;
		}
		return flag;
		

	}
	


}
