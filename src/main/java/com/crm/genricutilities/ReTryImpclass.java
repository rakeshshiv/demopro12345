package com.crm.genricutilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.w3c.dom.css.Counter;

public class ReTryImpclass implements IRetryAnalyzer 
{
	int counter=0;
	int retrylimit=4;

	public boolean retry(ITestResult result)
	{
		if(counter<retrylimit) 
		{
			counter++;	
			return true;
		}
		return false;
	}

}
