package com.crm.test;

import org.testng.Assert;


import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


import org.testng.annotations.Test;

import com.crm.TestBase.TestBase;
import com.crm.pages.ContactPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utils.TestUtil;



public class ContactPageTest extends TestBase {
	
	TestUtil testutil;
	LoginPage loginPage;
	HomePage homepage;
	ContactPage contactpage;
	String sheetName = "Sheet1";

	
	
	
	public ContactPageTest(){
		super();	
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
	Initialization();
	testutil = new TestUtil();
	contactpage = new ContactPage();
	loginPage = new LoginPage();
	homepage = loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
	//TestUtil.runTimeInfo("error", "login successful");
	testutil.switchToFrame();
	contactpage = homepage.clickonContactlink();
	
	
	}
	
	@Test(priority=1)

	public void verifycontactlabelTest(){
	Assert.assertTrue(contactpage.verifyContaclabel(), "Contact label is missing on the page");
		
	}
	
	
	//@Test(priority=2)
	public void selectcontactTest() throws InterruptedException{
		Thread.sleep(1000);
		contactpage.selectcontactsbyname("Abhi h");	
	}
	
    // @Test(priority=3)
	public void selectmultiplecontactTest(){
	contactpage.selectcontactsbyname("Abhi M");
	contactpage.selectcontactsbyname("Meera A");
		
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	//@Test(priority=4, dataProvider="getCRMTestData")
	public void CreateNewContactTest(String title,String firstname, String lastname, String Company) {
		
		
		homepage.clickonNewcontactlink();
	//	contactpage.CreateNewDoc("Mr.", "Ram", "Sham", "GG");
		contactpage.CreateNewDoc(title, firstname, lastname, Company);

	
		}
	
	
	
			
	
	
	@AfterMethod
	public void teardown(){
	
		driver.quit();
	}
	
	
	
	

}

