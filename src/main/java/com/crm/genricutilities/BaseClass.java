package com.crm.genricutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;
import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver sdriver;
public WebDriver driver;
public DataBaseUtility dlib=new DataBaseUtility();
public Excelutilities excel=new Excelutilities();
public Fileutility file=new Fileutility();
public Webdriverutility wlib=new Webdriverutility();
public Javautility java=new Javautility();

/**
 * connecting to database
 */
@BeforeSuite(groups ={"smokeTest","regressionTest"})
public void dbConfig()
{
	dlib.connectToDB();
}
/**
 * Launching the browser
 * @throws Throwable
 */
//@Parameters("BROWSER")
@BeforeClass(groups ={"smokeTest","regressionTest"})
public void launchTheBrowser() throws Throwable
{
	String BROWSER = file.getpropertykeyvalue("browser");
    String URL = file.getpropertykeyvalue("url");
    
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
    
    //implicitly wait
    sdriver=driver;
    wlib.WaitForPageToLoad(driver);
    
    //enter the url of the application
    driver.get(URL);
    
    //maximize the screen
  //  driver.manage().window().maximize();
}
/**
 * login to application
 * @throws Throwable
 */
    @BeforeMethod(groups ={"smokeTest","regressionTest"})
    public void loginToApplin() throws Throwable
    {
    	String USERNAME = file.getpropertykeyvalue("username");
    	String PASSWORD = file.getpropertykeyvalue("password");
    	
    	LoginPage lpage=new LoginPage(driver);
    	lpage.loginToAppli(USERNAME, PASSWORD);
    }
    
    /**
     * sign out from application12345
     */
    @AfterMethod(groups ={"smokeTest","regressionTest"})
    public void logoutFromApplin()
    {
    HomePage hpage=new HomePage(driver);
    hpage.getSignoutlink();
    }
    
    /**
     * close the browser
     */
    @AfterClass(groups ={"smokeTest","regressionTest"})
    public void closeTheBrowser()
    {
    	driver.quit();
    }
    
    @AfterSuite(groups ={"smokeTest","regressionTest"})
    public void closeDBconfig()
    {
    	dlib.closeDB();
    }
    
    
    
    
}


