package com.crm.contacts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.genricutilities.BaseClass;
import com.crm.objectRepository.CreateContactsPage;
import com.crm.objectRepository.CreateNewContactsPage;
import com.crm.objectRepository.HomePage;

@Listeners(com.crm.genricutilities.ItestListenerImptn.class)
public class EmailOptOutBoxIsEnableorNotTest extends BaseClass {
	@Test(groups= {"regressionTest"})
	public void emailOptOutBoxIsEnableorNot() throws Throwable 
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

		//click on email check box
		CreateNewContactsPage createContacts=new CreateNewContactsPage(driver);
		WebElement checkBox = createContacts.getClickcheckbox();
		checkBox.click();
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(checkBox.isSelected());
		System.out.println(" check box is enabled");
		soft.assertAll();
	}

}
