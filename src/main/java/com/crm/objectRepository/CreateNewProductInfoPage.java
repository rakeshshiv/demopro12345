package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductInfoPage
{
	//Declaration
@FindBy(xpath = "//span[@class='lvtHeaderText']")
private WebElement titletext;

//initialization
public CreateNewProductInfoPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//utilization

public String getTitletext() 
{
	return titletext.getText();
}

}
