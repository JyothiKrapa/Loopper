package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import testCompnents.BaseTest;
import webPages.Loopper;

public class CreateOffer extends BaseTest {

	@Test
	public void createOffer() throws InterruptedException {
		WebElement clothing = driver
				.findElement(By.xpath("//div[@class='loopper_main_menu_div_container ']/div[4]/span"));

		Actions a = new Actions(driver);
		a.moveToElement(clothing).build().perform();

		WebElement baseballCaps = driver
				.findElement(By.xpath("//div[@class='menu-row-subtitle']/a[@title='Baseball caps']"));
		baseballCaps.click();
		List<WebElement> products = driver
				.findElements(By.cssSelector(".webshop_store_article_panel_image_container div img"));
		List<WebElement> offer = driver.findElements(By.xpath("//div/span[@class='loopper_button article_offer_btn']"));

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getDomAttribute("title").equalsIgnoreCase("Classic cap | Cotton | 5 panels")) {
				offer.get(i).click();
				break;
			}
		}

		WebElement quantity = driver.findElement(By.xpath("//span[@id='moq_offer_val']//following-sibling::input"));
		WebElement firstName = driver.findElement(By.cssSelector("input[placeholder='First name *']"));
		WebElement lastName = driver.findElement(By.cssSelector("input[placeholder='Last name *']"));
		WebElement email = driver.findElement(By.cssSelector("input[type='email']"));
		WebElement sendMyFreeQuote = driver.findElement(By.xpath("//span[text()='Send my free quote']"));

		quantity.sendKeys("30");
		firstName.sendKeys("Jyothi");
		lastName.sendKeys("Krapa");
		email.sendKeys("Test123@gmail.com");
		sendMyFreeQuote.click();

		WebElement successMsg = driver.findElement(By.xpath("//h3[text()='Quote request successful!']"));
		WebElement closePopUp = driver.findElement(By.id("popupCancel"));

		Assert.assertEquals(successMsg.getText(), "Quote request successful!");
		closePopUp.click();

	}

}
