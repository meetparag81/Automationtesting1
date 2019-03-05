package automationtesting1_Test;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com_Automationtesting1_ExcelUtil.ExlsReader;
import Com_Automationtesting1_Pages.LoginPage;
import Com_Automationtesting1_testbase.TestBase;
import com_Automationtesting1_Helper.ResourceHelper;
import com_Automationtesting1_Logger.LoggerHelper;
import Com_Automationtesting1_Pages.HomePage;

public class HomePageTest extends TestBase
{
	LoginPage LoginPage;
	HomePage HomePage;
	ExlsReader reader = new ExlsReader(ResourceHelper.getResourcePath("\\src\\main\\java\\Com_Automationtesting1_TestData\\TestData.xlsx"));
	private static Logger log = LoggerHelper.getLogger(TestBase.class);
	
	
	@BeforeMethod
	public void setup()
	{
		TestBase.initalization();
		LoginPage = new LoginPage();
		
		HomePage =LoginPage.EnterwithValidcredentials(reader.getCellData("HomePage", "UserName", 2), reader.getCellData("HomePage", "Password", 2));
	
	}
	
	@Test(priority=1)
	public void SearchTheUserTest()
	{
		HomePage.GiveSearchInput(reader.getCellData("HomePage", "name", 2));
		
	}
	
	

}
