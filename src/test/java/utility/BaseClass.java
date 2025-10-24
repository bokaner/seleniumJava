package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass extends ListenersLogic {

	//public WebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	public void launchBrowser(String browsername) throws InterruptedException {

		if (browsername.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			Reporter.log("Chrome Browser launched Successfully");
		}
		if (browsername.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			Reporter.log("Firefox Browser launched Successfully");

		}
		if (browsername.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
			Reporter.log("Edge Browser launched Succesfully");

		}

		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
	//	Thread.sleep(2000);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void quit() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		Reporter.log("browser closed successfully");
	}
}
