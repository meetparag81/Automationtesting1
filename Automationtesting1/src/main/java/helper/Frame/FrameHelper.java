package helper.Frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Com_Automationtesting1_testbase.TestBase;
import com_Automationtesting1_Logger.LoggerHelper;
 

public class FrameHelper extends TestBase 
{
	private static Logger log= LoggerHelper.getLogger(FrameHelper.class);

	public static int NoofFrames()
	{
		int size=driver.findElements(By.xpath("//iframe")).size();
		return size; 
		
	}
	
	/**
	 * this method will switchToFrame based on frame index
	 * @param frameIndex
	 */
	public static void switchToFrame(int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
		log.info("switched to :"+ frameIndex+" frame");
	}
	
	/**
	 * this method will switchToFrame based on frame name
	 * @param frameName
	 */
	public  static void switchToFrame(String frameName){
		driver.switchTo().frame(frameName);
		log.info("switched to :"+ frameName+" frame");
	}
	
	/**
	 * this method will switchToFrame based on frame WebElement
	 * @param element
	 */
	public static void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
		log.info("switched to frame "+element.toString());
	}
}


