package com.training.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.util.DriverFactory;
import com.training.util.DriverNames;
import com.training.util.Sleep;

public class JavaScriptScrollTest {
	
	private WebDriver driver;
	private String url; 
	@BeforeTest
	public void setUp() {
		this.driver = DriverFactory.getDriver(DriverNames.CHROME);
		url="http://naveenks.com/selenium/RegForm.html"; 
	}
	
	@AfterTest
	public void tearDown() {
		Sleep.sleepSeconds(3);
		driver.quit(); 
	}
	
  @Test
  public void test() {
	  driver.get(url);
	  System.out.println("Scoroll... 400 px ");
	  
	  // javascritpexeucte is an instance of driver; 
	  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver; 
	  
	  jsExecutor.executeScript("window.scrollTo(0,400)"); 
	  
	  System.out.println("After Scroll...");
	  
	  driver.findElement(By.id("zipcode")).sendKeys("12345");
  }
}
