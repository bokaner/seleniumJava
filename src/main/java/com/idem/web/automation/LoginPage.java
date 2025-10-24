package com.idem.web.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	WebDriver driver;
	

	  // ✅ Step 2: Initialize elements in the constructor
  public LoginPage(WebDriver driver) {
      this.driver = driver;
      PageFactory.initElements(driver, this); // ← Initialization method
  }
	
	
	@FindBy(id="email")
	private WebElement username;
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginbutton;
	
	
	public void username_valid()
	{
		username.sendKeys("ujji.sharma@gmail.com");
		
	}

	public void password_valid()
	{
		password.sendKeys("sadasdasdsad");
		
	}
	
	public void loginwithcorrect_valid()
	{
		loginbutton.click();
		
	}
	
	
	
}
