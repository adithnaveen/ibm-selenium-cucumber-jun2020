package com.training.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.training.util.Sleep;

public class YatraPom {

	private WebDriver driver;

	public YatraPom(WebDriver driver) {
		this.driver = driver;
	}

	public void loadPage() {
		driver.get("https://www.yatra.com/");

	}

	public void clickAndSendDepartFromArrival() {
		driver.findElement(By.id("BE_flight_origin_city")).click();
		List<String>  departList = getDepartSuggesstions ();
		
		driver.findElement(By.id("BE_flight_arrival_city")).click();
		List<String>  arrivalList = getArrivalSuggessions ();
		
		System.out.println("Sending the value " + departList);
		// sending each element 
		
		for(String temp : departList) {
			driver.findElement(By.id("BE_flight_origin_city")).clear(); 
			driver.findElement(By.id("BE_flight_origin_city")).sendKeys(temp);
			
			Sleep.sleepSeconds(3);
			
			for(String temp1: arrivalList) {
				driver.findElement(By.id("BE_flight_origin_city")).clear(); 
				driver.findElement(By.id("BE_flight_origin_city")).sendKeys(temp1);
				Sleep.sleepSeconds(3);
			}
			Sleep.sleepSeconds(3);
		}
	}
	
	public List<String> getDepartSuggesstions (){
		List<WebElement> findElements = driver.findElements(By.xpath("//*[@id=\"BE_flight_form_wrapper\"]/div[1]/div[2]/ul/li[1]/ul/li[1]/div/div/ul/div/div/div/li"));
		
		
		List<String> listDepartFrom = new ArrayList<String>();
		System.out.println("list of suggession depart ... ");
		for(WebElement element : findElements) {
			listDepartFrom.add(element.getText());
		}
		return listDepartFrom; 
	}
	
	public List<String> getArrivalSuggessions(){
	List<WebElement> findElements = driver.findElements(By.xpath("//*[@id=\"BE_flight_form_wrapper\"]/div[1]/div[2]/ul/li[1]/ul/li[1]/div/div/ul/div/div/div/li"));
		
		List<String> listDepartFrom = new ArrayList<String>();
		System.out.println("list of suggession arrival ... ");
		for(WebElement element : findElements) {
			listDepartFrom.add(element.getText());
		}
		return listDepartFrom; 
	}
	
}
