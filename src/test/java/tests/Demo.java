package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo {
	WebDriver driver;
	
	@BeforeMethod
	public void launchApp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}
	
	@Test
	public void getTitle() {		
		System.out.println("Title of the Web Page is: " + driver.getTitle());		
	}
	
	@Test
	public void getUrl() {
		System.out.println("URL of the Web Page is: " + driver.getCurrentUrl());
	}
	
	@AfterMethod
	public void closeApp() {
		driver.close();
	}

}
