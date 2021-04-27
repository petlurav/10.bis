package test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilites.GetDriverf;
import Utilites.Utilities;
import page.Mainpage;
import page.Restoran;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class registration {

	private ExtentReports extent;
	private ExtentTest myTest;
	private static String reportPaht = System.getProperty("user.dir") + "\\test-output\\registration.html";
	private WebDriver driver;
	private String baseurl;
	private Actions actions;
	private Mainpage main;
	private static final Logger logger = LogManager.getLogger(registration.class);

	@BeforeClass
	public void beforeClass() {
        extent = new ExtentReports(reportPaht);
		extent.loadConfig((new File(System.getProperty("user.dir") + "\\resource\\10bis-extent-config.xml")));
		// myTest=extent.startTest("");
		baseurl = "https://www.10bis.co.il/";
		driver = GetDriverf.getDriver("chrome", baseurl);
		main = new Mainpage(driver);

	}
	/*
	 * Prerequisite: getting into https://www.10bis.com/
	 * Given: Client is in site
	 * When: click register link 
	 * Then: Getting into Registration page
	 */

	@Test(priority = 1, enabled = true, description = "open register pop up")
	public void goregister(Method method) throws InterruptedException {
		myTest = extent.startTest(method.getName());
		myTest.log(LogStatus.INFO, "Starting test", "Start test");
		logger.debug("debug it");
		main.registration_popup();

	}
	/*
	 * Prerequisite: getting into https://10bis.co.il, click Registration button
	 * Given: client is in registration page 
	 * When: fill registration details Then:
	 * details are being saved
	 */

	@Test(priority = 2, enabled = true, description = "insert data in all fields")
	public void data(Method method) throws InterruptedException {
		 myTest = extent.startTest(method.getName());
		 myTest.log(LogStatus.INFO, "Starting test", "Start test");
		 logger.debug("debug it");
		main.FillUpData("דמיטרי חיטרין", "dmitry@dmitry.com", "0544535753");

	}
	/*  Prerequisite: getting into https://10bis.co.il, click Registration button
	 * 		Given: client is in registration page
	 * 		When: mark checkbox agreeing  terms
	 *  	Then: agreeing  terms was accept
	 */
	@Test(priority = 3, enabled = true, description = "condition confirm checkbox")
	public void confirm_checkbox(Method method) throws InterruptedException {
		myTest = extent.startTest(method.getName());
		myTest.log(LogStatus.INFO, "Starting test", "Start test");
		main.ConfirmCheckbox();
	}
	/*  Prerequisite: getting into https://10bis.co.il, click Registration button
	 * 		Given: client is in registration page
	 * 		When: click on the submit button
	 *  	Then: user get singin
	 */

	@Test(priority = 4, enabled = true, description = "submit button")
	public void Submit(Method method) throws InterruptedException {
		myTest = extent.startTest(method.getName());
		myTest.log(LogStatus.INFO, "Starting test", "Start test");
		main.SubmitButton();
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
		// driver.quit();
		extent.close();
	}
}
