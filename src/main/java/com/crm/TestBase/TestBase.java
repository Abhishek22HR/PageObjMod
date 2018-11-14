package com.crm.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.utils.TestUtil;
import com.crm.utils.WebEventListener;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver a_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		try{
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "//src//main//java//com//crm//utils//config.properties" );
			prop.load(ip);
	} catch(FileNotFoundException e){
		e.printStackTrace();
	}catch (IOException e){
		e.printStackTrace();
	}
		}

	public void Initialization(){
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver" , "C://Users//C5249440//Desktop//Selenium 1//Eclipse//Driver//chrome//chromedriver.exe");
		    driver = new ChromeDriver();
		}
			else if(browsername.equals("ff")){
			System.setProperty("webdriver.gecko.driver" , "C://Users//C5249440//Desktop//Selenium 1//Eclipse//Driver//chrome//geckodriver.exe" );
		    driver = new FirefoxDriver();
		    }
		
		a_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		a_driver.register(eventListener);
       driver = a_driver;
		
		
		
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("URL"));
	
	}
		
	
	
	}
	
	
	
	
	
	



