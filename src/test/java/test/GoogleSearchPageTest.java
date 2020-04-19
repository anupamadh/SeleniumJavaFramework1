package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest {
	private static WebDriver driver = null;
	public static void main(String[] args) {
		googleSearchTest();
	}
public static void googleSearchTest() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://google.com");
	GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
	searchPageObj.setTextInSearchBox("Automation Step by Step");
	searchPageObj.clickSearchButton();
	driver.close();
}
}
