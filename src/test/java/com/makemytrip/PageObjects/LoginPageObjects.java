package com.makemytrip.PageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.Base.BaseConfiguration;
import com.makemytrip.Utils.TestUtil;

public class LoginPageObjects extends BaseConfiguration{

	WebDriver driver;
	WebDriverWait wait;
	@FindBy(css=".mmtLogo.makeFlex>img")
	protected WebElement logo;
	
	@FindBy(xpath="//li[@data-cy='account']/div/p")
	protected WebElement account;
	
	@FindBy(xpath="//input[@data-cy='userName']")
	protected WebElement username;
	
	@FindBy(xpath="//button[@data-cy='continueBtn']")
	protected WebElement continueBtn;
	
	@FindBy(css="div>#password")
	protected WebElement password;
	
	@FindBy(xpath="//button[@data-cy='login']")
	protected WebElement login;
	
	@FindBy(xpath="//li//p[@data-cy='loggedInUser']")
	protected WebElement loggedinUser;
	
	public LoginPageObjects()
	{
		this.driver = initialisation();
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver,TestUtil.EXPLICIT_TIME);
	}
	
	public WebElement verifyLogin()
	{
		return logo;
	}
	
	public WebElement getAccount()
	{
		return account;
	}

	public WebElement getUsername()
	{
		return username;
	}
	
	  public WebElement getContinue() { return continueBtn; }
	 
	 
	 public WebElement getPassword()
	 {
		 return password;
	 }
	 
	 public WebElement getLogin()
	 {
		 return login;
	 }
	 
	 public WebElement getLoggedInUser()
	 {
		 return loggedinUser;
	 }
	public void OpenURL() 
	{
		driver.get(prop.getProperty("baseURL"));
	}

	public void makemytripLogon()
	{
		String logoName = verifyLogin().getAttribute("alt");
		assertEquals(logoName, "Make My Trip");
	}

	public void enterMailID(String username)
	{
		
		wait.until(ExpectedConditions.visibilityOf(getAccount()));
		//getAccount().sendKeys(Keys.TAB);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getAccount());
		getUsername().sendKeys(username);
		getUsername().sendKeys(Keys.TAB);
		getUsername().sendKeys(Keys.ENTER);

	}

	public void enterPassword(String password)
	{
		//getContinue().click();
		getPassword().sendKeys(password);
	}

	public void clickLogin()
	{
		//getLogin().click();
		getPassword().sendKeys(Keys.TAB);
		getPassword().sendKeys(Keys.ENTER);
	}

	public void verifyUser() throws InterruptedException
	{
		makemytripLogon();
		wait.until(ExpectedConditions.textToBePresentInElement(getLoggedInUser(), "Hey kavitha"));
	}
	
	
	
	
	
	
}
