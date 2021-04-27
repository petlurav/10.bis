package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Extra1 extends Base  {
	
	
	public Extra1(WebDriver driver) {
		super(driver);
		
	}

	public boolean error(String name) throws InterruptedException {

        click(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/header/div/div[2]/div/button[1]"));

        click(By.id("login_tab_button"));

        click(By.xpath("//*[@id='login_tab_controls']/div/form/button"));

        Thread.sleep(2000);

        clickanhold(By.xpath("//*[@id=\"login_tab_controls\"]/div/form/button"));

        String personalMsg = getText(By.cssSelector("#login_tab_controls > div > form > div.loginStyled__LoginFormFieldsWrapper-giftut-15.kcSYjz > div > div > div.FormFieldstyled__ErrorText-seonk0-3.iplsLZ"));

        if (personalMsg.contains(name))

               return true;

        else

               return false;



 }

}
