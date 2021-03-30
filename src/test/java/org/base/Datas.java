package org.base;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
public class Datas {
	@DataProvider(name="book")
	private Object[][] getdata() throws Throwable{
		File f= new File("C:\\Users\\Genuine\\eclipse-workspace\\Parameters\\src\\test\\resources\\ExcelData\\Datas.xlsx");
		FileInputStream st=new FileInputStream(f);
		Workbook w = new XSSFWorkbook(st);
		Sheet s=w.getSheet("Hotel");
		Row r=s.getRow(0);
		int rowcount = s.getPhysicalNumberOfRows();
		int cellcount = r.getPhysicalNumberOfCells();
		Object[][] ob = new Object[rowcount-1][cellcount];
		for (int i = 0; i < rowcount-1; i++) {
			Row rr = s.getRow(i+1);
			for (int j = 0; j < cellcount; j++) {
				Cell c = rr.getCell(j);
				int type=c.getCellType();
				String value = null;
				if (type==1) {
					value = c.getStringCellValue();}	 
				else {
					if(DateUtil.isCellDateFormatted(c)) {
						Date date = c.getDateCellValue();
						SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
						value = sf.format(date);}
					else {
						double db = c.getNumericCellValue();
						long ln = (long)db;
						value = String.valueOf(ln);}
			}ob[i][j]=value;
		}}return ob;}}