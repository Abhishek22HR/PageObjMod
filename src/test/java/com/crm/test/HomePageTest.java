package com.crm.test;




import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.TestBase.TestBase;
import com.crm.pages.ContactPage;
import com.crm.pages.DealsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.pages.TaskPage;
import com.crm.utils.TestUtil;



public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactPage contactpage;
	TaskPage taskpage;
	DealsPage dealPage;
	
	
	

	public HomePageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		Initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("Username"), prop.getProperty("Password"));	
		testutil.switchToFrame();
	}
	
//   @Test(priority=1)
	public void verifyHomePageTitleTest(){
	String homepagetitle = homepage.verifypagetitle();
	Assert.assertEquals(homepagetitle,"CRMPRO","Home page title not matched");
	}
	
	
  // @Test(priority=2)
	public void verifyUsernameTest(){
	//testutil.switchToFrame();   
	Assert.assertTrue(homepage.verifyCorrectUsername());	
	}
   
  // @Test(priority=3)
   public void clickContactLinkTest(){
	// testutil.switchToFrame();
	contactpage = homepage.clickonContactlink();
	   
   }
   
  // @Test(priority=4)
   public void clickonTaskLink(){
	 taskpage = homepage.clickonTasklink(); 
	   
   }
	
	
	@Test(priority=5)
   public void clickonDealsLink() {
	 dealPage = homepage.clickonDealslink();
	
   }
	
	@Test(priority=6)
	public void clcikonNewDelasLink() {
		
		dealPage = homepage.clickonNewDealsLink();
	}
	
	
	

	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
	
	
	
}

