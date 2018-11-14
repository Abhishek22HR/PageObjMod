package com.crm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.TestBase.TestBase;
import com.crm.pages.DealsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utils.TestUtil;

public class DealsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	DealsPage dealpage;
	
	public DealsPageTest() {
		 	super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		Initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("Username"),prop.getProperty("Password"));
		testutil.switchToFrame();
		dealpage = homepage.clickonNewDealsLink();
		
	}
	
	
	@Test(priority=1)
	public void verifyDealText() {
		//dealpage= homepage.clickonNewDealsLink();
		boolean dealslabel = dealpage.verifyDealltext();
		Assert.assertTrue(homepage.verifyCorrectUsername());
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	

}
