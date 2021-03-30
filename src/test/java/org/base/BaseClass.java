package org.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	public static WebDriver driver; //1
	public static WebDriver launchBrowser() { //2	
		WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\Genuine\\eclipse-workspace\\Sample\\Diver\\chromedriver.exe");
		return driver = new ChromeDriver();
		
	}
	public static void launchurl(String url) { //3
		driver.get(url);
		driver.manage().window().maximize();
	}
	public static void filltextbox(WebElement e, String value) { //4
		e.sendKeys(value);
	}
	public static void btnclick(WebElement e) { //5
		e.click();
	}
	public static String gettext(WebElement e) { //6
		return e.getText();
	}
	public static String getattribute(WebElement e) { //7
		return e.getAttribute("value");
	}
	public static void movetoelement(WebElement e) { //8
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
	}
	public static void selectbyindex(WebElement e, int index) { //9
		Select s = new Select(e);
		s.selectByIndex(index);
	}
	public static WebElement findelementbyid(String id) { //10
		return driver.findElement(By.id(id));
	}
	public static WebElement findelementbyname(String name) { //11
		return driver.findElement(By.name(name));
	}
	public static WebElement findelementbyxpath(String xpath) { //12
		return driver.findElement(By.xpath(xpath));
	}
	public static WebElement findelementbyclassname(String classname) { //13
		return driver.findElement(By.className(classname));
	}
	public static WebElement findelementbytagname(String tagname) { //14
		return driver.findElement(By.tagName(tagname));
	}
	public static WebElement findelementblinktext(String linktext) { //15
		return driver.findElement(By.linkText(linktext));
	}
	public static WebElement findelementbycssselector(String css) { //16
		return driver.findElement(By.cssSelector(css));
	}
	public static void draganddrop(WebElement src, WebElement des) { //17
		Actions a = new Actions(driver);
		a.dragAndDrop(src, des).perform();
	}
	public static void contectclick(WebElement des) { //18
		Actions a = new Actions(driver);
		a.contextClick(des).perform();
	}
	public static void doubleclick(WebElement des) { //19
		Actions a = new Actions(driver);
		a.doubleClick(des);
	}
	public static void simplealert(WebElement a) { //20
		btnclick(a);
		driver.switchTo().alert().accept();
	}
	public static void conformalert(WebElement a, WebElement conform) { //21
		btnclick(a);
		driver.switchTo().alert();
		btnclick(conform);
	}
	public static void dismiss(WebElement d) { //22
		btnclick(d);
		driver.switchTo().alert().dismiss();
	}
	public static void selectbyvalue(WebElement v, String value) { //23
		Select s = new Select(v);
		s.selectByValue(value);
	}
	public static void visibletext(WebElement v, String value) { //24
		Select s = new Select(v);
		s.selectByVisibleText(value);
	}
	public static int getalloptions(WebElement v) { //25
		Select s = new Select(v);
		java.util.List<WebElement> op = s.getOptions();
		return op.size();
	}
	public static List<String> printalloption(WebElement v) { //26
		Select s = new Select(v);
		List<String>li=new ArrayList<String>();
		List<WebElement> op = s.getOptions();
		for (int i = 0; i < op.size(); i++) {
			WebElement eachop = op.get(i);
		}
		for (WebElement eachop : op) {
		String text = eachop.getText();
		li.add(text);
		}
		return li;
	}
	public static boolean multidropdown(WebElement v) { //27
		Select s = new Select(v);
		return s.isMultiple();
	}
	public static int deselectbyindex(WebElement element, int index) { //28
	Select s = new Select(element);
	s.deselectByIndex(index);
	return index;
	}	
	public static String deselectbyvalue(WebElement q, String w) { //29
		Select s = new Select(q);
		s.deselectByValue(w);
		return w;
	}	
	public static void deselectall(WebElement q) { //30
		Select s = new Select(q);
		s.deselectAll();
	}	
	public static void browserquit() { //31
		driver.quit();
	}
	public static String getcellvalue(String sheetname, int rownum, int cellnum) throws IOException { //32
		File f=new File("C:\\Users\\Genuine\\eclipse-workspace\\Sample\\src\\test\\resources\\Excel\\Datas.xlsx");
		FileInputStream st = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(st);
		Sheet sheet = w.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell c = row.getCell(cellnum);
		int type = c.getCellType();
		String value=null;
		if (type==1) {
			 value = c.getStringCellValue();
		}	 
		else {
			if(DateUtil.isCellDateFormatted(c)) {
				Date date = c.getDateCellValue();
				SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy");
				 value = sf.format(date);
			}
			else {
				double db = c.getNumericCellValue();
				long ln = (long)db;
				 value = String.valueOf(ln);
			}
		}return value;
	}
	public static void writecellvalue(String sheetname, int rownum, int cellnum) throws IOException { //33
		File f=new File("C:\\Users\\Genuine\\eclipse-workspace\\Sample\\src\\test\\resources\\Excel\\Datas.xlsx");
		FileInputStream st = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(st);
		Sheet sheet = w.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell c = row.getCell(cellnum);
		c.setCellValue("manoj");
		FileOutputStream ost= new FileOutputStream(f);
		w.write(ost);
	}	
	public static String getallvalues() throws IOException { //34
		File f=new File("C:\\Users\\Genuine\\eclipse-workspace\\Sample\\src\\test\\resources\\Excel\\Datas.xlsx");
		FileInputStream st = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(st);
		Sheet sheet = w.getSheet("Datas");
		String value = null;
				for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row r =sheet.getRow(i);
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
			Cell c = r.getCell(j);
			int type = c.getCellType();
		
		if (type==1) {
			value = c.getStringCellValue();
		}
		else {
			if(DateUtil.isCellDateFormatted(c)) {
				Date date = c.getDateCellValue();
				SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy");
				value = sf.format(date);
			}
			else {
				double db = c.getNumericCellValue();
				long ln = (long)db;
				value = String.valueOf(ln);
				}
			}
		}
	}
		return value;
	}
	public static String Scanner() { //35
	Scanner s = new Scanner(System.in);
	String a = s.nextLine();
	return a;
}
	public static void screenshot(String path, String img) { //36
	//type casting
	TakesScreenshot tk = (TakesScreenshot)driver;
	File src = tk.getScreenshotAs(OutputType.FILE);
	File des = new File(path+System.currentTimeMillis()+img+".png");
	try {
	FileUtils.copyFile(src,des);
	}
	catch(IOException e) {
	}
}
	public static void scrolldown(String xpath) { //37
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",findelementbyxpath(xpath));
	}
	public static void checkurl(String string, String verify) {
	SoftAssert s = new SoftAssert();
	s.assertTrue(driver.getCurrentUrl().contains(string), verify);
			
	}
	

}//end