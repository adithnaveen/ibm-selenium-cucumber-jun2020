package com.training.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.pom.ExpediaPOM;
import com.training.pom.RegisterPOM;
import com.training.util.DriverFactory;
import com.training.util.DriverNames;
import com.training.util.Sleep;

public class RegFormTest1 {

	private WebDriver driver; 
	private RegisterPOM rPOM; 
	private String url; 
	
	@BeforeTest
	public void setUp() {
		driver = DriverFactory.getDriver(DriverNames.CHROME); 
		rPOM = new RegisterPOM(driver); 
		url = "http://naveenks.com/selenium/RegForm.html"; 
		driver.get(url);
	}
	
	@AfterTest
	public void tearDown() {
		Sleep.sleepSeconds(3);
		driver.quit();
	}
	
	@Test
	public void bookingTicket() {
		
		rPOM.clickTravelFrom();
		rPOM.selectFavoriteLanguage();
	
	}
	
	
}
