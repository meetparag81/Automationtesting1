package Automationtesting1.Automationtesting1;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com_Automationtesting1_ExcelUtil.ExlsReader;
import Com_Automationtesting1_Pages.LoginPage;
import Com_Automationtesting1_testbase.TestBase;
import com_Automationtesting1_Helper.ResourceHelper;

public class LoginPageTest extends TestBase 
{
	LoginPage LoginPage;
	ExlsReader reader = new ExlsReader(ResourceHelper.getResourcePath("\\src\\main\\java\\Com_Automationtesting1_TestData\\TestData.xlsx"));
	
	
	@BeforeMethod
	public void setup()
	{
		TestBase.initalization();
		LoginPage = new LoginPage();
	
	}
	
	
	@Test
	public void EnterwithvalidUserNameTest()
	{
		String un = reader.getCellData("LoginPage", "UserName", 1);
		String pass = reader.getCellData("LoginPage", "Password", 1);
		LoginPage.EnterwithValidcredentials(un, pass);
		
	}
	

}
