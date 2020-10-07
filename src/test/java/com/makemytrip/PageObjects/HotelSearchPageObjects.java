package com.makemytrip.PageObjects;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.Base.BaseConfiguration;
import com.makemytrip.Utils.CommonMethods;
import com.makemytrip.Utils.TestUtil;

public class HotelSearchPageObjects extends BaseConfiguration
{

	WebDriverWait wait;
	String hotelSelected;
	@FindBy(xpath="//span[@data-cy='hotelCityLabel']")
	protected List<WebElement> cityLabel;
	
	@FindBy(xpath="//input[@data-cy='checkin']")
	protected List<WebElement> checkInLabel;
	
	@FindBy(css="#checkout")
	protected List<WebElement> checkOutLabel;
	
	@FindBy(css="#guest")
	protected List<WebElement> roomLabel;

	@FindBy(css="#city")
	protected WebElement city;
	
	@FindBy(xpath="//input[@placeholder='Enter city/ Hotel/ Area/ Building']")
	protected WebElement cityList;
	
	@FindBy(xpath="//p[@data-cy='checkInDate']/span[1]")
	protected WebElement checkInDate;
	
	@FindBy(xpath="(//li[@role='option']//div/div)[1]")
	protected WebElement selectCity;
	
	@FindBy(xpath="//div[@class='DayPicker-Day DayPicker-Day--start DayPicker-Day--selected']")
	protected WebElement startDate;
	
	@FindBy(css="#guest")
	protected WebElement guestList;
	
	
	@FindBy(css=".primaryBtn.btnApply")
	protected WebElement apply;
	
	@FindBy(css="#hsw_search_button:nth-child(1)")
	protected WebElement search;
	
	@FindBy(xpath ="(//p[@id='hlistpg_hotel_name']/span)[1]")
	protected WebElement hotelName;
	
	@FindBy(css="#detpg_hotel_name")
	protected WebElement expectedHotel;
	
	@FindBy(xpath="//a[text()='Home']")
	protected WebElement home;
	
	@FindBy(css="#detpg_headerright_book_now")
	protected WebElement bookthisNow;
	
	@FindBy(xpath="//h4[text()='Review your booking']")
	protected List<WebElement> review;
	
	@FindBy(css="._Modal.modalCont>span")
	protected WebElement closeWindow;
	
	@FindBy(css="#title")
	protected WebElement title;
	
	@FindBy(css="#fName")
	protected WebElement firstname;
	
	@FindBy(css="#lName")
	protected WebElement lastname;
	
	@FindBy(css="#email")
	protected WebElement email;
	
	@FindBy(css="mNo")
	protected WebElement phoneNum;
	
	@FindBy(css="#revpg_user_entered_coupon_code")
	protected WebElement couponCode;
	
	@FindBy(css="#revpg_coupon_apply_remove_btn")
	protected WebElement applyCoupon;
	
	@FindBy(css=".primaryBtn btnPayNow")
	protected WebElement payNow;
	
	@FindBy(xpath="//label[text()='Twin beds']")
	protected WebElement specialRequest;
	public HotelSearchPageObjects()
	{
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,TestUtil.EXPLICIT_TIME);
	}

	
	
	public List<WebElement> getCityLabel()
	{
		return cityLabel;
	}
	private List<WebElement> getRoomLabel() 
	{
		return roomLabel;
	}

	private List<WebElement> getCheckOutLabel()
	{
		return checkOutLabel;
	}

	private List<WebElement> getCheckInLabel()
	{
		return checkInLabel;
	}
	
	public WebElement getCityList()
	{
		return cityList;
	}
	
	public WebElement getCheckInDateList()
	{
		return checkInDate;
	}
	

	private WebElement getCityOption()
	{
		return city;
	}

	private WebElement getGuestList()
	{
		return guestList;
	}
	
	private WebElement getApply()
	{
		return apply;
	}
	
	private WebElement getSearchButton()
	{
		return search;
	}
	
	private WebElement getTitle()
	{
		return title;
	}
	
	public WebElement getFirstName()
	{
		return firstname;
	}
	
	
	private WebElement getStartDate() 
	{
		return startDate;
	}

	private WebElement clickBookNow()
	{
		return bookthisNow;
	}
	
	private WebElement getLastName() 
	{
		return lastname;
	}
	
	public WebElement getEmail()
	{
		return email;
	}
	
	public WebElement getPhone()
	{
		return phoneNum;
	}
	
	public WebElement getCouponCode()
	{
		return couponCode;
	}
	
	public WebElement applyCoupon()
	{
		return applyCoupon;
	}
	
	public WebElement getRequest()
	{
		return specialRequest;
	}
	
	public WebElement getPayNow()
	{
		return payNow;
	}
	public void findElement() 
	{
		CommonMethods.elementIsDisplayed(getCityLabel(),driver,"CITY / HOTEL / AREA / BUILDING");
		CommonMethods.elementIsDisplayed(getCheckInLabel(),driver,"CHECK-IN");
		CommonMethods.elementIsDisplayed(getCheckOutLabel(),driver,"CHECK-OUT");
		CommonMethods.elementIsDisplayed(getRoomLabel(),driver,"ROOMS & GUESTS");
	}

	public void searchHotel(String cityName,int room) throws Exception
	{
		getCityOption().click();
		getCityList().sendKeys(cityName);
		getCityList().sendKeys(Keys.ARROW_DOWN);
		getCityList().sendKeys(Keys.ENTER);
		getStartDate().click();
		driver.findElement(By.xpath("(//div[contains(@class,'DayPicker-Day')][text()='"+CommonMethods.Today()+"'])[1]")).click();
		getGuestList().click();
		selectAdultCount(room);
	}



	private void selectAdultCount(int room)
	{
		driver.findElement(By.xpath("//li[contains(@data-cy,'adults')][text()='"+room+"']")).click();
		getApply().click();
		getSearchButton().click();
		
	}



	public void getResultPageView()
	{
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.contains("https://www.makemytrip.com/hotels/hotel-listing"))
		{
			System.out.println("Hotel listing page reached.");
		}
	}



	public void getSearchFilter()
	{
		if(driver.getPageSource().contains("Select Filters"))
		{
			System.out.println("Search filters are available.");
		}
	}



	public void applyLocalityFilter(String loc)
	{
		WebElement element = driver.findElement(By.xpath("//*[@id='hlistpg_fr_popular_filters']/div[text()='Popular Filters']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='"+loc+"']/parent::label"))).click();
	}



	public void applyUserRating(String rating) throws InterruptedException 
	{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Locality']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='"+rating+"']"))).click();
		hotelSelected = hotelName.getText();
		wait.until(ExpectedConditions.visibilityOf(hotelName)).click();
	}



	public void searchedResult() throws InterruptedException
	{
		String parent = driver.getWindowHandle();
		Set<String> nextWindow = driver.getWindowHandles();
		Iterator<String> I1= nextWindow.iterator();

		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);
			}
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(home));
		String actualHotel = wait.until(ExpectedConditions.visibilityOf(expectedHotel)).getText();
		assertEquals(actualHotel, hotelSelected);
		
	}



	public void bookHotel()
	{
		clickBookNow().click();
	}



	public void reviewPage() throws InterruptedException 
	{
		CommonMethods.elementIsDisplayed(review, driver, "Review your booking");
		Thread.sleep(3000);
		closeWindow.click();
	}



	public void enterName(String title2, String firstName, String lastName) {
		
		Select selectTitle = new Select(getTitle());
		selectTitle.selectByValue(title2);
		
		getFirstName().sendKeys(firstName);
		getLastName().sendKeys(lastName);
		
	}

	public void enterContactDetails(String mail, String phone) 
	{
		getEmail().sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		getEmail().sendKeys(mail);
		getPhone().sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		getPhone().sendKeys(phone);
	}



	public void specialRequests(String coupon,String req)
	{
		getCouponCode().sendKeys(coupon);
		applyCoupon().click();
		getRequest().click();
	}



	public void payNow() 
	{
		getPayNow().click();
	}


	
}
