package org.hotel;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePom extends BaseClass{
public WelcomePom() {
PageFactory.initElements(driver, this);
}
@FindBy(xpath="//select[@name='location']")
private WebElement location; 
@FindBy(xpath="//select[@name='hotels']")
private WebElement hotel;
@FindBy(xpath="//select[@name='room_type']")
private WebElement roomtype;
@FindBy(xpath="//select[@name='room_nos']")
private WebElement numrooms;
@FindBy(xpath="//input[@name='datepick_in']")
private WebElement indate;
@FindBy(xpath="//input[@name='datepick_out']")
private WebElement outdate;
@FindBy(xpath="//select[@name='adult_room']")
private WebElement adults;
@FindBy(xpath="//select[@name='child_room']")
private WebElement childroom;
@FindBy(xpath="//input[@name='Submit']")
private WebElement search;
public WebElement getLocation() {
	return location;
}
public WebElement getHotel() {
	return hotel;
}
public WebElement getRoomtype() {
	return roomtype;
}
public WebElement getNumrooms() {
	return numrooms;
}
public WebElement getIndate() {
	return indate;
}
public WebElement getOutdate() {
	return outdate;
}
public WebElement getAdults() {
	return adults;
}
public WebElement getChildroom() {
	return childroom;
}
public WebElement getSearch() {
	return search;
}


	

}


