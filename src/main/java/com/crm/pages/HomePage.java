package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.TestBase.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: ABHISHEK H R')]")
	WebElement usernamelabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	

	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement Newcontactlink;
	
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//a[contains(text(), 'New Deal')]")
	WebElement NewDealslink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasklink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifypagetitle(){
		return driver.getTitle();	
	}
	
	public boolean verifyCorrectUsername(){
		return usernamelabel.isDisplayed();
	}
	
	public ContactPage clickonContactlink(){
		contactslink.click();
		return new ContactPage();
	}
	
	public DealsPage clickonDealslink(){
		contactslink.click();
		return new DealsPage();
	}
	
	public TaskPage clickonTasklink(){
		tasklink.click();
		return new TaskPage();
	}
	
	public ContactPage clickonNewcontactlink() {
	Actions act=new Actions(driver);
	act.moveToElement(contactslink).build().perform();
	  Newcontactlink.click();
	return new ContactPage();
	}
	
	
	public DealsPage clickonNewDealsLink() {
	Actions act=new Actions(driver)	;
	act.moveToElement(NewDealslink).build().perform();
	NewDealslink.click();
	return new DealsPage();
	
	}
	
	
}


