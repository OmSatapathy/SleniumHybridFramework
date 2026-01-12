package uiapi.NationsBenefits;

import java.time.Duration;                              

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
  class Testexcelrunner {
	WebDriver driver;
	
	 @BeforeMethod
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	    }
	 @Test(dataProvider = "readData", dataProviderClass = ExcelRead.class)
	    public void readFiledata(String username, String password) {
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//input[@name='username']"))));
	        
	        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
	        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	        driver.findElement(By.xpath("//button[@type='submit']")).click(); // Clicking login button
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

}
