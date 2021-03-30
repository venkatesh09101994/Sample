package org.hotel;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPom extends BaseClass{
public BookPom() {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//input[@id='first_name']")
private WebElement fstname;
@FindBy(xpath="//input[@id='last_name']")
private WebElement lstname;
@FindBy(xpath="//textarea[@id='address']")
private WebElement add;
@FindBy(xpath="//input[@id='cc_num']")
private WebElement cardnum;
@FindBy(xpath="//select[@id='cc_type']")
private WebElement cardtype;
@FindBy(xpath="//select[@id='cc_exp_month']")
private WebElement expirymnt;
@FindBy(xpath="//select[@id='cc_exp_year']")
private WebElement expiryyr;
@FindBy(xpath="//input[@id='cc_cvv']")
private WebElement ccv;
@FindBy(xpath="//input[@id='book_now']")
private WebElement book;
public WebElement getFstname() {
	return fstname;
}
public WebElement getLstname() {
	return lstname;
}
public WebElement getAdd() {
	return add;
}
public WebElement getCardnum() {
	return cardnum;
}
public WebElement getCardtype() {
	return cardtype;
}
public WebElement getExpirymnt() {
	return expirymnt;
}
public WebElement getExpiryyr() {
	return expiryyr;
}
public WebElement getCcv() {
	return ccv;
}
public WebElement getBook() {
	return book;
}
}
