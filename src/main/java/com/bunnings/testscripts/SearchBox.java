package com.bunnings.testscripts;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.bunnings.accelarator.BaseDriverUtil;
import com.bunnings.accelarator.ConstantDetails;
import com.bunnings.library.Validation;
import com.bunnings.locators.Locators;

public class SearchBox extends BaseDriverUtil {

	
	// Test Case 1
	@Test()
	public void verifySearchBox() throws IOException, InterruptedException, AWTException, NullPointerException {
		Validation Verify = new Validation(driver);
		
		// validate the presence of the search box and make sure the placeholder text is correct
		
		
		Verify.isElementPresent(Locators.SearchBox.SEARCHBOX);
		  
		Verify.validateAttribute(Locators.SearchBox.SEARCHBOX, "placeholder",ConstantDetails.SearchPlaceholderText, "Home Page > Search Box");
	}
	
	// Test Case 2
	@Test()
	public void verifySearchNoText() throws IOException, InterruptedException, AWTException, NullPointerException {
		Validation Verify = new Validation(driver);
		  
		Verify.enter(Locators.SearchBox.SEARCHBOX, " " , "Home Page > Search Box"); 
		
		Verify.click(Locators.SearchBox.SEARCHCLICK, "Search Box > Magnifying glass");
		
		Verify.validateAlertText(ConstantDetails.SearchAlertText, "No Search Keywords");
	    
     }
	
	//Test Case 3
	@Test()
	public void verifySearchInCorrectText() throws IOException, InterruptedException, AWTException, NullPointerException {
		Validation Verify = new Validation(driver);
		 
		String SearchText="asd";
		Verify.enter(Locators.SearchBox.SEARCHBOX, SearchText , "Home Page > Search Box"); 
		
		Verify.click(Locators.SearchBox.SEARCHCLICK, "Search Box > Magnifying glass");
	
		Verify.validateText(Locators.SearchBox.SEARCHRESULT, "0 results for "+ SearchText, "Results Text");
	    
     }
	
	//Test Case 4
	@Test()
	public void verifySearchCorrectText() throws IOException, InterruptedException, AWTException, NullPointerException {
		Validation Verify = new Validation(driver);
		 
		String SearchText="pots";
		Verify.enter(Locators.SearchBox.SEARCHBOX, SearchText , "Home Page > Search Box"); 
		
		Verify.click(Locators.SearchBox.SEARCHCLICK, "Search Box > Magnifying glass");
	
		Verify.validateText(Locators.SearchBox.SEARCHRESULT, "2158 results for "+ SearchText, "Results Text");
	    
     }
	
	
	
	
}
