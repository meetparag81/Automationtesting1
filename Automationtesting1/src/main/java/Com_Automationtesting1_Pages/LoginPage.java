package Com_Automationtesting1_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com_Automationtesting1_ExcelUtil.ExlsReader;
import Com_Automationtesting1_testbase.TestBase;



public class LoginPage extends TestBase
{
	@FindBy (xpath="//input[@id='username']")WebElement user_name;
	@FindBy (xpath="//input[@id='password']")WebElement password;
	@FindBy(xpath="//input[@class='btn btn-default']")WebElement Login_Button; 
	ExlsReader reader = new ExlsReader("C:\\WorkingfolderPB\\Java\\Automationtesting1\\src\\main\\java\\Com_Automationtesting1_TestData\\TestData.xlsx");



public LoginPage()
{
	PageFactory.initElements(driver, this);
}


public void EnterUserName(String username)
{
	user_name.sendKeys(username);
	
}

public void EnterPassword(String password)
{
	this.password.sendKeys(password);
}
public void ClickOnLogin()
{
	Login_Button.click();
}

public HomePage EnterwithValidcredentials(String Username, String Password)

{
	
	EnterUserName(Username);
	EnterPassword(Password);
	if(Login_Button.isEnabled())
	{
	ClickOnLogin();
	}
	else
	{
		System.out.println(("Login_Button is not enabled"));
		
	}
	return new HomePage();
	
}
	
	


}
