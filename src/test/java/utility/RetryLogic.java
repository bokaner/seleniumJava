package utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class RetryLogic implements IRetryAnalyzer {

	
	int initial_count=0;
	int retry_count=2;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub

		
		Reporter.log( "Since the testcase is  got failed it has to be Retried 2 times");

		if (initial_count<retry_count)
		{
			initial_count++;
            Reporter.log(" Retrying test '" + result.getName() + "' (Attempt " + (initial_count + 1) + ")");

			return true;
		}
		// TODO Auto-generated method stub
		
        Reporter.log(" Test '" + result.getName() + "' failed after " + (retry_count + 1) + " attempts.");

		return false;
	}
	
	

}
