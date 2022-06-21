package com.crm.contacts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.genricutilities.BaseClass;
import com.crm.objectRepository.CreateContactsPage;
import com.crm.objectRepository.CreateNewContactsPage;
import com.crm.objectRepository.HomePage;

public class NotifyOwnerBoxIsEnableorNotTest extends BaseClass
{
	@Test(retryAnalyzer =com.crm.genricutilities.ReTryImpclass.class )
//@Test(groups= {"smokeTest"})

	public void notifyOwnerBoxIsEnableorNot() throws Throwable
	{
	   String firstname = excel.readDataFromExcel("sheet1", 1, 4);	
	   String lastname = excel.readDataFromExcel("sheet1", 1, 5);	
	   String mobilenumber = excel.readDataFromExcel("sheet1", 1, 7);	
	
		//Click on Contacts
		HomePage homepage=new HomePage(driver);
		homepage.getContactstextlink().click();
		
		//Click on Create contact lookup image
	     CreateContactsPage createcontactspage=new CreateContactsPage(driver);
		createcontactspage.getClickoncreatelkpimg().click();
		
		//Fill all contact details
		
		CreateNewContactsPage createContact=new CreateNewContactsPage(driver);
		createContact.enterFirstNameTextEdit(firstname, lastname, mobilenumber);
		
		//click on Notifyer check box
		CreateNewContactsPage createContacts=new CreateNewContactsPage(driver);
		WebElement checkBox = createContacts.getNotifyOwner();
		checkBox.click();
		Assert.assertEquals(checkBox.isSelected(), true);
		System.out.println(" notifyer box is enabled");	
	}

	}


