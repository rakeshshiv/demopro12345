package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.genricutilities.Webdriverutility;

public class CreateNewContactsPage extends Webdriverutility
{
//declaration
	@FindBy(name = "firstname")
	private WebElement firstnametextedit;
	
	@FindBy(name = "lastname")
	private WebElement lastnametextedit;
	
	@FindBy(name = "mobile")
	private WebElement mobilenumbertextedit;
	
	@FindBy(name = "button")
	private WebElement savebutton;

	@FindBy(name = "salutationtype")
	private WebElement selectdropdown;
	
	@FindBy(name = "emailoptout")
	private WebElement clickcheckbox;
	
	@FindBy(name="notify_owner")
	private WebElement notifyOwner;
	
	@FindBy(name = "portal")
	private WebElement portal;
	
	@FindBy(name = "reference")
	private WebElement reference;
	
	//initialization
	public CreateNewContactsPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	//utilization
	
	public WebElement getFirstnametextedit() 
	{
		return firstnametextedit;
	}
	
	public WebElement getLastnametextedit()
	{
		return lastnametextedit;
	}
	
	public WebElement getSavebutton() 
	{
		return savebutton;
	}

	public WebElement getMobilenumbertextedit()
	{
		return mobilenumbertextedit;
	}
	
	  public WebElement getPortal() 
	  {
			return portal;
	  }	
	public WebElement getSelectdropdown() 
	{
		return selectdropdown;
	}

	public WebElement getClickcheckbox() 
	{
		return clickcheckbox;
	}
	
	public WebElement getNotifyOwner() {
		return notifyOwner;
	}
	
	public WebElement getReference()
	{
		return reference;
	}
	

	//Bussiness scenarios
	
	public void enterFirstNameTextEdit(String fname,String lname,String mobno)
	{
		firstnametextedit.sendKeys(fname);
		lastnametextedit.sendKeys(lname);
		mobilenumbertextedit.sendKeys(mobno);
	}
	
	public boolean clickCheckBox()
	{
		clickcheckbox.click();
		return clickcheckbox.isSelected();
	}
	
	public boolean notifyOwner()	
	{
		notifyOwner.click();
		return notifyOwner.isSelected();
	}
	
	public boolean clickReference()
	{
		reference.click();
		return reference.isSelected();
	}
	
	public boolean Portal()
	{
		 portal.click();
		 return portal.isSelected();
	}
	
	public void clickSaveButton() 
	{
		 savebutton.click();
	}
	
	}	
	

