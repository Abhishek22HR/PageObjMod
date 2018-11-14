package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.TestBase.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(name ="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up)]")
	WebElement signupbtn;
	
	
	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement Logo;
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean Image(){
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("auth-box marketing-box")));
		return Logo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException{
		Thread.sleep(1000);
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(1000);
	//	WebDriverWait wait = new WebDriverWait(driver, 30);
	//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='btn btn-small']")));
		
		loginBtn.click();
		
		return new HomePage();
	}
	

}

