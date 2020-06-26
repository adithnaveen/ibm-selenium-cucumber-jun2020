package com.training.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.training.util.DriverFactory;
import com.training.util.DriverNames;
import com.training.util.Sleep;

public class ActionClassTest {

	private WebDriver driver;
	private String url;
	private String url2; 

	@BeforeTest
	public void setUp() {
		this.driver = DriverFactory.getDriver(DriverNames.CHROME);
		url = "https://www.amazon.in/";
		url2 = "http://tasyah.com/"; 
	}

	@AfterTest
	public void tearDown() {
		Sleep.sleepSeconds(3);
		driver.quit();
	}

	@Test
	@Ignore
	public void test1() {
		driver.get(url);
		WebElement menuItem = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[1]")); 
		WebElement subMenuItem = driver.findElement(By.xpath("//*[@id=\"nav-al-right-links\"]/a[2]/span"));
		
		Actions actions = new Actions(driver); 
		
		actions.moveToElement(menuItem).perform();
		
		// when you want click 
		// click with driver directly 
		// you can use action for clicking 
		
		actions.moveToElement(subMenuItem).click(); 
		
	}
	
	

	@Test
	public void test2() {
		driver.get(url2);
		WebElement menuItem = driver.findElement(By.xpath("//*[@id=\"menu_category_Menu_VIfWm2LT_439\"]/a/span/span")); 
		WebElement subMenuItem = driver.findElement(By.xpath("//*[@id=\"menu_category_Menu_VIfWm2LT_439\"]/ul/li[1]/a/span"));
		
		
		Actions actions = new Actions(driver); 
		
		actions.moveToElement(menuItem).perform();
		
		// when you want click 
		// click with driver directly 
		// you can use action for clicking 
		
		actions.moveToElement(subMenuItem).click(); 
		
	}
}











