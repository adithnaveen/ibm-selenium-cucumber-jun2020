package com.training.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.pom.ExpediaPOM;
import com.training.pom.YatraPom;
import com.training.util.DriverFactory;
import com.training.util.DriverNames;

public class YatraTest {
	

	private WebDriver driver; 
	private YatraPom ePom; 
	
	@BeforeTest
	public void setUp() {
		driver = DriverFactory.getDriver(DriverNames.CHROME); 
		ePom = new YatraPom(driver); 
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit(); 
	}
	
	
  @Test
  public void test() {
	  ePom.loadPage();
	  ePom.clickAndSendDepartFromArrival();
  }
  
  
  
  
  
  
}
