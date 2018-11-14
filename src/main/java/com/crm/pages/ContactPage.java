package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.TestBase.TestBase;

public class ContactPage extends TestBase {
	
	
  @FindBy(xpath="//td[contains(text(),'Contacts')]")
  WebElement contactslabel;
  
  @FindBy(id="first_name")
  WebElement firEle;
  
  @FindBy(id="surname")
  WebElement lstEle;
  
  @FindBy(name="client_lookup")
  WebElement company;
  
  @FindBy(xpath="//input[@type = \"submit\" and @value = \"Save\"]")
  WebElement Savbtn;
  
  
  
  
  public ContactPage(){
	  PageFactory.initElements(driver, this);
  }
  
  
  public boolean verifyContaclabel(){
	 return contactslabel.isDisplayed();
 }
  
  public void selectcontactsbyname(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
  
  //public void selectcontactsbyname(String name) throws InterruptedException{
//	  driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
 // +"//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id]")).click();
	
	//  Thread.sleep(1000);
	//driver.findElement(By.xpath("//*input[@name='
	
			
		//	By.xpath("//*input").get(count).click();
//	WebElement ele=driver.findElement((By.xpath("//input[@name='contact_id' and @value='52400675']")));
//	ele.click();
	
	
	
	//input[@name=Ã¢â‚¬â„¢contact_idÃ¢â‚¬â„¢ and value='52400675'
//  }
  
  
  
  
  
  public void CreateNewDoc(String title,String Ftname, String LtName, String Comp) {
	  Select sel=new Select(driver.findElement(By.name("title")));
	  sel.selectByVisibleText(title);
	  
	  firEle.sendKeys(Ftname);
	  lstEle.sendKeys(LtName);
	  company.sendKeys(Comp);
	   
	//  Select sel1=new Select(driver.findElement(By.name("category")));
	//  sel1.selectByVisibleText(Category);
	   
	  Savbtn.click();
	  
  
  }
  
  
  
  
  

}


