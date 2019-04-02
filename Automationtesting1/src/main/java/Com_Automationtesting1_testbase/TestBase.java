package Com_Automationtesting1_testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import Com_Automationtesting1_TestUtil.TestUtil;
import com_Automationtesting1_Helper.ResourceHelper;
import com_Automationtesting1_Logger.LoggerHelper;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverEventListener e_driver;
	private static Logger log = LoggerHelper.getLogger(TestBase.class);
	private static String msg;
	
	public TestBase()
	{
		System.out.println();
		
		prop = new Properties();
		FileInputStream ip;
		try
		{
			prop = new Properties();
			log.info("property file initalized");
			 ip = new FileInputStream(ResourceHelper.getResourcePath("\\src\\main\\resources\\com_Automationtesting1_config\\config.properties"));
			// System.out.println(ResourceHelper.getResourcePath("\\src\\main\\resources\\com_Automationtesting1_config\\config.properties"));
			try {
				prop.load(ip);
			} catch (IOException e) 
			{
				
				log.info("I/O Exception seen.");
			}
		}
		catch (FileNotFoundException e) 
		{
			
			log.info(" File not find Exception seen.");
		}
			
		
	}
	
	public static String initalization()
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",ResourceHelper.getResourcePath("\\src\\main\\resources\\geckodriver.exe"));
			driver = new FirefoxDriver();
			log.info("firefox browser launched");
		}	
		else if(browsername.equals("chrome"))
		 {
			System.setProperty("webdriver.chrome.driver" ,ResourceHelper.getResourcePath("\\src\\main\\resources\\chromedriver.exe"));
			driver = new ChromeDriver();
			log.info("chrome browser launched");
			
		 }
		/*EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
		 Nowcreate object of EventListerHandler to register it with EventFiringWebDriver
			//WebDriverEventListener eventListener =  new TestNGListners();
			//e_driver.register(eventListener);
			driver = e_driver;			
		e_driver.register(eventListener);
		driver = e_driver;*/
		try
		{
		driver.manage().window().maximize();
		log.info("maximized the browser");
		}
		catch(WebDriverException e)
		{
			log.info("webdriver exception is seen");
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		try
		{
			String URL = prop.getProperty("url");
		driver.get("https://performancemanager8.successfactors.com/login?company=BPOCUSTOM10");
		log.info("url is entered");
		if(!driver.getTitle().equals("SuccessFactors"))
		{
			driver.navigate().refresh();
			return msg = "true";
		}
		}
		catch(Exception e)
		{
			log.info("url is not entered");
			return msg = "false";
			
			
				
			}
		if(msg.equals("false"))
		{
			driver.get("https://performancemanager8.successfactors.com");
			driver.findElement(By.id("__input0-inner")).sendKeys("BPOCUSTOM10");
			driver.findElement(By.id("__button0-img")).click();
		
			
			
		}
		return msg= driver.getTitle();
		
	}
}
	
	


