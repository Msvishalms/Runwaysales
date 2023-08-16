package com.crm.GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * This method is used to get random number
	 * @author Admin
	 * @return
	 */
	public int getRandomNum()
	{
		Random random = new Random();
		int value = random.nextInt(500);
		return value;
	}
	/**
	 * This method is used to get system date
	 * @return
	 */
	public String getsystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	/**
	 * This method is used to get system date in format
	 * @return
	 */
	public String getsimpleSystemDateFormat()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy hh-MM-ss");
		Date date = new Date();
		String systemDateFormat = dateFormat.format(date);
		return systemDateFormat;
	}
}
