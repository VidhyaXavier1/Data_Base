import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Driven_Test extends Data_Driven
{
	@DataProvider(name="login")
	 public static String [][] getdata()
	 {
		 String logindata[][]= { 
				                 {"admin@yourstore.com","admin","valid"},
				                 {"admin@yourstore.com","adm","invalid"},
				                 {"adm@yourstore.com","admin","invalid"},
				                 {"admin@yourstore.com","adm","invalid"}
				                };
		return logindata;
		 }
	 @Test(dataProvider="login")
	  public void  login_Test(String user,String pwd,String exp)
	  {
		  Open_Url("https://admin-demo.nopcommerce.com"); 
		  Login_page lp=new Login_page(driver);
		  WebElement user_Name = Login_page.getUser_Name();
		  user_Name.clear();
		  user_Name.sendKeys(user);
		  WebElement pwds = Login_page.getPwd();
		  pwds.clear();
		  pwds.sendKeys(pwd);
		  WebElement click = Login_page.getClick_Button();
		  click.click();
		  String exp_Title="Dashboard / nopCommerce administration";
		  String act_Title=driver.getTitle();
		  if(exp.equals("valid"))
		  {
			  if(exp_Title.equals(act_Title))
			  {
				  Assert.assertTrue(true);
			  }
			  else
				  Assert.assertTrue(false);
		  }
		  
		  else if(exp.equals("invalid"))
		  {
			  if(exp_Title.equals(act_Title))
			  {
				  Assert.assertTrue(false);
			  }
			  else
				  Assert.assertTrue(true);
		  }
		  }
	 
	 @AfterClass	 	
	   public static void tear_Down() {
		   driver.close();
	   }
		  
	  }
	


