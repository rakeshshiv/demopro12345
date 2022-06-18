package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
	@FindBy(xpath ="//img[@src='themes/softed/images/btnL3Add.gif']")
    private WebElement createorglookupimg;
	
	//initialization
	
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getCreateOrgLookupImg()
	{
		return createorglookupimg;
	}
	public void clickOnCreateOrgLookUp()
	{
		createorglookupimg.click();
	}
}
