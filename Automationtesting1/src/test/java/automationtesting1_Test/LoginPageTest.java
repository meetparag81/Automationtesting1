package automationtesting1_Test;

import org.junit.Test;
import org.testng.annotations.BeforeMethod;


import Com_Automationtesting1_ExcelUtil.ExlsReader;
import Com_Automationtesting1_testbase.TestBase;
 import Com_Automationtesting1_Pages.LoginPage;

public class LoginPageTest extends TestBase 
{
	LoginPage LoginPage;
	ExlsReader reader = new ExlsReader("C:\\WorkingfolderPB\\Java\\Automationtesting1\\src\\main\\java\\Com_Automationtesting1_TestData\\TestData.xlsx");
	
	
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
