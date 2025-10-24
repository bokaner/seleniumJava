package com.idem.web.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Facebook_Login {
	WebDriver driver;
	
	@Test
	public void validCredentials() throws InterruptedException
	{
		
		driver= new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.username_valid();
		loginpage.password_valid();

		loginpage.loginwithcorrect_valid();

	
		
	}

}
