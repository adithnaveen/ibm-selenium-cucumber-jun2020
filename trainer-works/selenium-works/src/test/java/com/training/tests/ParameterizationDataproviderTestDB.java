package com.training.tests;

import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.beans.User;
import com.training.db.UserDAO;

public class ParameterizationDataproviderTestDB {
  @Test(dataProvider = "userData")
  public void myTest(User user) {
	  
	  System.out.println("your selenium code goes here.... ");
	  
	  System.out.println("UserName: " + user.getUserName());
	  System.out.println("Password: " + user.getPassword());
  }
  
  // data provider is the method
  @DataProvider(name="userData")
  public  Iterator<User> getMyData(){
	return new UserDAO().getUsers().iterator();
  } 
  
}
