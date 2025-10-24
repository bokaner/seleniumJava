package com.idem.web.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSignInPage    {
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	 
 	
	//FluentWait<> wait1=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
	FluentWait<WebDriver> wait1 = new FluentWait<>(driver)
			.withTimeout(Duration.ofSeconds(10))
	        .pollingEvery(Duration.ofSeconds(1))
	        .ignoring(NoSuchElementException.class);

	@FindBy(id="ap_email_login")
	private WebElement username;
	
	
	@FindBy(xpath="//span[@id='continue']")
	private WebElement continueButton;
	
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(id="signInSubmit")
	private WebElement signInSubmit;
	
	
	public void validUsername() {
		wait.until(ExpectedConditions.visibilityOf(username));
		//signIn.click();
		username.sendKeys("7999538335");
	}
	
	public void validPassword() {
		// TODO Auto-generated method stub
		
		wait.until(ExpectedConditions.visibilityOf(password));

		password.sendKeys("Test@1234");

	}

	
	public void continueClick() {
		
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));

		continueButton.click();
	}

	public void signButton() {
		
		wait1.until(ExpectedConditions.elementToBeClickable(signInSubmit));

		signInSubmit.click();
	}
	
	
	

	public AmazonSignInPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(driver, this);
	}

	
	
	public void getTitlePage()
	{
		
	}
	
	

}
