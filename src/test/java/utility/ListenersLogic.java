package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersLogic implements ITestListener {

    public static WebDriver driver;

    @Override
    public void onTestSuccess(ITestResult result) {
        String className = result.getTestClass().getRealClass().getSimpleName();
        String methodName = result.getMethod().getMethodName();

        Reporter.log("✅ Test Passed: " + result.getName());

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // ✅ Generic project-based path (no hardcoding)
        String baseDir = System.getProperty("user.dir") 
                + File.separator + "screenshot" 
                + File.separator + "Pass";

        new File(baseDir).mkdirs(); // ensure directory exists

        File destination = new File(baseDir + File.separator 
                + className + "_" + methodName + "_Pass_" 
                + Date_format.date_format() + ".png");

        try {
            FileHandler.copy(source, destination);
            Reporter.log("Screenshot saved: " + destination.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String className = result.getTestClass().getRealClass().getSimpleName();
        String methodName = result.getMethod().getMethodName();

        Reporter.log("❌ Test Failed: " + result.getName());

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // ✅ Generic failure path
        String baseDir = System.getProperty("user.dir") 
                + File.separator + "screenshot" 
                + File.separator + "Failed";

        new File(baseDir).mkdirs();

        File destination = new File(baseDir + File.separator 
                + className + "_" + methodName + "_Fail_" 
                + Date_format.date_format() + ".png");

        try {
            FileHandler.copy(source, destination);
            Reporter.log("Screenshot saved: " + destination.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
