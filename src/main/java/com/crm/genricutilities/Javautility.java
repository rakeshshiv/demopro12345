package com.crm.genricutilities;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Admin
 *
 */

public class Javautility {

		/**
		 * its used to generate a random number
		 *@return
		 */
		
	public int getRandomNumber()
	{
		Random random = new Random();
		int randnum = random.nextInt(1000);
		return randnum;
	}
	/**
	 * its used to get systemDateandTime in IST Format
	 *@return
	 */
	public String getSystemDateandTimeInISTFormat()
	{
		Date date = new Date();
		String dateandtime = date.toString();
		String YYYY = dateandtime.split("")[5];
		String dd = dateandtime.split("")[2];
		@SuppressWarnings("deprecation")
		int MM = date.getMonth()+1;
		
		 String finaldate = YYYY+" "+dd+" "+MM;
		return finaldate;
	}
	
}

