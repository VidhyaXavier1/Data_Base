import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Data_Driven {
	public static WebDriver driver;
	
	
	 public static void Open_Url(String url) 
	 {
		 try
		 {
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			Thread.sleep(1000);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
						 
	 }
	 public  static boolean element_displayed(WebElement element)
	 {
		 boolean displayed=true;
		 try
		 {
		  displayed = element.isDisplayed();
		
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return displayed;
		 
	 }
	 public  static void Clear_Element(WebElement element)
	 {
		 element.clear();
	 }
	
   
}

	

