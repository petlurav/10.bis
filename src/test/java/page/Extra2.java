package page;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Extra2 extends Base {

	public Extra2(WebDriver driver) {
		super(driver);
		
	}
	
	public void singin(String pass, String email) throws InterruptedException {

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



 }



 public void findrestorant(String text) throws InterruptedException {

        typeText(By.xpath("//*[@id=\"root\"]/div[2]/header/div[2]/div/div[4]/div/div[1]/input"), text);



        MoveToElement(By.xpath("//*[@id=\"searchResults\"]/div/a[1]"));

        Thread.sleep(2000);

        click(By.xpath("//*[@id=\"searchResults\"]/div/a[1]/div/div[2]"));

       

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

        click(By.xpath("//*[@id='menu-body-wrapper']/div[2]/aside/div/div[2]/div[1]/button"));

        String Msg = getText(By.cssSelector("#modal-content > div:nth-child(1)"));

        if (Msg.contains(name))

               return true;

        else

               return false;

 }

}
