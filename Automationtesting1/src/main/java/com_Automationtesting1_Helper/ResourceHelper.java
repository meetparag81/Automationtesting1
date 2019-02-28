package com_Automationtesting1_Helper;

public class ResourceHelper {
	
	public static String getResourcePath(String path) 
	{
        String basePath = System.getProperty("user.dir");
        System.out.println(basePath + path);
		return basePath + path ;
		
	}
	
	public static void main(String[] args) 
	{
		ResourceHelper.getResourcePath("\\src\\main\\java\\Com_Automationtesting1_TestData\\TestData.xlsx");
		
	}
	
	
	

}
