package automationtesting1_Test;

import org.apache.commons.lang3.SystemUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
	
	HomePageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		TestBase.initalization();
		LoginPage = new LoginPage();
		
		boolean flag= false;
		 LoginPage.EnterwithValidcredentials(reader.getCellData("HomePage", "UserName", 2), reader.getCellData("HomePage", "Password", 2));
		 HomePage= LoginPage.ClickOnLogin();
		
	}
	
	@Test(priority=2)
	public void SearchTheUserTest()
	{
		int size= HomePage.GiveSearchInput(reader.getCellData("HomePage", "name", 2));
		Assert.assertNotEquals(size,0);
		log.info("SearchTheUserTest is passed");
	
	}
	
	@Test(priority=1)
	public void SearchAndClickTheUserTest()
	{
		String Act = HomePage.SearchAndClickTheUser();
		String Exp = "Palani kumar T (palani)";
		Assert.assertEquals(Act, Exp);
		log.info("SearchAndClickTheUserTest is passed");
		
	}
	
	@Test(priority=3)
	public void ScoreBoardPageTileTest()
	{
		HomePage.SearchAndClickTheUser();
		HomePage.ClickONScoreBoadrd();
	String Act=	HomePage.ScoreBoardPageTile();
	String Exp = "Org Chart Fields/Talent Flags";
	
		log.info("ScoreBoardPageTileTest is completed");
	
	}
	
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	
	

}
