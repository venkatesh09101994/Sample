package org.hotel;
import java.util.concurrent.TimeUnit;

import org.base.BaseClass;
import org.base.Datas;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Hotel extends BaseClass {
	
@BeforeClass
public static void launch() {
launchBrowser();
launchurl("https://adactinhotelapp.com/index.php");
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
@AfterClass
public static void quit() {
	System.out.println(getattribute(findelementbyxpath("//input[@id='order_no']")));
	scrolldown("//input[@id='order_no']");
	screenshot(
	"C:\\Users\\Genuine\\eclipse-workspace\\Parameters\\src\\test\\resources./ScreenShots\\","ordernum");
	btnclick(findelementbyxpath("//input[@id='logout']"));
	browserquit();
}
//@Parameters
//({"user","pass","location","hotel","roomtype","roomno","indate","outdate","adults",
//"child","fstname","lstname","add","cardno","cardtype","expirymnt","expiryyr","ccv"})
//@DataProvider(name="book")
//private Object[][] getexcal(){
//	return getexcal();
//}
@Test(dataProvider="book", dataProviderClass = Datas.class)
public void test
(String user, String pass,String location,String hotel, String type,String roomno,
String indate,String outdate,String adults,String child,String fstname,String lstname,
String add,String cardno,String cardtype,String expirymnt,String expiryyr,String ccv) {

	LogInPom l = new LogInPom();
	filltextbox(l.getUsername(), user);
	filltextbox(l.getPassword(), pass);
	btnclick(l.getLogin());
	WelcomePom w = new WelcomePom();
	selectbyvalue(w.getLocation(), location);
	selectbyvalue(w.getHotel(), hotel);
	selectbyvalue(w.getRoomtype(), type);
	selectbyvalue(w.getNumrooms(), roomno);
	w.getIndate().clear();
	filltextbox(w.getIndate(), indate);
	w.getOutdate().clear();
	filltextbox(w.getOutdate(), outdate);
	selectbyvalue(w.getAdults(), adults);
	selectbyvalue(w.getChildroom(), child);
	btnclick(w.getSearch());
	SelectHotelPom s = new SelectHotelPom();
	btnclick(s.getSelect());
	btnclick(s.getSubmit());
	BookPom b = new BookPom();
	filltextbox(b.getFstname(), fstname);
	filltextbox(b.getLstname(), lstname);
	filltextbox(b.getAdd(), add);
	filltextbox(b.getCardnum(), cardno);
	selectbyvalue(b.getCardtype(), cardtype);
	selectbyvalue(b.getExpirymnt(), expirymnt);
	selectbyvalue(b.getExpiryyr(), expiryyr);
	filltextbox(b.getCcv(),ccv);
	btnclick(b.getBook());
}
}//end