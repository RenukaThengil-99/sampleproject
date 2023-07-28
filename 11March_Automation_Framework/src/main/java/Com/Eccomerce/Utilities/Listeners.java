package Com.Eccomerce.Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Com.Ecommerce.BaseClass.Eccommerce_BaseClass;

public class Listeners extends Eccommerce_BaseClass implements ITestListener{
	
	ExtentTest test;
	
	ExtentReports extent= ExtendReportsNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test pass");
		String testmethodname=result.getMethod().getMethodName();
		
		try {

			  extentTest.get().addScreenCaptureFromPath(GenericUtils.GetScreenShotAs(testmethodname, driver),testmethodname);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		
		String testmethodname=result.getMethod().getMethodName();
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		try {

		  extentTest.get().addScreenCaptureFromPath(GenericUtils.GetScreenShotAs(testmethodname, driver),testmethodname);
		}catch(IOException e) {
			e.printStackTrace();
		}
}
	
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}
}
	