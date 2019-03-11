package Automationtesting1.Automationtesting1;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com_Automationtesting1_ExcelUtil.ExlsReader;
import Com_Automationtesting1_testbase.TestBase;
import com_Automationtesting1_Helper.ResourceHelper;
import com_Automationtesting1_Logger.LoggerHelper;
import Com_Automationtesting1_Pages.HomePage;
import Com_Automationtesting1_Pages.LoginPage;

public class HomePageTest extends TestBase
{
	HomePage HomePage;
	LoginPage LoginPage;
	ExlsReader reader = new ExlsReader(ResourceHelper.getResourcePath("\\src\\main\\java\\Com_Automationtesting1_TestData\\TestData.xlsx"));
	private static Logger log = LoggerHelper.getLogger(TestBase.class);
	
	HomePageTest()
	{
		super();
	}
	@BeforeMethod
	public void Setup()
	{
		TestBase.initalization();
		LoginPage = new LoginPage();
		LoginPage.EnterwithValidcredentials(reader.getCellData("LoginPage", "UserName", 2), reader.getCellData("LoginPage", "Password", 2));
		HomePage = LoginPage.ClickOnLoginButton();
	}
	
	
	@Test(priority=1)
	public void SearchtheResultTest()
	{
		HomePage.SearchTheResult(); 
		
		
		
		
	}

}
