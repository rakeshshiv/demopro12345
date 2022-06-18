package com.crm.contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

public class ReferenceBoxisEnabledorNot extends BaseClass{
@Test(groups= {"smokeTest"})

	public void referenceBoxisEnabledorNot() throws Throwable {
		
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
		
		//click on reference check box
		CreateNewContactsPage createcontact=new CreateNewContactsPage(driver);
		WebElement checkbox = createcontact.getReference();
		checkbox.click();
		if(checkbox.isSelected())
		{
		System.out.println("Reference box is enabled");	
		}
		else
		{
		System.out.println("Reference box is disabled");
		}			  
	}
}

