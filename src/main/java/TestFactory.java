import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestFactory {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void verifyNaukari() throws InterruptedException {
        driver.get("https://www.naukri.com/");

        PagefactoryModel obj = new PagefactoryModel(driver);
        obj.homeloginbtn();
        obj.enterEmail("omops92@gmail.com");
        obj.enterPassword("hpprobook4410");
        obj.clickLogin();

        String expectedTitle = "Home | Mynaukri";  // Update this if necessary
        String actualTitle = driver.getTitle();
        System.out.println("Page Title: " + actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle, "Login failed or incorrect page loaded.");
        
        Thread.sleep(4000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
