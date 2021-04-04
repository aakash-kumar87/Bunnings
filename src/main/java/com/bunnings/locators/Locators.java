package com.bunnings.locators;

import org.openqa.selenium.By;

public class Locators {
	
	public static class SearchBox {
		
        //Absolute xpath 
		//public static By SEARCHBOX = By.xpath("//*[@id=\"headerMainMenu\"]/div[2]/div/div[1]/div/div/input[1]");
		
		
		//Relative xpath
		public static By SEARCHBOX = By.xpath("//input[@class='search-container_term header_bottom_content_toggle-tabindex ui-autocomplete-input']");
		
		public static By SEARCHCLICK = By.xpath("//button[@class='search-container_btn-submit']");
	
		public static By SEARCHRESULT = By.xpath("//h1[@class='responsive-search-title']");
		
		
	}

}
