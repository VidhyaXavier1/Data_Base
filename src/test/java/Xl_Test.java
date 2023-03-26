import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Xl_Test extends Xl_Utility {
	

	Xl_Test(String path) {
		super(path);
		
	}



	Xl_Utility x ;
	
	@DataProvider(name="login")
	 public String [][] getdata() throws IOException
	 {
		String path=".\\src\\main\\resources\\data_Files\\login.xlsx";
		x=new Xl_Utility(path);
		int rowCount = Xl_Utility.getRowCount(0);
		int cellCount = Xl_Utility.getCellCount(0, 1);
		String logindata [][] =new String[rowCount][cellCount];
		for(int r=1;r<=rowCount;r++)
		{
			for(int c=0;c<cellCount;c++)
			{
				logindata[r-1][c]= Xl_Utility.getCellData(0, r, c);
				
			}
		}
		
		return logindata;
		
	
	
}
	
	@Test(dataProvider="login")
	 public void  login_Test(String user,String pwd,String exp) throws InterruptedException
	  {
		
		x.Open_Url("https://admin-demo.nopcommerce.com");
		
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
	 
	 
}