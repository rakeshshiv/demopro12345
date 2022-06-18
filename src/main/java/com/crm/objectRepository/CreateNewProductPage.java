package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage
{
	//declaration
@FindBy(name = "productname")
private WebElement productnametextedit;

@FindBy(name = "button")
private WebElement clickonsavelkpbutton;

//initialization
public CreateNewProductPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//utilization
public WebElement getProductnametextedit() 
{
	return productnametextedit;
}

public WebElement getClickonsavelkpbutton() 
{
	return clickonsavelkpbutton;
}

public void fillAllproductDetails()
{
	 productnametextedit.sendKeys("SAMSUNG_MOBILE_GH110");
	 clickonsavelkpbutton.click();
}

}
