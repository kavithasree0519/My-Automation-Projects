package com.makemytrip.Utils;

import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods{

	public static void elementIsDisplayed(List<WebElement> list, WebDriver driver, String label)
	{
		if(!list.isEmpty())
		{
			System.out.println(label+" is available.");
		}
		
		else
		{
			System.out.println(label+" is unavailable.");
		}
	}
	
	public static void validationMessage(List<WebElement> errorMessage, WebDriver driver, String label)
	{
		if(!errorMessage.isEmpty())
		{
			assertEquals(errorMessage.get(0).getText(),label);
		}
		
		else
		{
			System.out.println(label+" is unavailable.");
		}
	}
	public static int Today()
	{
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
		String dateArr = dateFormat.format(date);
		String[] dateArray = dateArr.split("-");
		int DD = Integer.parseInt(dateArray[2]);
		return DD;
	}
	
}
