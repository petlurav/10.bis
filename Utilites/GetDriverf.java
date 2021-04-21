package Utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class GetDriverf {

	
	

	// Method for getting WebDriver
	public static WebDriver getDriver(String browser) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("-incognito");
		
		WebDriver driver = null;

		if (browser.equals("chrome")) {
			// Set the location of the Google Chrome driver exe file by set the system
			System.setProperty("webdriver.chrome.driver", "C:\\jars\\driverch\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			// Set system property
			System.setProperty("webdriver.gecko.driver", "C:\\jars\\Firefoxdrivers\\geckodriver.exe");
			// Initialize web driver
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;}

		
		
		
		
		public static WebDriver getDriver(String browser,String baseurl) {
			WebDriver driver = null;

			if (browser.equals("chrome")) {
				// Set the location of the Google Chrome driver exe file by set the system
				System.setProperty("webdriver.chrome.driver", "C:\\jars\\driverch\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equals("firefox")) {
				// Set system property
				System.setProperty("webdriver.gecko.driver", "C:\\jars\\Firefoxdrivers\\geckodriver.exe");
				// Initialize web driver
				driver = new FirefoxDriver();
			}
			driver.get(baseurl);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			return driver;
			
			
	}

}
