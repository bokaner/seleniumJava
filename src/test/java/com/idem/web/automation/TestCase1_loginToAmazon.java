package com.idem.web.automation;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;
import utility.BaseClass;
//import utility.CommonMethods;
import utility.ListenersLogic;
import utility.RetryLogic;



@Listeners(ListenersLogic.class)
public class TestCase1_loginToAmazon extends BaseClass {

	@Test(retryAnalyzer = RetryLogic.class,
	          description = "Login to Amazon with valid credentials")
	public void withcredential() throws InterruptedException
	{
		
	AmazonHomePage homepage	=new AmazonHomePage(driver);
	
	homepage.hoverOnAccountAndList(driver);
	homepage.SigninFromHomepage();
//	Thread.sleep(2000);

	Reporter.log("From  Home page-hoverover on Accounts and list->click on Sign button ");

	AmazonSignInPage loginpage=new AmazonSignInPage(driver);
//	Thread.sleep(1000);
	loginpage.validUsername();
	loginpage.continueClick();
	//Thread.sleep(1000);
	loginpage.validPassword();
	loginpage.signButton();
	
   // String actual_text=CommonMethods.getTitle();
    
   // Assert.assertEquals(false, false);

	//Assert.assertEquals("Amazon", actual_text);
	//Assert.assertEquals(, "");
	
	Reporter.log( "User should logged into the application successfully");

	


	}

	
}
