package com.crm.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	/**
	 * @author Admin
	 * @param Key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyFile(String Key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.filePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(Key);
		return value;
	}
}
