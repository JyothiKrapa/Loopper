package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loopper {
	
	WebDriver driver;
	
	public Loopper(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//div[@class='loopper_main_menu_div_container ']/div[4]/span")
	WebElement clothing;
	
	public void goToClothing() {
		Actions a = new Actions(driver);
		a.moveToElement(clothing).build().perform();
	}

}
