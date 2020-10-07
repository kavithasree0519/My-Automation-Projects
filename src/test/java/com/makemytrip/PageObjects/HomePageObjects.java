package com.makemytrip.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.Base.BaseConfiguration;

public class HomePageObjects extends BaseConfiguration {

	@FindBy(css="li.menu_Hotels>a>span")
	protected WebElement HotelMenu;
	
	public HomePageObjects()
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getHotel()
	{
		return HotelMenu;
	}
	
	public void openHoteMenu()
	{
		getHotel().click();
	}

	public void presenceOfHotelMenu()
	{
		if(getHotel().isDisplayed())
		{
			System.out.println("Hotel menu is available.");
		}
	}
}
