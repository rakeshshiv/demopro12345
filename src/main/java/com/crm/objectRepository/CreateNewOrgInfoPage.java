package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrgInfoPage 
{
//declaration
@FindBy(xpath = "//span[@class='dvHeaderText']")
private WebElement organizationtitle;

//initialization

public CreateNewOrgInfoPage (WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//utilization

public String getOrganizationtitle()
{
	return organizationtitle.getText();
}

}
