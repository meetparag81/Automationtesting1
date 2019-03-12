package Com_Automationtesting1_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com_Automationtesting1_TestUtil.TestUtil;
import Com_Automationtesting1_testbase.TestBase;

public class ScoreBoardPage extends TestBase
{
	@FindBy(xpath="//span[text()='Org Chart Fields/Talent Flags']//following::span[3]")WebElement EditButton;
	@FindBy(xpath="//span[text()='Org Chart Fields/Talent Flags'][1]")WebElement TitleofTalentflagdialog;
	private String msg;
	
	
	
	
	
	public ScoreBoardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ChangeTalentFlagsPage()
	{
		TestUtil.ActionForMovetoElement(EditButton).click().build().perform();
		TestUtil.ActionForMovetoElement(TitleofTalentflagdialog);
		
		return msg=TitleofTalentflagdialog.getText();
		
	}
	
	
	
	

}
