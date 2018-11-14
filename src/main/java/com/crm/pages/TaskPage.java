package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.TestBase.TestBase;

public class TaskPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(), 'Tasks')] ")
	WebElement Tasklabel;
	
	
	@FindBy(xpath="//input[@id = 'btn_cs_search' ]")
	WebElement Expandbtn;
	
	
	

	public TaskPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyTasklabel(){
		return Tasklabel.isDisplayed()	;
	}
	
	
	public TaskPage clickonexpandbutton(){
		Expandbtn.click();
		return new TaskPage();
	}
	
	
	
	
	

	
	

	
	
			

			
}


