package com.crm.createProductCampaignSave;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.objectRepository.CreateNewProductInfoPage;
import com.crm.objectRepository.CreateNewProductPage;
import com.crm.objectRepository.CreateProductsPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
public class CreateProductCampaignSaveTest
{
	public static void main(String[] args)throws IOException 
	{
	FileInputStream fis=new FileInputStream("src/test/resources/Data.Properties.txt");
	Properties prop = new Properties();
	prop.load(fis);	
	
String USERNAME = prop.getProperty("username");
String PASSWORD = prop.getProperty("password");
String URL = prop.getProperty("url");
String BROWSER = prop.getProperty("browser");
WebDriver driver=null;

String expected_product_name = "SAMSUNG_MOBILE_GH110";



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
//Wait for page to load
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

//enter the application
driver.get(URL);

//Login to Application
LoginPage loginpage = new LoginPage(driver);
loginpage.loginToAppli(USERNAME, PASSWORD);

//click on product text link
HomePage hpage = new HomePage(driver);
hpage.getProdctstextlink().click();

// click on create product icon
CreateProductsPage createproduuctpage=new CreateProductsPage(driver);
createproduuctpage.getClickoncreateprodctlkpimg().click();

//Enter the product name
CreateNewProductPage createnewproductpage=new CreateNewProductPage(driver);
createnewproductpage.fillAllproductDetails();

CreateNewProductInfoPage productinfo=new CreateNewProductInfoPage(driver);
String title = productinfo.getTitletext();
//WebElement text = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
//String actual_product_name = text.getText();
if(title.contains(expected_product_name))
{
	System.out.println("product is created");
}
else
{
	System.out.println("product is not created");
}
WebElement moreelemet = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
Actions act= new Actions(driver);
act.moveToElement(moreelemet).perform();
driver.findElement(By.name("Campaigns")).click();
driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
driver.findElement(By.name("campaignname")).sendKeys("CAMPAIGN_SAMSUNG");
driver.findElement(By.xpath("//img[@alt='Select']")).click();
Set<String> ids = driver.getWindowHandles();
ArrayList<String> ALLIDS = new ArrayList<String>(ids);
String child_id = ALLIDS.get(1);
driver.switchTo().window(child_id);
driver.findElement(By.xpath("//a[.='SAMSUNG_MOBILE_GH110']")).click();
String parent_id = ALLIDS.get(0);
driver.switchTo().window(parent_id);
driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
WebElement campaininfo = driver.findElement(By.id("tblCampaignInformation"));
String all_campaintext = campaininfo.getText();
if(all_campaintext.contains(expected_product_name))
{
	System.out.println("campaign is added successfully");
System.out.println("test case is pass");
}
else
{
	System.out.println("campaign is not added");
	System.out.println("test case is fail");
}
driver.close();

	}
}



