package com.idem.web.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	
	@FindBy(xpath="(//a[@data-nav-role='signin'])[1]")
	private WebElement accountList;
	
	
	@FindBy(xpath="(//span[text()='Sign in'])[1]")
	private WebElement signIn;
	

	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBarText;
	
	

	@FindBy(xpath="//span[text()='Sign Out']")
	private WebElement signout;

	public void hoverOnAccountAndList(WebDriver driver)
	{
		Actions  a1 = new Actions(driver);
		
		a1.moveToElement(accountList).perform();
	}
	
	
	public void SigninFromHomepage()
	{
		wait.until(ExpectedConditions.elementToBeClickable(signIn));
		signIn.click();
	}
	
	

	public void searchingProduct()
	{
		wait.until(ExpectedConditions.visibilityOf(searchBarText));
		searchBarText.sendKeys("Shoe"+Keys.ENTER);
	}
	
	public void signout()
	{
		wait.until(ExpectedConditions.elementToBeClickable
				(signout));
		signout.click();
	}
	
	


	public AmazonHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	/*
	@FindBy(id="")
	private WebElement ;
	
	 // Click on sign-in link
    driver.findElement(By.xpath("")).click();
    
	driver.findElement(By.id("")).sendKeys("7999538335");
	Thread.sleep(2000);

	driver.findElement(By.xpath("//span[@id='continue']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@1234");
	Thread.sleep(2000);

	driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	Thread.sleep(3000);
	String Expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	//String Expected = "Amazon.in";
*/
}
