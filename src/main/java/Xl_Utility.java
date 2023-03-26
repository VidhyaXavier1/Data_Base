import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xl_Utility {
	public static WebDriver driver;
 public static FileInputStream f;
 public static FileOutputStream fo;
 public static XSSFWorkbook wb;
 public static XSSFSheet sheet;
 public static XSSFRow row;
 public static XSSFCell col;
 public static CellStyle style;
 static String path =null;
  Xl_Utility(String path)
 {
	 Xl_Utility.path=path;
 }
  
  public void Open_Url(String url) 
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
  public static int getRowCount(int index) throws IOException
  {
	f=new FileInputStream(path);
	wb=new XSSFWorkbook(f);
	sheet=wb.getSheetAt(index);
	int rowcount=sheet.getLastRowNum();
    wb.close();
    f.close();
    return rowcount;
    	  
  }
  public static int getCellCount(int index,int rownum) throws IOException
  {
	f=new FileInputStream(path);
	wb=new XSSFWorkbook(f);
	sheet=wb.getSheetAt(index);
	row=sheet.getRow(rownum);
	int colcount=row.getLastCellNum();
    wb.close();
    f.close();
    return colcount;
    	  
  }
   
  public static String getCellData(int index,int rownum,int colnum) throws IOException
  {
	f=new FileInputStream(path);
	wb=new XSSFWorkbook(f);
	sheet=wb.getSheetAt(index);
	row=sheet.getRow(rownum);
	col=row.getCell(colnum);
	DataFormatter form=new DataFormatter();
	String data;
	try
	{
		data=form.formatCellValue(col);
	}
	catch(Exception e)
	{
		data="";
	}
    wb.close();
    f.close();
    return data;
      	  
  }
   
  public static void setCellData(int index,int rownum,int colnum,String data) throws IOException
  {
	f=new FileInputStream(path);
	wb=new XSSFWorkbook(f);
	sheet=wb.getSheetAt(index);
	row=sheet.getRow(rownum);
	col=row.createCell(colnum);
	col.setCellValue(data);
	fo=new FileOutputStream(path);
	wb.write(fo);
	wb.close();
    f.close();
    fo.close();
  
  }
  
  public static void fillGreenColor(int index,int rownum,int colnum) throws IOException
  {
	f=new FileInputStream(path);
	wb=new XSSFWorkbook(f);
	sheet=wb.getSheetAt(index);
	row=sheet.getRow(rownum);
	col=row.getCell(colnum);
	style=wb.createCellStyle();
	style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	col.setCellStyle(style);
	fo=new FileOutputStream(path);
    wb.write(fo); 
	wb.close();
    f.close();
    fo.close();
  }
  public static void fillRedColor(int index,int rownum,int colnum) throws IOException
  {
	f=new FileInputStream(path);
	wb=new XSSFWorkbook(f);
	sheet=wb.getSheetAt(index);
	row=sheet.getRow(rownum);
	col=row.getCell(colnum);
	style=wb.createCellStyle();
	style.setFillBackgroundColor(IndexedColors.RED.getIndex());
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	col.setCellStyle(style);
	fo=new FileOutputStream(path);
    wb.write(fo); 
	wb.close();
    f.close();
    fo.close();
  }
  
  
 
}
