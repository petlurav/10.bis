package test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilites.GetDriverf;
import Utilites.Utilities;
import page.FacebookSingIn;
import page.Restoran;

public class RestoranSearch {

	private ExtentReports extent;
	private ExtentTest myTest;
	private static String reportPaht = System.getProperty("user.dir") + "\\test-output\\Restoran-search.html";
	private WebDriver driver;
	private String baseurl;
	private Actions actions;
	private FacebookSingIn singin;
	private Restoran restorantsearch;
	private static final Logger logger = LogManager.getLogger(registration.class);

	@BeforeClass

	public void beforeClass() {

		extent = new ExtentReports(reportPaht);
		extent.loadConfig((new File(System.getProperty("user.dir") + "\\resource\\10bis-extent-config.xml")));
		// myTest=extent.startTest("");

		baseurl = "https://www.10bis.co.il/";
		driver = GetDriverf.getDriver("chrome", baseurl);
		singin = new FacebookSingIn(driver);
		restorantsearch = new Restoran(driver);
	}

	/*
	 * Prerequisite: getting into https://10bis.co.il 
	 * Given:client is in singin page
	 * When: singin through the facebook 
	 * Then: main page is open
	 * 
	 */
	@Test(priority = 1, enabled = true, description = "sing in through the facebook")
	public void SingFacebook(Method method) throws InterruptedException {
		 myTest = extent.startTest(method.getName());
		 myTest.log(LogStatus.INFO, "Starting test", "Start test");
		 logger.debug("debug it");
		 Assert.assertTrue(singin.singin("danila042", "petlurav@yahoo.com", "דמיטרי"),
				"could not login with Facebook account, check logs");
	}

	/*
	 * Prerequisite: getting into https://10bis.co.il 
	 * Given:client search restorant
	 * When: choose a branch 
	 * Then: main page is open
	 * 
	 */
	@Test(priority = 2, enabled = true, description = "main page open of the restorant")
	public void restorantseartch(Method method) throws InterruptedException {
		 myTest = extent.startTest(method.getName());
		 myTest.log(LogStatus.INFO, "Starting test", "Start test");
		 logger.debug("debug it");
		 Assert.assertTrue(restorantsearch.findrestorant("ארומה", "ארומה"), "Wrong restoran was opens");

	}
	/*
	 * Prerequisite: getting into https://10bis.co.il 
	 * Given:client choose dish When:
	 * add to the payment menu 
	 * Then: click on the payment button
	 * 
	 */

	@Test(priority = 3, enabled = true, description = "click on the dishes")
	public void adddish(Method method) throws InterruptedException {
		  myTest = extent.startTest(method.getName());
		  myTest.log(LogStatus.INFO, "Starting test", "Start test");
		  logger.debug("debug it");
		  Assert.assertTrue(restorantsearch.AddDishes("תשלום"), "is not apayment pop up");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			myTest.log(LogStatus.FAIL, "Test failed: " + result.getName());
			myTest.log(LogStatus.FAIL, "Test failed reason: " + result.getThrowable());
			myTest.log(LogStatus.FAIL, myTest.addScreenCapture(Utilities.takeScreenShot(driver)));
		} else {
			myTest.log(LogStatus.PASS, "");
			myTest.log(LogStatus.PASS, myTest.addScreenCapture(Utilities.takeScreenShot(driver)));
		}
		   myTest.log(LogStatus.INFO, "Finish test", "Finish test ");

		   extent.endTest(myTest);
		// driver.get(baseurl);
	}

	@AfterClass
	public void afterClass() {
		  extent.flush();
		  driver.quit();
		  extent.close();
	}
}
