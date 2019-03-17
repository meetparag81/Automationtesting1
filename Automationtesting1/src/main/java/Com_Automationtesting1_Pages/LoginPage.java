package Com_Automationtesting1_Pages;

import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com_Automationtesting1_ExcelUtil.ExlsReader;
import Com_Automationtesting1_TestUtil.TestUtil;
import Com_Automationtesting1_testbase.TestBase;
import com_Automationtesting1_Helper.ResourceHelper;
import com_Automationtesting1_Logger.LoggerHelper;
import helper.Frame.FrameHelper;



public class LoginPage extends TestBase
{
	@FindBy (xpath="//input[@id='username']")WebElement user_name;
	@FindBy (xpath="//input[@id='password']")WebElement password;
	@FindBy(xpath="//input[@class='btn btn-default'][@name='login']")WebElement Login_Button; 
	@FindBy(xpath="//button[@id='utilityLinksMenuId']")WebElement username;
	ExlsReader reader = new ExlsReader(ResourceHelper.getResourcePath("\\src\\main\\java\\Com_Automationtesting1_TestData\\TestData.xlsx"));
    String msg;
    private static Logger log = LoggerHelper.getLogger(LoginPage.class);


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




public HomePage  ClickOnLogin()
{
	try
	{
	TestUtil.ElementIsClickable(driver, Login_Button, 30);
	}
	catch(Exception e)
	{
		log.info("Login_Button is not seen within 30 sec");
	}
	if(Login_Button.isEnabled()&&Login_Button.isDisplayed()&&!Login_Button.isSelected())
	{
		TestUtil.ActionForMovetoElement(Login_Button);
		try
		{
			TestUtil.ClickEmementByJavaScriptExecutor(Login_Button);
		
		}
		catch(Exception e)
		{
			log.info("timeoutexceptionseen");
			
		
		}
	}
	else
	{
		TestUtil.ClickEmementByJavaScriptExecutor(Login_Button);
		
	}
	return new HomePage();

}



public int Frames()
{
	int size;
	size= FrameHelper.NoofFrames();
	return size;
	
}

public void EnterwithValidcredentials(String Username, String Password)

{
	
	EnterUserName(Username);
	EnterPassword(Password);

}

public String UsernameOnHomePage() 
{
	try
	{
	 WebElement username= TestUtil.VisibleOn(driver, this.username, 30);
	}
	catch(Exception e)
	{
		log.info("element is not seen within 30 sec");
	}
	

	return msg = username.getText();
} 
	
	


}
