package automationtesting1_Test;





import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com_Automationtesting1_ExcelUtil.ExlsReader;
import Com_Automationtesting1_testbase.TestBase;
import com_Automationtesting1_Helper.ResourceHelper;
import com_Automationtesting1_Logger.LoggerHelper;
import Com_Automationtesting1_Pages.LoginPage;

public class LoginPageTest extends TestBase 
{
	
	LoginPage LoginPage;
	ExlsReader reader = new ExlsReader(ResourceHelper.getResourcePath("\\src\\main\\java\\Com_Automationtesting1_TestData\\TestData.xlsx"));
	private static Logger log = LoggerHelper.getLogger(TestBase.class);
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		TestBase.initalization();
		LoginPage = new LoginPage();
	
	}
	
	
	@Test
	public void EnterwithvalidUserNameTest()
	{
		String un = reader.getCellData("LoginPage", "UserName", 2);
		String pass = reader.getCellData("LoginPage", "Password", 2);
		LoginPage.EnterwithValidcredentials(un, pass);
		log.info("username and paasword added");
		int size = LoginPage.Frames();
		String actual =LoginPage.UsernameOnHomePage();
		String expected = reader.getCellData("LoginPage", "username", 2);
		Assert.assertEquals(actual, expected);
		log.info("EnterwithvalidUserNameTest completed");
		
	}
	
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}
	

}
