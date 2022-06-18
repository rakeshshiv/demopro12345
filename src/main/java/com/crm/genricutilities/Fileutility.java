package com.crm.genricutilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Admin
 *
 */

public class Fileutility {
	/**
	 * its used to get common data from property file based on the key which you have specified as a argumment
	 * @return
	 * @throws Throwable 
	 */

	public String getpropertykeyvalue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(Ipathconstants.filepath);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
        return value;
	}
}
