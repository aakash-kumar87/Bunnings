package com.bunnings.accelarator;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseDriverUtil {
	public static ReadProperties rp = new ReadProperties();
	public static String QA = rp.readProperties().getProperty("QA");
	private static Logger logger = Logger.getLogger(BaseDriverUtil.class.getName());
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	//To identify what is the OS of the system and select the drivers(Mac or Windows) based on that
	public static String SystemOS = System.getProperty("os.name").toLowerCase();
	public static String MacChromeDriverPath = "/Drivers/DriversForMac/Chrome/chromedriver" ;
	public static String WinChromeDriverPath = "/Drivers/DriversForWindows/Chrome/chromedriver.exe" ;
	

	/**
	 * Launches the browser based on the given values in the app.properties
	 * 
	 * This method will launch the browser and URL based on the values provided in
	 * the properties file
	 * 
	 * @param environment specify "chrome" or "ie"
	 * @param platform specify windows
	 * @param url      specify the url of AUT (application under test)
	 * @author Aakash Kumar
	 * @return
	 * @throws Exception
	 */
	
	@BeforeTest(alwaysRun = true)
	@Parameters(value = {  "environment", "platform", "url" })
	public synchronized WebDriver launchBrowser(@Optional("blank") String environment, @Optional("windows") String platform, @Optional("url") String url) {
		rp = new ReadProperties();

		if (environment.equals("blank")) {
			environment = rp.readProperties().getProperty("browser");
		}
		
		if (environment.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/Drivers/DriversForWindows/Firefox/geckodriver.exe");			
			FirefoxOptions firefoxOptions = new FirefoxOptions();	
		    firefoxOptions.setCapability("marionette", true);	    
		    driver = new FirefoxDriver(firefoxOptions);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			logger.info("Instance of " + environment + "Browser succesfully launched");
			 switch (url) {
				case "QA": 
				    launchUrl(QA, driver);
				}
			return driver;
		}

		if (environment.equalsIgnoreCase("chrome")) {
			if(SystemOS.contains("mac")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + MacChromeDriverPath);
			}
			if (SystemOS.contains("win")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + WinChromeDriverPath);
			}
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			logger.info("Instance of " + environment + "Browser succesfully launched");
			
			switch(url) {
			  case "QA": 
			    launchUrl(QA, driver);
			}
			return driver;
		}
		return null;
		}
		
	
			public static void launchUrl(String url, WebDriver driver) {

				try {
					driver.get(url);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				} catch (NullPointerException e) {
					e.getMessage();

				}
			}
			
			
			/**
			 * Close the Browser
			 * 
			 * @throws InterruptedException
			 */

			@AfterClass(alwaysRun = false)
			public void closeBrowser() {

				if (driver != null) {
					driver.quit();
				}
			}
	

}
