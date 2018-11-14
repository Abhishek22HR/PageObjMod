package com.crm.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.TestBase.TestBase;
import com.crm.pages.ContactPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.pages.TaskPage;
import com.crm.utils.TestUtil;

public class TaskPageTest extends TestBase {
	
	TestUtil testutil;
	LoginPage loginPage;
	HomePage homepage;
	ContactPage contactpage;
	TaskPage taskpage;
	
	
	
	public TaskPageTest(){
		super();	
	}
	
	Logger log= Logger.getLogger(TaskPageTest.class);
	
	@BeforeMethod
	public void setup() throws InterruptedException{
	Initialization();
	testutil = new TestUtil();
	//contactpage = new ContactPage();
	taskpage = new TaskPage();
	loginPage = new LoginPage();
	homepage = loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
	testutil.switchToFrame();
	//contactpage = homepage.clickonContactlink();
	taskpage=homepage.clickonTasklink();
	log.info("Yes");
	}
	
	
    @Test(priority=1)
	public void verifyTasklabelTest(){
	Assert.assertTrue(taskpage.verifyTasklabel(), "Task label is missing on the page");
		log.warn("Warning");
	}
    
    
    @Test(priority=2)
	public void clickonExpandbuttonTest(){
    taskpage.clickonexpandbutton();	
    log.fatal("...");
    log.debug("Code");
    }
	

	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
	
	
    

}


