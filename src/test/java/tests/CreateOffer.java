package tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testCompnents.BaseTest;

public class CreateOffer extends BaseTest {

	@Test(dataProvider = "getData")
	public void createOffer(HashMap<String, String> m) throws InterruptedException {
		loopper.goToMainMenu(m.get("menu"));
		loopper.clickOnSubCategory(m.get("category"), m.get("subCategory"));
		loopper.clickOnOfferButton(m.get("product"));
		loopper.inputQuantity(m.get("quantity"));
		loopper.inputFirstName();
		loopper.inputLastName();
		loopper.inputEmail();
		loopper.clickOnSendMyFreeQuote();

		String msg = loopper.getSuccessMsg();
		Assert.assertEquals(msg, "Quote request successful!");
		loopper.closePopUp();
	}

	@DataProvider
	public Object[][] getData() {

		HashMap<String, String> m1 = new HashMap<String, String>();
		m1.put("menu", "Clothing");
		m1.put("category", "Personalized footwear");
		m1.put("subCategory", "Flip-flops");
		m1.put("product", "Fully customizable beach flip-flops | PE sole | PVC straps");
		m1.put("quantity", "50");

		Object[][] data = { { m1 } };

		return data;

	}

}
