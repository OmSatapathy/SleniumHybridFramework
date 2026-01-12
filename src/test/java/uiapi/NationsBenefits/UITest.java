package uiapi.NationsBenefits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UITest {

	WebDriver driver;

	@Test
	public void openCartTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		try {
			driver.get("https://demo.opencart.com/");

			WebElement desktop = driver.findElement(By.xpath("(//a[contains(text(),'Desktops')])[1]"));

			Actions act = new Actions(driver);
			act.moveToElement(desktop).build().perform();
			driver.findElement(By.xpath("(//a[contains(text(),'Mac (1)')])[1]")).click();
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}
}
