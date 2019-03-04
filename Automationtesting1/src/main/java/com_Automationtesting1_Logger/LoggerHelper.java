package com_Automationtesting1_Logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com_Automationtesting1_Helper.ResourceHelper;

public class LoggerHelper 
{
	private static boolean root = false;
	
	public static Logger getLogger(Class cls)
	{
		if(root=false)
		{
			return Logger.getLogger(cls);
			
		}
		else
		{
		PropertyConfigurator.configure(ResourceHelper.getResourcePath("\\src\\main\\resources\\com_Automationtesting1_config\\log4j.properties"));
		root=true;
		}
		return Logger.getLogger(cls);
	
	}
	
	public static void main(String[] args) 
	{
	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	log.info("for test");
	log.info("for test");
	log.info("for test");
		
		
		
	}

}
