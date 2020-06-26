package com.training.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterizationDataproviderTest {
  @Test(dataProvider = "userData")
  public void myTest(String userName, String password) {
	  
	  System.out.println("your selenium code goes here.... ");
	  
	  System.out.println("UserName: " + userName);
	  System.out.println("Password: " + password);
//	  assertEquals(actual, expected);
  }
  
  // data provider is the method
  @DataProvider(name="userData")
  public Object[][] getMyData(){
	  return new Object[][] {
		 // you data from mysql has to be invoked here 
		  {"inba", "india"}, 
		  {"sarada", "holland"},
		  {"shrikanth", "karnataka"}
	  }; 
  } 
  
}
