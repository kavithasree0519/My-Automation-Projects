package com.makemytrip.Base;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.makemytrip.Utils.TestUtil;

public class BaseConfiguration {

	
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseConfiguration()
	{
		prop = new Properties();
		FileInputStream fis;
		try
		{
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
			prop.load(fis);	
		}
		catch(IOException e)
		{
			System.out.println("error with config.properties file"+e);
		}
	}
	
	//WebDriver initialisation
	public static WebDriver initialisation()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\lolu\\softwares\\chromedriver.exe");
	        driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIME, TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	
       
        
    
}
