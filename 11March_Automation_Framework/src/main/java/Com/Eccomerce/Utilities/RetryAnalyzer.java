package Com.Eccomerce.Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	int count=0;
	int RetryLimit=3;
	
	public boolean retry(ITestResult result) {
		
		if(count<RetryLimit) {
			count++;
			return true;
		}
		return false;
	}

}
