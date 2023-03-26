import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {

	private static WebDriver driver;
	 
	 public Login_page(WebDriver driver)
	 {
	     this.driver = driver;
	     PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(id="Email")
	 private static WebElement user_Name;

	public static WebElement getUser_Name() {
		return user_Name;
	}

	
	
	 @FindBy(id="Password")
	 private static WebElement pwd;

	public static WebElement getPwd() {
		return pwd;
	}

	
	 @FindBy(xpath="//button[text()='Log in']")
	 private static WebElement click_Button;

	public static WebElement getClick_Button() {
		return click_Button;
	}

	 

}
