/**
 * 
 */
package utils;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;







/**
 * @author Temp
 *
 */
public class excelWrite {
	
	
	public static String wrtieDataToExcel(int row,int col,String Status)
    {
      
        try
        
        {
           
        	FileInputStream fis = new FileInputStream(new File("C:/Users/Temp/workspace/FormValidationIP/TestData.xlsx"));
        	XSSFWorkbook workbook = new XSSFWorkbook (fis);
        	XSSFSheet sheet = workbook.getSheetAt(0);
        	//Create First Row
        	XSSFRow row1 = sheet.getRow(row);
        	XSSFCell r1c1 = row1.getCell(col);
        	r1c1.setCellValue(Status);
        	/*XSSFCell r1c2 = row1.createCell(1);
        	r1c2.setCellValue("NAME");
        	XSSFCell r1c3 = row1.createCell(2);
        	r1c3.setCellValue("AGE");
        	//Create Second Row
        	XSSFRow row2 = sheet.createRow(1);
        	XSSFCell r2c1 = row2.createCell(0);
        	r2c1.setCellValue("1");
        	XSSFCell r2c2 = row2.createCell(1);
        	r2c2.setCellValue("Ram");
        	XSSFCell r2c3 = row2.createCell(2);
        	r2c3.setCellValue("20");		
        	//Create Third Row
        	XSSFRow row3 = sheet.createRow(2);
        	XSSFCell r3c1 = row3.createCell(0);
        	r3c1.setCellValue("2");
        	XSSFCell r3c2 = row3.createCell(1);
        	r3c2.setCellValue("Shyam");
        	XSSFCell r3c3 = row3.createCell(2);
        	r3c3.setCellValue("25");*/
        	fis.close();
        	FileOutputStream fos =new FileOutputStream(new File("C:/Users/Temp/workspace/FormValidationIP/TestData.xlsx"));
        	    workbook.write(fos);
        	    fos.close();
        	System.out.println("Done");
        	
        	
    }
    catch(Exception e)
    {

    }
		return " ";

    }

}



