package com.crm.contacts;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.genricutilities.BaseClass;
import com.crm.objectRepository.CreateContactInfoPage;
import com.crm.objectRepository.CreateContactsPage;
import com.crm.objectRepository.CreateNewContactsPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

		public class CreateContactsTest extends BaseClass
		{
		
			@Test 
			
			public void  createContactsTest() throws Throwable 
			{
				 String firstname = excel.readDataFromExcel("sheet1", 1, 4);	
				 String lastname = excel.readDataFromExcel("sheet1", 1, 5);	
				 String mobilenumber = excel.readDataFromExcel("sheet1", 1, 7);	
				 String exp_contactname = excel.readDataFromExcel("sheet2", 1, 1);	
					
				//click on contact text link
				HomePage hpage = new HomePage(driver);
				hpage.getContactstextlink().click();
				
				//click on create new contact lookup img
				CreateContactsPage createpage=new CreateContactsPage(driver);
				createpage.getClickoncreatelkpimg().click();
				
				//click on drop down enter the first name and last name and mobile number
				CreateNewContactsPage createnewpage=new CreateNewContactsPage(driver);
			    createnewpage.enterFirstNameTextEdit(firstname, lastname, mobilenumber);
			    createnewpage.clickSaveButton();
			    
				//click on create contact info page
				CreateContactInfoPage createinfopage=new CreateContactInfoPage(driver);
				String contactinfo = createinfopage.getTitleText();
				
				
				SoftAssert soft=new SoftAssert();
				soft.assertTrue(contactinfo.contains(exp_contactname));
				System.out.println("create contact test is pass");
				soft.assertAll();
			 
								
			}

		}


	


