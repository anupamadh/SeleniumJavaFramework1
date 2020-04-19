package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class TestNG_Demo {
	private static WebDriver driver = null;
	public static String browserName = null;
	
@BeforeTest
	public void setUpTest() {
	PropertiesFile.getProperties();
	if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	}
@Test
	public static void googleSearch() {

		driver.get("https://google.com");
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation step by step");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);


	}
@AfterTest
	public void tearDownTest() {
		driver.close();
	//	driver.quit();
		System.out.println("Test completed successfully");
		PropertiesFile.setProperties();
	}
}
