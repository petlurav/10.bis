package page;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Restoran extends Base {

	public Restoran(WebDriver driver) {
		super(driver);
	}

	public boolean findrestorant(String text, String name) throws InterruptedException {
		typeText(By.xpath("//*[@id=\"root\"]/div[2]/header/div[2]/div/div[4]/div/div[1]/input"), text);

		MoveToElement(By.xpath("//*[@id=\"searchResults\"]/div/a[1]"));
		Thread.sleep(2000);
		click(By.xpath("//*[@id=\"searchResults\"]/div/a[1]/div/div[2]"));
		String resname = getText(By.xpath("// *[@id=\"root\"]/div[2]/div[1]/section/header/div/div[2]/div[1]/h1"));
		if (resname.contains(name))
			return true;
		else
			return false;

	}

	public boolean AddDishes(String name) throws InterruptedException {
		String baseHandle = driver.getWindowHandle();
		click(By.id("dishName_2270438_0"));
		Thread.sleep(2000);
		Set<String> handels = driver.getWindowHandles();
		for (String h : handels) {
			if (!h.equals(baseHandle))
				driver.switchTo().window(h);
		}
		click(By.xpath("//*[@id='modals']/div/div/div/div/div/div[4]/div/button"));
		click(By.id("dishDescription_2238290_0"));
		Set<String> handels1 = driver.getWindowHandles();
		for (String w : handels) {
			if (!w.equals(baseHandle))
				driver.switchTo().window(w);
		}
		click(By.xpath("//*[@id='modals']/div/div/div/div/div/div[4]/div/button"));
		click(By.xpath("//*[@id='menu-body-wrapper']/div[2]/aside/div/div[2]/div[1]/button"));
		Set<String> handels2 = driver.getWindowHandles();
		for (String p : handels) {
			if (!p.equals(baseHandle))
				driver.switchTo().window(p);
		}

		String personalMsg = getText(By.cssSelector("#modal-title"));
		if (personalMsg.contains(name))
			return true;
		else
			return false;

	}

}
