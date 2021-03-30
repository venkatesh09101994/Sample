package org.hotel;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPom extends BaseClass {
public SelectHotelPom(){
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//input[@name='radiobutton_0']")
private WebElement select;
@FindBy(xpath="//input[@name='continue']")
private WebElement submit;
public WebElement getSubmit() {
	return submit;
}
public WebElement getSelect() {
	return select;
}






}
