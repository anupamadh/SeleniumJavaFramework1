package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessChromeDemo {
	static WebDriver driver = null;
	public static void main(String[] args) {
		test();
	}
	public static void test() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size =2560,1600");
		driver = new ChromeDriver(options);
		
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Abcd");
		driver.findElement(By.xpath("//input[@name='btnK']")).sendKeys(Keys.RETURN);
		driver.close();
		driver.quit();
		System.out.println("Completed");
	}

}
