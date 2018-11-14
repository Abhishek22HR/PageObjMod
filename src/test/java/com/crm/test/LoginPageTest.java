package com.crm.test;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.TestBase.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		Initialization();
		loginpage = new LoginPage();
	}
	
   @Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	
    @Test(priority=2)
	public void LogoTest(){
	boolean flag = loginpage.Image();
	Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void LoginTest() throws InterruptedException{
		homepage = loginpage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		
	}
	
    @AfterMethod
	public void teardown(){
	driver.quit();	}
	
	

}

