package testng;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {

	WebDriver driver;

	 @Test(priority = 1)
	public void launch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("TV");
		driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"))
				.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

	}

//	@Test(priority = 2)
	public void verifyIteams() {

		String firstWord = null;
		List<WebElement> allEle = driver.findElements(By.cssSelector(".RG5Slk"));

		Set<String> set = new HashSet<>();
		for (WebElement ele : allEle) {

			String indivisulItem = ele.getText().toString();
			firstWord = indivisulItem.split("\\s+")[0];

			if (!firstWord.isEmpty()) {

				set.add(firstWord);
			}

		}

		for (String ele : set) {
			System.out.println(ele);
		}
	}

//	@Test(priority = 3)
	public void findPrice() {
		List<WebElement> allprice = driver.findElements(By.xpath("//div[@class='hZ3P6w DeU9vF']"));
		Set<String> uniPrice = new HashSet<>();

		for (WebElement price : allprice) {
			String singleprice = price.getText();

			uniPrice.add(singleprice);

		}
		System.out.print(uniPrice);
	}

	@Test(dependsOnMethods = {"launch"} )
	public void findNumberofIteams() {

		 String text =driver.findElement(By.xpath("//span[@class='_Omnvo']")).getText().toString();


		// Extract number after "of"
		String totalItemsStr = text.split("of")[1].replaceAll("[^0-9]", "");

		int totalItems = Integer.parseInt(totalItemsStr);

		System.out.println(totalItems);

	}

}
