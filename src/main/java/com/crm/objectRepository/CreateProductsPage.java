package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductsPage 
{
	//declaration
@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement clickoncreateprodctlkpimg;
//initialization
public CreateProductsPage (WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//utilization
public WebElement getClickoncreateprodctlkpimg()
{
	return clickoncreateprodctlkpimg;
}

}
