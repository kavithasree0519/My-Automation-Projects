package com.makemytrip.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.Base.BaseConfiguration;
import com.makemytrip.Utils.CommonMethods;
import com.makemytrip.Utils.TestUtil;

public class PaymentPageObjects extends BaseConfiguration
{
	WebDriverWait wait;
	public PaymentPageObjects()
	{
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver,TestUtil.EXPLICIT_TIME);
	}
	
	@FindBy(xpath="//span[contains(text(),'Payment Options')]")
	protected List<WebElement> payOption;
	
	@FindBy(css="#CC")
	protected WebElement credit_debit;
	
	@FindBy(xpath="//label[text()='CARD NUMBER']")
	protected List<WebElement> cardLabel;
	
	@FindBy(css="#PAYMENT_cardNumber")
	protected WebElement card;
	
	@FindBy(css="#PAYMENT_cardNumber_err > span > span.error_text.lato-regular.pull-left")
	protected List<WebElement> errorMessage;
	
	public WebElement getCreditDebit()
	{
		return credit_debit;
	}
	
	public WebElement getCardNumber()
	{
		return card;
	}
	public void pageLoaded() throws InterruptedException
	{
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(2));
	    Thread.sleep(2000);
		CommonMethods.elementIsDisplayed(payOption, driver, "Payment Options");
	}
	public void cardPaymentSelection() 
	{
		getCreditDebit().click();
		CommonMethods.elementIsDisplayed(cardLabel, driver, "Card number");
		
	}
	
	
	

	public void enterCardNumber(String cardNumber) {
		getCardNumber().sendKeys(cardNumber);
		getCardNumber().sendKeys(Keys.TAB);
	}

	public void verifyFailedPayment() {
		CommonMethods.validationMessage(errorMessage,driver,"Enter your Card number");
	}
		
	}
