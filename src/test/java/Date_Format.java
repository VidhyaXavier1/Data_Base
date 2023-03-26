import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Date_Format {

	@Test
	public void Date_for() throws IOException
	{
		XSSFWorkbook wb=new XSSFWorkbook();
		
		XSSFSheet sheet=wb.createSheet("date");
	//	XSSFRow row=sheet.createRow(1);
	//	XSSFCell cell=row.createCell(0);
	//	cell.setCellValue(new Date());
		CreationHelper ch=wb.getCreationHelper();
		CellStyle cs= wb.createCellStyle();
		cs.setDataFormat(ch.createDataFormat().getFormat("MM-DD-YYYY"));
		XSSFCell cell1=sheet.createRow(1).createCell(1);
		cell1.setCellValue(new Date());
		cell1.setCellStyle(cs);
		
		FileOutputStream f=new FileOutputStream(".\\src\\main\\resources\\data_Files\\login.xlsx");
		wb.write(f);
		wb.close();
		f.close();
		
		
		
	}
	
	
}
