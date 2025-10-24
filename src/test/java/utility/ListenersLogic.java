package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utility.Date_format;

public class ListenersLogic implements ITestListener {

	public  static WebDriver driver;
	//public static WebDriverWait wait;

	// Date_format dm=new Date_format();

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		// get class and method name
        String className = result.getTestClass().getRealClass().getSimpleName();
        String methodName = result.getMethod().getMethodName();

		ITestListener.super.onTestSuccess(result);
		Reporter.log("Test  Case  is Pass- Listeners Logic  is started");
		
		  Reporter.log("✅ Test Passed: " + result.getName());

	        
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File
				("C:\\Users\\UJJIS\\workspace\\webAutomation\\automation\\screenshot\\Pass\\"
						+ className + "_" + methodName + "_Fail_" + Date_format.date_format() + ".png");
		// File destination=new
		// File("E:\\MKTProject\\AutomatioBatch55\\screenshotab58\\"+new
		// AmazonLogin().getClass()+format2+".png");

		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Screenshot is comppleted");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		
		// get class and method name
        String className = result.getTestClass().getRealClass().getSimpleName();
        String methodName = result.getMethod().getMethodName();

		Reporter.log("Test  Case  is Failed- Listeners Logic  is started");

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		File destination = new File("C:\\Users\\UJJIS\\workspace\\webAutomation\\automation\\screenshot\\Failed\\"
				+ className + "_" + methodName + "_Fail_" + Date_format.date_format() + ".png");
		try {
			FileHandler.copy(source, destination);
            Reporter.log("Screenshot saved: " + destination);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
