package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genricutilities.Webdriverutility;

public class CreateNewOrganisationPage extends Webdriverutility
{
//declaration
	@FindBy(name = "accountname")
	private WebElement organisationTextEdit;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement createdorganizationname;
	
	//initialization
	
	public CreateNewOrganisationPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	
	public WebElement getOrganisationTextEdit()
	{
		return organisationTextEdit;
	}
	
	public WebElement getCreatedorganizationname() {
		return createdorganizationname;
	}

	public WebElement getSaveButton()
	{
		return saveButton;
	}
	
	public WebElement getIndustryDropDown()
	{
		return industryDropDown ;
	}
	
	public void setOrganisationTextEdit(WebElement organisationTextEdit)
	{
		this.organisationTextEdit=organisationTextEdit;
	}
	
	public void enterOrgInfo(String organistionName)
	{
		organisationTextEdit.sendKeys(organistionName);
	}
	public void selectIndustry(String industry)
	{
		selectDropDown(industryDropDown,industry);
	}
	public void selectType(String type)
	{
		selectDropDown(typeDropDown,type);
		saveButton.click();
	}
	
	
}
