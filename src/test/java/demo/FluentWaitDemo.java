package demo;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo {
	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		test();
	}

	public static void test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Abcd");
		driver.findElement(By.xpath("//input[@name='btnK']")).sendKeys(Keys.RETURN);
		//driver.findElement(By.linkText("Nurture Development: ABCD Training and Resources")).click();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				//this means that it will check for the element
				//on the web page at every 5 seconds for the maximum time of 30 seconds.
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
			//	WebElement linkElement = driver.findElement(By.xpath("//h3[contains(text(),'Nurture Development: ABCD Training and Resources')]"));
				WebElement linkElement = driver.findElement(By.linkText("Nurture Development: ABCD Training and Resources"));
				
				if (linkElement.isEnabled()) {
					System.out.println("Element found");
				}
				return linkElement;
			}
		});
		
		element.click();
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}
