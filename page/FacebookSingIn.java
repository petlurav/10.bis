package page;

import org.openqa.selenium.WebDriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookSingIn extends Base {

	public FacebookSingIn(WebDriver driver) {
		super(driver);

	}

	public boolean singin(String pass, String email, String name) throws InterruptedException {
		String baseHandle = driver.getWindowHandle();
		click(By.cssSelector("#root > div:nth-child(2) >  div button:nth-child(3)"));
		click(By.xpath("//*[@id=\"login_tab_controls\"]/div/button"));
		Thread.sleep(1000);
		Set<String> handels = driver.getWindowHandles();
		for (String h : handels) {
			if (!h.equals(baseHandle))
			driver.switchTo().window(h);
		}
		typeText(By.cssSelector("#email"), email);
		typeText(By.cssSelector("#pass"), pass);
		click(By.cssSelector("#loginbutton"));
		Thread.sleep(3000);
		driver.switchTo().window(baseHandle);
		click(By.xpath("//*[@id=\"login_tab_controls\"]/div/button"));
		String personalMsg = getText(By.cssSelector(".styled__PrimaryText-zzhidz-4.cfoTPh"));
		if (personalMsg.contains(name))
			return true;
		else
			return false;

	}

}
