package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genricutilities.Webdriverutility;

public class HomePage extends Webdriverutility
{
	//declaration
@FindBy(linkText ="Organizations")
	private WebElement organizationtextlink;

@FindBy(linkText = "Contacts")
private WebElement contactstextlink;

@FindBy(linkText = "Products")
private WebElement prodctstextlink;

@FindBy(linkText = "More")
private WebElement moretextlink;

@FindBy(linkText = "Vendors")
private WebElement vendortext;

@FindBy(linkText = "Purchase Order")
private WebElement purchaseordertextlink;

@FindBy(linkText = "Campaigns")
private WebElement campaignstextlink;

@FindBy(xpath ="//img[@src=\"themes/softed/images/user.PNG\"]")
private WebElement administatorlink;

@FindBy(linkText = "Sign Out")
private WebElement signoutlink;

//initialization
public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

//utilization

public WebElement getOrganizationtextlink() {
	return organizationtextlink;
}

public WebElement getContactstextlink() {
	return contactstextlink;
}

public WebElement getProdctstextlink() {
	return prodctstextlink;
}

public WebElement getMoretextlink() {
	return moretextlink;
}

public WebElement getAdministatorlink() {
	return administatorlink;
}

public WebElement getSignoutlink() {
	return signoutlink;
}

public WebElement getMoreDropDown() {
	// TODO Auto-generated method stub
	return null;
}

public WebElement getVendorLnk() {
	// TODO Auto-generated method stub
	return null;
}
public void clickOnSignOutLink(WebDriver driver) {
	  Actions act=new Actions(driver);
	  act.moveToElement(administatorlink).perform();
	  signoutlink.click();
}

}
