package Com_Automationtesting1_Pages;



import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com_Automationtesting1_ExcelUtil.ExlsReader;
import Com_Automationtesting1_TestUtil.TestUtil;
import Com_Automationtesting1_testbase.TestBase;
import com_Automationtesting1_Helper.ResourceHelper;
import com_Automationtesting1_Logger.LoggerHelper;

public class HomePage extends TestBase
{
	@FindBy(xpath="//div[@class='surjUserPhotoName']")WebElement UserName;
	@ FindBy(id="bizXSearchField-I")WebElement Search;
	
	ExlsReader reader = new ExlsReader(ResourceHelper.getResourcePath("\\src\\main\\java\\Com_Automationtesting1_TestData\\TestData.xlsx"));
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


	public void SearchTheResult() 
	{
	
		try
		{
			TestUtil.VisibleOn(driver, Search, 30);
		}
		catch(TimeoutException e)
		{
			log.info("Element- Search is not seen with in 30 sec");
		}
		
		TestUtil.ActionForMovetoElement(Search).sendKeys(reader.getCellData(" Sarch", "SearchInput", 2));
		log.info("search input added");
		
		
	
		
	}
	
	
	

}
