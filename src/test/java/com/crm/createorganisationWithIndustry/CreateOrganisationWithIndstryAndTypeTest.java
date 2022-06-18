package com.crm.createorganisationWithIndustry;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationWithIndstryAndTypeTest {

	
	public static void main(String[] args) throws IOException 
	{
		//Fetching Data from Property File
		FileInputStream fis=new FileInputStream("src\\test\\resources/Data.Properties.txt");
		Properties prop = new Properties();
		prop.load(fis);
		
		//to get random number
		
	   Random random = new Random();
	   int randnum = random.nextInt(500);
		
		//Fetching data from excel sheet
		FileInputStream Fis=new FileInputStream("src\\test\\resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(Fis);
		Sheet sheet = book.getSheet("sheet1");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(1);
		String value = cell.toString();
		String orgname = value+randnum;
		
		//get the properties of property file using get property method
		
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
	String PASSWORD = prop.getProperty("password");
String BROWSER = prop.getProperty("browser");
WebDriver driver=null;

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

//enter the url application

driver.get(URL);

//enter the username

driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//enter the password
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//enter the button
driver.findElement(By.id("submitButton")).click();
//click on organisation link
driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
//click on organisation icon
driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
//enter organisation name
driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
// click on indstry
WebElement driverref = driver.findElement(By.xpath("//select[@name='industry']"));
Select sel=new Select(driverref);
sel.selectByVisibleText("Communications");
WebElement driverref1 = driver.findElement(By.xpath("//select[@class='small' and @name='accounttype']"));
Select sel1=new Select(driverref1);
sel1.selectByVisibleText("Analyst");
driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
WebElement drivertext = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
String text = drivertext.getText();
if(text.contains(orgname)) {
	System.out.println("organisation name is created");
	}
else
{
	System.out.println("organisation name is not created");
}
//click on administator link
WebElement mouseover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
Actions act=new Actions(driver);
act.moveToElement(mouseover).perform();
//click on signout button
driver.findElement(By.xpath("//a[.='Sign Out']")).click();
//close the application
driver.close();
	}
}
