package com.idem.web.automation;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utility.BaseClass;
import utility.ListenersLogic;
import utility.RetryLogic;
@Listeners(ListenersLogic.class)

public class TestCase3_loginToAmazonSearchProducts  extends BaseClass{

	
	 @Test(retryAnalyzer = RetryLogic.class,
	          description = "Login to Amazon with valid credentials")
	public void withcredential() throws InterruptedException
	{
	AmazonHomePage homepage	=new AmazonHomePage(driver);
	
	homepage.hoverOnAccountAndList(driver);
	homepage.SigninFromHomepage();
	Thread.sleep(2000);
	Reporter.log( "From Home Page->Hovover on Account and List->click on Sign Button ");


	AmazonSignInPage loginpage=new AmazonSignInPage(driver);
	Thread.sleep(2000);
	loginpage.validUsername();
	loginpage.continueClick();
	loginpage.validPassword();
	loginpage.signButton();
	Reporter.log( "Login was Successfull with valid username  and Valid password");

	homepage.searchingProduct();
	
	Reporter.log("Searched  the product  searched successfully");

	
	
	
	
	//homepage.hoverOnAccountAndList(driver);
	//homepage.signout();
	
	


	}
	
}
