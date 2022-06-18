package com.crm.usingGenericScript;

import java.util.List;
import java.util.TreeSet;
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

public class FetchDataFromAIndustryTypescendingOrderTest {

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
		//int random = java.getRandomNumber();
		
		//fetching the firstname from excelsheet
		
		String Firstname = excel.readDataFromExcel("sheet1", 1, 4);
		
		//fetching the Lastname from excelsheet
		
		//String Lastname = excel.readDataFromExcel("sheet1", 1, 5)+random;
		
		//fetching the phone number from the excel
		
		//String Number = excel.readDataFromExcel("sheet2", 1, 0);
		
		//fetching organisation name from excel
		
		String orgname = excel.readDataFromExcel("sheet1", 1, 6);
		
		//fetching phone nmber from excel
		
		String pho = excel.readDataFromExcel("sheet2", 1, 0);
		
		
		
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
	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	WebElement option = driver.findElement(By.name("industry"));
	driver.findElement(By.name("accountname")).sendKeys(orgname);
	driver.findElement(By.name("phone")).sendKeys(pho);
	Select sel=new Select(option);
	List<WebElement> opt = sel.getOptions();
	TreeSet<String> set=new TreeSet<String>();
	for(WebElement options:opt)
	{
		String pt = options.getText();
		System.out.println(pt);
	
	
	}
}
}
	
	
	
	
		
		
		


