import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
/**		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();*/
		driver.get("https://google.com");
		WebElement textBox = driver.findElement(By.xpath("//input[@name='q']"));
		textBox.sendKeys("Automation step by step");
		textBox.findElement(By.xpath("//input[@name='btnK']")).click();
		textBox.findElement(By.xpath("//input[@name='btnK']")).sendKeys(Keys.RETURN);
	//	List<WebElement> listOfInputElements =driver.findElements(By.xpath("//input"));
	//	int count = listOfInputElements.size();
	//	System.out.println("Count of input elements =" + count);
		driver.close();
		driver.quit();
	}

}
