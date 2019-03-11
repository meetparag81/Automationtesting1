package Com_Automationtesting1_Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com_Automationtesting1_TestUtil.TestUtil;
import Com_Automationtesting1_testbase.TestBase;
import com_Automationtesting1_Logger.LoggerHelper;

public class HomePage extends TestBase
{
	@FindBy(xpath="//div[@class='surjUserPhotoName']")WebElement UserName;
	@ FindBy(id="bizXSearchField-I")WebElement Search;
	
	
	private static Logger log = LoggerHelper.getLogger(TestBase.class);
	HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void GiveSearchInput(String input)
	{
		try
		{
		TestUtil.VisibleOn(driver, Search, 30);
		}
		catch (Exception e) 
		{
		log.info("element Search is not seen within30 sec");
		}
		TestUtil.ActionForMovetoElement(Search);
		Search.sendKeys(input);
		
		
	}
	
	public boolean HomepageTitle()
	{
		boolean flag = true;
		if( UserName.getText()=="parag borawake ‎(bparag)‎")
		{
			return flag;	
		}
		else
		{
			return flag= false;
		}
		
	}
	
	
	

}
