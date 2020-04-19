package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsBasicDemo {
	private static WebDriver driver = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// start reporters
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReports.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test1 = extent.createTest("Google Test Search One", "A test to validate google functionality");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		test1.log(Status.INFO,"Starting Test Case");
		driver.get("https://google.com");
		test1.pass("Navigated to google.com");
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		test1.pass("Entered text in search box");
		driver.findElement(By.xpath("//input[@name='btnK']")).sendKeys(Keys.RETURN);
		test1.pass("Pressed keyboard enter key");
		driver.close();
		driver.quit();
		test1.pass("Closed the browser");
		test1.info("Test completed");

		ExtentTest test2 = extent.createTest("Google Test Search Two", "A test to validate google functionality");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		test2.log(Status.INFO,"Starting Test Case");
		driver.get("https://google.com");
		test2.pass("Navigated to google.com");
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		test2.pass("Entered text in search box");
		driver.findElement(By.xpath("//input[@name='btnK']")).sendKeys(Keys.RETURN);
		test2.fail("Pressed keyboard enter key");
		driver.close();
		driver.quit();
		test2.pass("Closed the browser");
		test2.info("Test completed");

		// calling flush writes everything to the log file
		extent.flush();

	}

}
