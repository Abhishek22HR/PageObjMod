package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.TestBase.TestBase;

public class DealsPage extends TestBase {
	
	@FindBy(xpath="//legend[contains(text(), 'Deal')]")
	WebElement deallabel;
	
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyDealltext(){
		return deallabel.isDisplayed();
	}
	
	
	
	

	
	
}
