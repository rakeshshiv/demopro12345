package com.crm.createOrganization;
import java.util.Random;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.genricutilities.BaseClass;
import com.crm.objectRepository.CreateNewOrgInfoPage;
import com.crm.objectRepository.CreateNewOrganisationPage;
import com.crm.objectRepository.CreateOrganizationPage;
import com.crm.objectRepository.HomePage;
public class CreateOrganizationTest extends BaseClass
{
	@Test
	public void createOrganizationTest() throws Throwable 
	{
		
	String organization_name =excel.readDataFromExcel("sheet1", 1, 6);
	String industryname = excel.readDataFromExcel("sheet1", 1, 8);
	String type = excel.readDataFromExcel("sheet1", 1, 9);
	
	Random random=new Random();
	int randomnum = random.nextInt();

	//Click on Organization Text Link
	HomePage homepage=new HomePage(driver);
	homepage.getOrganizationtextlink().click();
	
	//Click on Create organization lookup image
	CreateOrganizationPage Createorgpage=new CreateOrganizationPage(driver);
	Createorgpage.getClickoncreatelkpimg().click();
	
	//enter the organization name
	CreateNewOrganisationPage createneworgpage=new CreateNewOrganisationPage(driver);
	createneworgpage.getOrganisationTextEdit().sendKeys(organization_name +randomnum);
	
	//click the Industry Name
	CreateNewOrganisationPage createneworgpage1=new CreateNewOrganisationPage(driver);
	 createneworgpage1.getIndustryDropDown().click();
	
	//Select the Industry name
	CreateNewOrganisationPage createneworgpage2=new CreateNewOrganisationPage(driver);
	createneworgpage2.selectIndustry(industryname);
	
	// click on save button
	CreateNewOrganisationPage createneworgpage3=new CreateNewOrganisationPage(driver);
	createneworgpage3.selectType(type);
	
	//get organization get text
	CreateNewOrgInfoPage orginfo=new CreateNewOrgInfoPage(driver);
	String orgname = orginfo.getOrganizationtitle();
	SoftAssert soft=new SoftAssert();
	soft.assertTrue(orgname.contains(organization_name));
	System.out.println("Test case script pass");
	soft.assertAll();
	
	/*if(orgname.contains(organization_name))
	{
		System.out.println("oragisation name is created");
	}
	else
	{
		System.out.println("organisation name is not created");
	}*/
	
	
}
}

