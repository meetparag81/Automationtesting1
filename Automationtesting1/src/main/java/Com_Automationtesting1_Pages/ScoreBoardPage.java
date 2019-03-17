package Com_Automationtesting1_Pages;

import java.util.ArrayList;
import java.util.List;

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
	private String names;
	private WebElement element;
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
	
	public String SaveAllOptions(WebElement RiskOfLossoptions,WebElement ImPactOFLossoptions, WebElement ReasonOfLeavingoptions )
	{
		
		int sum = 3;
		while(sum>0)
		{
			for(int i =0;i<=4;i++)
			{
				String names = RiskOfLossoptions();
				
				try
				{
				TestUtil.VisibleOn(driver, RisofLoss, 20);
				}
				catch(TimeoutException e)
				{
					log.info("Element- RisofLoss is not seen with in 30 sec");
				}
				switch(names)
				{
				case"Low":
					TestUtil.ActionForMovetoElement(RiskOfLossoptions).click().build().perform();
					break;
				case"Medium":
					try
					{
					TestUtil.VisibleOn(driver, RisofLoss, 20);
					}
					catch(TimeoutException e)
					{
						log.info("Element- RisofLoss is not seen with in 30 sec");
					}
					TestUtil.ActionForMovetoElement(RiskOfLossoptions).click().build().perform();
					break;
					}
				
				TestUtil.ActionForMovetoElement(ReasonOfLeavingoptions);
				
				
					
					
				}
				
			
			}
		
		
		
		
		
		TestUtil.ActionForMovetoElement(RiskOfLossoptions).click().build().perform();
		TestUtil.ActionForMovetoElement(element);
		return msg;
		
	}
	public String RiskOfLossoptions()
	
	{
		for(int i =0;i<=4;i++)
		{
			
			boolean flag= false;
			int count = 0;
			List<WebElement> Lossoptions = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
			 names = Lossoptions.get(i).getText();
			count++;
			if(count<0)
			{
			flag= true;	
			}
			
		}
		
		return names;
		
	}
	
	public WebElement RiskOfLossoptionsElement()
	{
		for(int i =0;i<=4;i++)
		{
			
			boolean flag= false;
			int count = 0;
			List<WebElement> Lossoptions = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
			  element = Lossoptions.get(i);
			count++;
			if(count<0)
			{
			flag= true;	
			}
		
		}
		return element;
		
	}
	
public String ImPactOFLossoptions()
	
	{
		for(int i =0;i<=4;i++)
		{
			
			boolean flag= false;
			int count = 0;
			List<WebElement> Lossoptions = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
			 names = Lossoptions.get(i).getText();
			count++;
			if(count<0)
			{
			flag= true;	
			}
			
		}
		
		return names;
		
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
