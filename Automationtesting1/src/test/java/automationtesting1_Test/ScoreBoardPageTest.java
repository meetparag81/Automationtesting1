package automationtesting1_Test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com_Automationtesting1_ExcelUtil.ExlsReader;
import Com_Automationtesting1_Pages.HomePage;
import Com_Automationtesting1_Pages.LoginPage;
import Com_Automationtesting1_Pages.ScoreBoardPage;
import Com_Automationtesting1_testbase.TestBase;
import com_Automationtesting1_Helper.ResourceHelper;
import com_Automationtesting1_Logger.LoggerHelper;

public class ScoreBoardPageTest extends TestBase
{
	
	LoginPage LoginPage;
	HomePage HomePage;
	ScoreBoardPage SBPage;
	ExlsReader reader = new ExlsReader(ResourceHelper.getResourcePath("\\src\\main\\java\\Com_Automationtesting1_TestData\\TestData.xlsx"));
	private static Logger log = LoggerHelper.getLogger(TestBase.class);
	
	
	@BeforeMethod
	public void Setup()
	{
		TestBase.initalization();
		LoginPage = new LoginPage();
		
		boolean flag= false;
		 LoginPage.EnterwithValidcredentials(reader.getCellData("HomePage", "UserName", 2), reader.getCellData("HomePage", "Password", 2));
		 HomePage= LoginPage.ClickOnLogin();
		 HomePage.SearchAndClickTheUser();
		 SBPage = HomePage.ClickONScoreBoadrd();
	
	}
	
	
	@Test(priority=1)
	 public void ChangeTalentFlagsPageDialogTitleTest()
	 {
		String Act= SBPage.ChangeTalentFlagsPageDialogTitle();
		String Exp= "Org Chart Fields/Talent Flags";
		Assert.assertEquals(Act, Exp);
		log.info("ChangeTalentFlagsTest is completed");
	 }
	@Test(priority=2)
	public void SelectDiffrentTalentOptionTest()
	{
		SBPage.SelectDiffrentOptions();
		
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	
	
	
	

}
