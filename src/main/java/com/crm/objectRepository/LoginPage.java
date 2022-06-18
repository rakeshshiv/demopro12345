package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	//Declaration
@FindBy(name="user_name")
private WebElement usernametextedit;

@FindBy(name="user_password")
private WebElement passwordtextedit;

@FindBy(id="submitButton")
private WebElement submitbuttonclick;

//initialization

public LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

//utilization

public WebElement getUsernametextedit() {
	return usernametextedit;
}

public WebElement getPasswordtextedit() {
	return passwordtextedit;
}

public WebElement getSubmitbuttonclick() {
	return submitbuttonclick;
}
/**
 * click on submit button
 * @param username
 * @param password
 */
public void loginToAppli(String username,String password)
{
	usernametextedit.sendKeys(username);
	passwordtextedit.sendKeys(password);
	submitbuttonclick.click();
}


}