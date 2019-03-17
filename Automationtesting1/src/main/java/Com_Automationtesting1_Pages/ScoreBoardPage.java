package Com_Automationtesting1_Pages;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com_Automationtesting1_ExcelUtil.ExlsReader;
import Com_Automationtesting1_TestUtil.TestUtil;
import Com_Automationtesting1_testbase.TestBase;
import com_Automationtesting1_Helper.ResourceHelper;
import com_Automationtesting1_Logger.LoggerHelper;


public class ScoreBoardPage extends TestBase
{
	@FindBy(xpath="//span[text()='Org Chart Fields/Talent Flags']//following::span[3]")WebElement EditButton;
	@FindBy(xpath="//span[text()='Org Chart Fields/Talent Flags'][1]")WebElement TitleofTalentflagdialog;
	@FindBy(xpath="//bdi[text()='Risk of Loss']//following::span[@tabindex=-1][1]")WebElement RisofLoss;
	private String msg;
	ExlsReader reader  = new ExlsReader(ResourceHelper.getResourcePath("\\src\\main\\java\\Com_Automationtesting1_TestData\\TestData.xlsx"));
	private static Logger log = LoggerHelper.getLogger(ScoreBoardPage.class);
	
	
	
	
	public ScoreBoardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ChangeTalentFlagsPageDialogTitle()
	{
		TestUtil.ActionForMovetoElement(EditButton).click().build().perform();
		TestUtil.ActionForMovetoElement(TitleofTalentflagdialog);
		
		return msg=TitleofTalentflagdialog.getText();
		
	}
	
	public void SaveAllOptions(WebElement RiskOfLossoptions,WebElement ImPactOFLossoptions, WebElement ReasonOfLeavingoptions )
	{
		try
		{
		TestUtil.VisibleOn(driver, RisofLoss, 20);
		}
		catch(TimeoutException e)
		{
			log.info("Element- RisofLoss is not seen with in 30 sec");
		}
		TestUtil.ActionForMovetoElement(RiskOfLossoptions).click().build().perform();
		TestUtil.ActionForMovetoElement(ImPactOFLossoptions).click().build().perform();
		TestUtil.ActionForMovetoElement(ReasonOfLeavingoptions).click().build().perform();
		
	}

	public  ArrayList<Object[]> GetDiffrentOptions() 
	{
		ExlsReader reader = null;

		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try {
			reader = new ExlsReader(ResourceHelper.getResourcePath("\\src\\main\\java\\Com_Automationtesting1_TestData\\TestData.xlsx"));
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		int count = reader.getRowCount("ScoreBoardPage");
		for(int i= 2; i<=count;i++)
		{
			WebElement RiskOfLossoptions = driver.findElement(By.xpath("//ul[@role='listbox']/li[" + i + "]"));
			WebElement ImPactOFLossoptions = driver.findElement(By.xpath("//ul[@role='listbox'])[2]/li[" + i + "]"));
			WebElement ReasonOfLeavingoptions = driver.findElement(By.xpath("(//ul[@role='listbox'])[2]/li[" + i + "] "));
			Object[] obj =  {RiskOfLossoptions,ImPactOFLossoptions,ReasonOfLeavingoptions};
			mydata.add(obj);
		}
		
		
		
		
		return mydata;
		
		
	}
	
	public void SaveChangeTalentFlagsoptions()
	{
		
		
	}
	
	
	
	

}
