package com.crm.contacts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.genricutilities.Excelutilities;
import com.crm.genricutilities.Fileutility;
import com.crm.genricutilities.Javautility;
import com.crm.genricutilities.Webdriverutility;
import com.crm.objectRepository.CreateContactsPage;
import com.crm.objectRepository.CreateNewContactsPage;
import com.crm.objectRepository.CreateNewOrganisationPage;
import com.crm.objectRepository.CreateOrganizationPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;
import com.crm.objectRepository.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactWithOrganizationTest
{
	public static void main(String[] args) throws Throwable 
	{
		Excelutilities excel = new Excelutilities();
		Fileutility file = new Fileutility();
		Javautility java = new Javautility();
		Webdriverutility wlib = new Webdriverutility();
	
	    WebDriver driver=null;
	    String URL =file.getpropertykeyvalue("url");
	    String USERNAME = file.getpropertykeyvalue("username");
	    String PASSWORD = file.getpropertykeyvalue("password");
	    String BROWSER = file.getpropertykeyvalue("browser");
	    
	    String firstname = excel.readDataFromExcel("sheet1", 1, 4);	
		 String lastname = excel.readDataFromExcel("sheet1", 1, 5);	
		 String mobilenumber = excel.readDataFromExcel("sheet1", 1, 7);	
	    
 	    String organizationName = excel.readDataFromExcel("sheet1", 1, 6);
        String industryname = excel.readDataFromExcel("sheet1", 1, 8);
        String type = excel.readDataFromExcel("sheet1",1 , 9);
	    int random = java.getRandomNumber();
	    if(BROWSER.equalsIgnoreCase("chrome"))
	    {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	   }
	   else if(BROWSER.equalsIgnoreCase("firefox"))
			{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
			}
	  else
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}
	
	 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wlib.WaitForPageToLoad(driver);
	//enter the url
	driver.get(URL);
	//enter the login page
	LoginPage loginpage = new LoginPage(driver);
	loginpage.loginToAppli(USERNAME, PASSWORD);
	//click on organization link
	HomePage homepage = new HomePage(driver);
	homepage.getOrganizationtextlink().click();
	//click on createlkpimg
	CreateOrganizationPage createOrgPage=new CreateOrganizationPage(driver);
	createOrgPage.getClickoncreatelkpimg().click();
	//create new organization page
	CreateNewOrganisationPage createorgpage = new CreateNewOrganisationPage(driver);
	createorgpage.enterOrgInfo(organizationName+random);
	//enter the industry name
	CreateNewOrganisationPage createorganisationpage = new CreateNewOrganisationPage(driver);
	createorganisationpage.selectIndustry(industryname);
	//enter the type name
	CreateNewOrganisationPage createorganpage = new CreateNewOrganisationPage(driver);
	createorganpage.selectType(type);
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//WebElement text = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	//String expect_orgnisation_name = text.getText();
	//if(expect_orgnisation_name.contains("organization_name"))
	//{
	/*	System.out.println("oragisation name is created");
	}//
	else
	{
		System.out.println("organisation name is not created");
	}*/
	//String parentWindow = driver.getWindowHandle();
	//click on contacts page
	HomePage homepge = new HomePage(driver);
	homepge.getContactstextlink().click();
	
	//click on create contact look up image
	CreateContactsPage contactpage=new CreateContactsPage(driver);
	contactpage.getClickoncreatelkpimg();
	
	CreateNewContactsPage createnewcontact=new CreateNewContactsPage(driver);
	createnewcontact.enterFirstNameTextEdit(firstname, lastname, mobilenumber);
	
	/*driver.findElement(By.xpath("(//img[@language='javascript'])[1]")).click();
	Set<String> ids = driver.getWindowHandles();
	for (String windows : ids) {
		if (!windows.contains(parentWindow)) 
		{
			driver.switchTo().window(windows);
		}*/
	}
	//driver.findElement(By.id("search_txt")).sendKeys("test");
	//driver.findElement(By.name("search")).click();
	//driver.findElement(By.xpath("//a[.='TESTYANTRA_RMG_1']")).click();
	//wlib.switchToWindow(driver, parentWindow);
	//driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	//WebElement contactdetails = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	//String actualcontactinfo = contactdetails.getText();
	//String expectedcontactname = "N R MADHUSUDAN";
	//System.out.println(actualcontactinfo);
	//if(actualcontactinfo.contains(expectedcontactname))
	//{
		//System.out.println("contact and organisation is successfully created");
	//}
	//else
	//{
		//System.out.println("contact and organisation is not created");
	//}
	}
//}
	
