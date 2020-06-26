package com.training.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.util.Sleep;
import com.training.waits.WaitTypes;

public class ExpediaPOM {

	private WebDriver driver;
	private WaitTypes wait; 
	
	public ExpediaPOM(WebDriver driver) {
		this.driver = driver; 
		this.wait = new WaitTypes(driver); 
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div/div/div[2]/div/figure/div[3]/div/div/div/ul/li[2]/a" )
	private WebElement flightsTab; 
	
	
	public void clickFlightstab() {
		flightsTab.click(); 
	}

	public void clickFlyFrom() {
		System.out.println("in clickFlyFrom - ");
		By xpath = By.xpath("//*[@id=\"location-field-leg1-origin-menu\"]/div[1]/button");  
		wait.clickWhenReady(xpath, 10); 
		System.out.println(" in clickFlyFrom - 2 ");
		
	}
	
	public void sendPartialFlyFrom(String partialFlyFrom) {
		System.out.println("in -sendPartialFlyFrom - 1 ");
		By id = By.id("location-field-leg1-origin");
		
		wait.clickWhenReady(id, 10);
		
		driver.findElement(By.id("location-field-leg1-origin")).click();
		driver.findElement(By.id("location-field-leg1-origin")).clear();
		driver.findElement(By.id("location-field-leg1-origin")).sendKeys(partialFlyFrom);
		
	}
	
	public List<String> getFlyFrom() {
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"location-field-leg1-origin-menu\"]/div[2]/ul/li"));
		
		List<String> flyFromServer = new ArrayList<String>(); 
		
		for(WebElement temp : elements) {
			System.out.println(temp.getText());
			flyFromServer.add(temp.getText()); 
			
		}
		
		return flyFromServer; 
	}

	public void enterFormDetails() {
		Sleep.sleepSeconds(2);
		clickFlyFrom(); 
		Sleep.sleepSeconds(2);
		sendPartialFlyFrom("benga");
		// get all the possible values 
		List<String> flyFrom = this.getFlyFrom();
		Sleep.sleepSeconds(2);
		driver.findElement(By.xpath("//*[@id=\"location-field-leg1-origin-menu\"]/div[2]/header/section/div/button")).click();
		
		for(String temp: flyFrom) {
			clickFlyFrom();
			driver.findElement(By.id("location-field-leg1-origin")).sendKeys(temp);
			
			Sleep.sleepSeconds(3);
			driver.findElement(By.xpath("//*[@id=\"location-field-leg1-origin-menu\"]/div[2]/header/section/div/button")).click();
		}
		
	}
	
	
}
