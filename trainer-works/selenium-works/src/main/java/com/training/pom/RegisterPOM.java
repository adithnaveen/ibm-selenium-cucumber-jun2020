package com.training.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.training.util.Sleep;
import com.training.waits.WaitTypes;

public class RegisterPOM {

	private WebDriver driver;
	private WaitTypes wait;

	public RegisterPOM(WebDriver driver) {
		this.driver = driver;
	}

	public void clickTravelFrom() {
		driver.findElement(By.id("travelfrom")).click();
		driver.findElement(By.xpath(("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[1]/td[4]/a"))).click();
	}

	public void selectFavoriteLanguage() {
		driver.findElement(By.id("tags")).click();
		driver.findElement(By.id("tags")).sendKeys("a");

		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"ui-id-1\"]/li"));
		List<String> elementStr = new ArrayList<String>(); 
		
		
		System.out.println("Got Values fromserver... ");
		for (WebElement temp : elements) {
			System.out.println(temp.getText());
			elementStr.add(temp.getText()); 
		}


		for (String temp: elementStr) {
			driver.findElement(By.id("tags")).clear();
			System.out.println("Sending " + temp);
			driver.findElement(By.id("tags")).sendKeys(temp);
			
			Sleep.sleepSeconds(2);
		}
		
		
	}

}
