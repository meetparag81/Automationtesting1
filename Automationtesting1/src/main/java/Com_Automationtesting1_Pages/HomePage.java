package Com_Automationtesting1_Pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com_Automationtesting1_ExcelUtil.ExlsReader;
import Com_Automationtesting1_TestUtil.TestUtil;
import Com_Automationtesting1_testbase.TestBase;
import com_Automationtesting1_Helper.ResourceHelper;
import com_Automationtesting1_Logger.LoggerHelper;

public class HomePage extends TestBase 
{
	@FindBy(xpath = "//div[@class='surjUserPhotoName']")
	WebElement UserName;
	@FindBy(id = "bizXSearchField-I")
	WebElement Search;
	@FindAll({ @FindBy(xpath = "//ul[@class='sapMSelectList sapMSuL']/li") })
	List<WebElement> usernames;
	@FindBy(xpath = "(//div[@class='fullName'])[2]")
	WebElement UserDisplayName;
	@FindBy(xpath = "//span/span[@class='sapMBtnContent']/bdi[text()='Scorecard']")
	WebElement Scoreboard;
	@FindBy(xpath = "//span[text()='Org Chart Fields/Talent Flags']")
	WebElement TalentFlag;
	ExlsReader reader = new ExlsReader(
			ResourceHelper.getResourcePath("\\src\\main\\java\\Com_Automationtesting1_TestData\\TestData.xlsx"));
	int size;
	private String msg;
	private static Logger log = LoggerHelper.getLogger(TestBase.class);

	HomePage() 
	{
		PageFactory.initElements(driver, this);
	}

	public int GiveSearchInput(String input) 
	{
		
		try {
			Thread.sleep(5000);
		} 
		catch (InterruptedException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		TestUtil.ActionForMovetoElement(Search);
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			log.info("InterruptedException is seen");
		}
		Search.sendKeys(input);
		size = usernames.size();

		return size;
	}

	public String SearchAndClickTheUser()
	{
		GiveSearchInput(reader.getCellData("HomePage", "name", 2)); 
		
		for (WebElement user: usernames)
		{
			if(user.getText().equals(reader.getCellData("HomePage", "name", 2)));
			{
				TestUtil.ActionForMovetoElement(user).click().build().perform();
				break;
			}
						
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e)
		{
			
		}
		TestUtil.ActionForMovetoElement(UserDisplayName);
		msg= UserDisplayName.getText();
		return msg;
		
		
		
		
		
		
	}

	public void SearchTheResult() {

		try {
			TestUtil.VisibleOn(driver, Search, 30);
		} catch (TimeoutException e) {
			log.info("Element- Search is not seen with in 30 sec");
		}		
		TestUtil.ActionForMovetoElement(Search).click();
		TestUtil.ActionForMovetoElement(Search).sendKeys(reader.getCellData(" Sarch", "SearchInput", 2));
		log.info("search input added");

	}

	public ScoreBoardPage ClickONScoreBoadrd() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			log.info("InterruptedException is seen");
		}
		TestUtil.ActionForMovetoElement(Scoreboard).click().build().perform();

		return new ScoreBoardPage();

	}

	public String ScoreBoardPageTile() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestUtil.ActionForMovetoElement(TalentFlag);
		msg = TalentFlag.getText();

		return msg;

	}

}
