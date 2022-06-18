package com.crm.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.genricutilities.Excelutilities;

public class DataProviderForBusTicketAppliTest
{
@Test(dataProvider = "provideBookingDataTest")
public void busTicket(String src,String dst )
{
	System.out.println("From"+src+"to"+dst);
}
@DataProvider
public Object[][] provideBookingDataTest() throws Throwable
{
	Object[][]objarray=new Object[3][2];
	Excelutilities excel = new Excelutilities();
			objarray[0][0]=excel.readDataFromExcel("dataprovidertest", 1, 1);
			objarray[0][1]=excel.readDataFromExcel("dataprovidertest", 1, 2);;
			
			objarray[1][0]=excel.readDataFromExcel("dataprovidertest", 2, 1);;
			objarray[1][1]=excel.readDataFromExcel("dataprovidertest", 2, 2);;
			
			objarray[2][0]=excel.readDataFromExcel("dataprovidertest", 3, 1);;
			objarray[2][1]=excel.readDataFromExcel("dataprovidertest", 3, 2);;
			
			return objarray;
}

}
