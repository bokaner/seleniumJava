package com.idem.web.automation;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.BaseClass;
import utility.ListenersLogic;
import utility.RetryLogic;

@Listeners(ListenersLogic.class)

public class TestCase2_loginToAmazonandLogout extends BaseClass {

	 @Test(retryAnalyzer = RetryLogic.class,
	          description = "Login to Amazon with valid credentials")	
	 
	 
	 public void withcredential() throws InterruptedException
	{
		 
		 
	AmazonHomePage homepage	=new AmazonHomePage(driver);
	
	homepage.hoverOnAccountAndList(driver);
	homepage.SigninFromHomepage();
	//Thread.sleep(2000);

	AmazonSignInPage loginpage=new AmazonSignInPage(driver);
	Thread.sleep(1000);
	loginpage.validUsername();
	loginpage.continueClick();
	Thread.sleep(1000);
	loginpage.validPassword();
	loginpage.signButton();
	
	Thread.sleep(1000);
	homepage.hoverOnAccountAndList(driver);
	Reporter.log( "User try to click on Logout->Hovover on Account and List");
	
	Thread.sleep(1000);
	homepage.signout();
	
	Reporter.log( "User should logged out from  the application successfully");



	}
	
}
