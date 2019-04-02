package automationtesting1_Test;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
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
		String msg = TestBase.initalization();
		if(!msg.equals("SucessFactors"))
		 {
			 driver.navigate().refresh();
		 }
		LoginPage = new LoginPage();
		log.info("Loginpage object created");
		LoginPage.EnterwithValidcredentials(reader.getCellData("HomePage", "UserName", 2), reader.getCellData("HomePage", "Password", 2));
		 HomePage= LoginPage.ClickOnLogin();
		 if(!driver.getTitle().equals("Home"))
		 {
			 driver.navigate().refresh();
		 }
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) 
		 {
			log.info(e.getStackTrace());
		}
		 HomePage.GiveSearchInput(reader.getCellData("HomePage", "name", 2));
		 SBPage = HomePage.ClickONScoreBoadrd();
	
	}
	
	
	@Test(priority=1,groups = {"Smoke" })
	 public void ChangeTalentFlagsTest()
	 {
		String Act= SBPage.ChangeTalentFlagsPageDialogTitle();
	 
	 }
	
	@Test(priority=2,groups = {"functional" },dataProvider= "getTestData",enabled= false)
	 public void SaveChangeTalentFlagsTest(WebElement RoLp,WebElement IoLp,WebElement RoLo)
	 
	 {
		System.out.println();
		String Act= SBPage.SaveAllOptions(RoLp, IoLp, RoLo);
	 
	 }
	
	@DataProvider
	public  void getTestData(WebElement RiskOfLossoptions, WebElement ImPactOFLossoptions, WebElement ReasonOfLeavingoptions)
	{
		String	ChangeTalentFlags=	SBPage.SaveAllOptions(RiskOfLossoptions, ImPactOFLossoptions, ReasonOfLeavingoptions);
		
		
		
		
	}
	
	
	
	

}
