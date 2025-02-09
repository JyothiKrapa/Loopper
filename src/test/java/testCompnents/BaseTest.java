package testCompnents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import webPages.Loopper;

public class BaseTest {

	public WebDriver driver;
	public Loopper loopper;

	public WebDriver initializeDriver() throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Admin\\Downloads\\Selenium Java\\Loopper\\src\\test\\java\\resources\\Global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}

	@BeforeMethod(alwaysRun = true)
	public void launchApp() throws IOException {
		initializeDriver();
		driver.get("https://admin:bitapps@staging.loopper.com/");
		loopper = new Loopper(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
