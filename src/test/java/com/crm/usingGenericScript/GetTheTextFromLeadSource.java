package com.crm.usingGenericScript;

import java.util.concurrent.TimeUnit;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTheTextFromLeadSource {

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver=null;
		Excelutilities excel = new Excelutilities();
		Fileutility file = new Fileutility();
		Javautility java = new Javautility();
		Webdriverutility webdriv=new Webdriverutility();
		
		//get the properties of property file using getpropertykey method
		
		String URL = file.getpropertykeyvalue("url");
		String USERNAME = file.getpropertykeyvalue("username");
		String PASSWORD = file.getpropertykeyvalue("password");
		String BROWSER = file.getpropertykeyvalue("browser");
		
		
		//To get the random number
		int random = java.getRandomNumber();
		
		//fetching the firstname from excelsheet
		
				String Firstname = excel.readDataFromExcel("sheet1", 1, 4)+random;
				
				//fetching the Lastname from excelsheet
				
				String Lastname = excel.readDataFromExcel("sheet1", 1, 5)+random;
				
				//fetching the phone number from the excel
				
				//String Number = excel.readDataFromExcel("sheet2", 1, 0);
				
				
				//Launch the browser
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
				       driver = new ChromeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					 driver = new FirefoxDriver();
				}
				else
				{
				         driver = new ChromeDriver();
				}

				//user implicitly wait condition
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
				//enter the url
				driver.get(URL);
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				driver.findElement(By.linkText("Contacts")).click();
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
				WebElement name = driver.findElement(By.name("salutationtype"));
				Select sel=new Select(name);
				sel.selectByVisibleText("Mr.");
				driver.findElement(By.name("firstname")).sendKeys(Firstname);
				driver.findElement(By.name("lastname")).sendKeys(Lastname);
				WebElement lead = driver.findElement(By.name("leadsource"));
				webdriv.selectDropDown(lead, "Cold Call");
				//Select sele=new Select(lead);
				//List<WebElement> text = sele.getOptions();
				//for(WebElement load:text)
				//{
					//String test = load.getText();
					//System.out.println(test);
				}
				

	}


