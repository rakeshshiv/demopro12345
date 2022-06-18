package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactInfoPage 
{
	//declaration
@FindBy(xpath = "//span[@class='dvHeaderText']")
private WebElement TitleText;

//initialization
public CreateContactInfoPage (WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

//utilization

public String  getTitleText() 
{
	return TitleText.getText();
}
}
