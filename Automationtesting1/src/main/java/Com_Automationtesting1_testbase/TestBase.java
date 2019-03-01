package Com_Automationtesting1_testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import Com_Automationtesting1_TestUtil.TestUtil;
import com_Automationtesting1_Helper.ResourceHelper;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverEventListener e_driver;
	
	public TestBase()
	{
		prop = new Properties();
		FileInputStream ip;
		try
		{
			prop = new Properties();
			 ip = new FileInputStream(ResourceHelper.getResourcePath("\\src\\main\\resources\\com_Automationtesting1_config\\config.properties"));
			// System.out.println(ResourceHelper.getResourcePath("\\src\\main\\resources\\com_Automationtesting1_config\\config.properties"));
			try {
				prop.load(ip);
			} catch (IOException e) 
			{
				
				System.out.println("IOException is seen");
			}
		}
		catch (FileNotFoundException e) 
		{
			
			System.out.println("FileNotFoundException is seen");
		}
			
		
	}
	
	public static void initalization()
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",ResourceHelper.getResourcePath("\\src\\main\\resources\\geckodriver.exe"));
			driver = new FirefoxDriver();		
		}	
		else if(browsername.equals("chrome"))
		 {
			System.setProperty("webdriver.chrome.driver" ,ResourceHelper.getResourcePath("\\src\\main\\resources\\chromedriver.exe"));
			driver = new ChromeDriver();
			
		 }
		EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
			//WebDriverEventListener eventListener =  new TestNGListners();
			//e_driver.register(eventListener);
			driver = e_driver;			
		//e_driver.register(eventListener);
		driver = e_driver;
		try
		{
		driver.manage().window().maximize();
		}
		catch(WebDriverException e)
		{
			System.out.println("Webdriver exception seen");
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		try
		{
		driver.get(prop.getProperty("url"));
		}
		catch(Exception e)
		{
			System.out.println("url is not entered");
			
		}
		
	}
	
	

}
