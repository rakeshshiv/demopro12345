package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactsPage 
{
//declaration
@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement clickoncreatelkpimg;

 //initialization

public CreateContactsPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//utilization

public WebElement getClickoncreatelkpimg() 
{
	return clickoncreatelkpimg;
}

}
