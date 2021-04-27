package page;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import page.Base;

public class Mainpage extends Base {

	public Mainpage(WebDriver driver) {
		super(driver);
	}

	public void registration_popup() throws InterruptedException {
		click(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/header/div/div[2]/div/button[1]"));
	}
	public void FillUpData(String text, String text1, String phone) throws InterruptedException {
		typeText(By.id("fullName"), text);
		typeText(By.id("email"), text1);
		typeText(By.id("cellPhone"), phone);
	}
    public void ConfirmCheckbox() {
		click(By.cssSelector(" div.agreeToTermsSharedStyles__CheckBoxArea-sc-1s71y4p-2.kESwdc "));
	}
	public void SubmitButton() {
		click(By.xpath("//*[@id='register_tab_controls']/div/div[1]/form/div[2]/button"));
	}
}