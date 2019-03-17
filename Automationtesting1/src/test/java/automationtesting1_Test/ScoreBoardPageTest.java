package automationtesting1_Test;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
		 HomePage.GiveSearchInput(reader.getCellData("HomePage", "name", 2));
		 SBPage = HomePage.ClickONScoreBoadrd();
	
	}
	
	
	@Test(priority=1)
	 public void ChangeTalentFlagsTest()
	 {
		String Act= SBPage.ChangeTalentFlagsPageDialogTitle();
	 
	 }
	
	@DataProvider
	public  Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]>	ChangeTalentFlags=	SBPage.GetDiffrentOptions();
		
		
		return ChangeTalentFlags.iterator();
		
	}
	
	
	
	

}
