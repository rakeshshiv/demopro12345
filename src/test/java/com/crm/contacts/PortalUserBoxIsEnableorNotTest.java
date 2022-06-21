package com.crm.contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.genricutilities.BaseClass;
import com.crm.objectRepository.CreateContactsPage;
import com.crm.objectRepository.CreateNewContactsPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PortalUserBoxIsEnableorNotTest extends BaseClass {
@Test(groups= {"smokeTest"})
	public void portalUserBoxIsEnableorNot() throws Throwable
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
		
		CreateNewContactsPage createContacts=new CreateNewContactsPage(driver);
		WebElement checkbox = createContacts.getPortal();
		checkbox.click();
		if(checkbox.isSelected())
		{
			System.out.println(" portal box is enabled");	
		}
		else
		{
			System.out.println("portal box is disabled");
		}
		
		
	}


	}


