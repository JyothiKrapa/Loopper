package webPages;

import java.util.List;

import org.openqa.selenium.By;
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

//	@FindBy(xpath = "//div[@class='loopper_main_menu_div_container ']/div[4]/span")
//	WebElement clothing;

	@FindBy(css = ".webshop_store_article_panel_image_container div img")
	List<WebElement> products;

	@FindBy(xpath = "//div/span[@class='loopper_button article_offer_btn']")
	List<WebElement> offer;

	@FindBy(xpath = "//span[@id='moq_offer_val']//following-sibling::input")
	WebElement quantity;

	@FindBy(css = "input[placeholder='First name *']")
	WebElement firstName;

	@FindBy(css = "input[placeholder='Last name *']")
	WebElement lastName;

	@FindBy(css = "input[type='email']")
	WebElement email;

	@FindBy(xpath = "//span[text()='Send my free quote']")
	WebElement sendMyFreeQuote;

	@FindBy(xpath = "//h3[text()='Quote request successful!']")
	WebElement successMsg;

	@FindBy(id = "popupCancel")
	WebElement closePopUp;

	public void closePopUp() {
		closePopUp.click();
	}

	public String getSuccessMsg() {
		return successMsg.getText();
	}

	public void inputQuantity(String qty) throws InterruptedException {
		Thread.sleep(3000);
		quantity.sendKeys(qty);
	}

	public void inputFirstName() {
		firstName.sendKeys("Jyothi");
	}

	public void inputLastName() {
		lastName.sendKeys("Krapa");
	}

	public void inputEmail() {
		email.sendKeys("Test123@gmail.com");
	}

	public void clickOnSendMyFreeQuote() {
		sendMyFreeQuote.click();
	}

	public void clickOnOfferButton(String productName) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getDomAttribute("title").equalsIgnoreCase(productName)) {
				offer.get(i).click();
				break;
			}
		}
	}

	public void clickOnSubCategory(String category, String subCategory) {
		String element = "//a[@title='" + category
				+ "']/parent::div[@class='menu-row-block']/div[@class='menu-row-subtitle']/a[@title='" + subCategory
				+ "']";
		WebElement baseballCaps = driver.findElement(By.xpath(element));
		baseballCaps.click();
	}

	public void goToMainMenu(String name) {
		WebElement menu = driver.findElement(By.xpath("//span[normalize-space()='" + name + "']"));
		Actions a = new Actions(driver);
		a.moveToElement(menu).build().perform();
	}

}
