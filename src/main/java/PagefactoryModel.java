import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PagefactoryModel {

	WebDriver driver;
	
	@FindBy(xpath="//a[@id='login_Layer']")
	WebElement homelogin;
	
	
	@FindBy(xpath="//input[@placeholder='Enter your active Email ID / Username']")
	WebElement emailField;
	
	@FindBy(xpath ="//input[@placeholder='Enter your password']")
	WebElement passwordField;
	
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loginButton;
	
	
	public PagefactoryModel(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void homeloginbtn() {
		homelogin.click();
	}
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
}
