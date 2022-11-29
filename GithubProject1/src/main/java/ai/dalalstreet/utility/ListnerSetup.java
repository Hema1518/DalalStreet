package ai.dalalstreet.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import ai.dalalstreet.testBase.TestBase;

public class ListnerSetup extends TestBase implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result)
	{
	logger.info("TestCase execution started" + result.getName());
	}

	@Override         //....give timestand so our ss will not overlap.....System.currentTimeMillis()
	public void onTestSuccess(ITestResult result)
	{
	logger.info("TestCase execution Completed" + result.getName());
	}
    
	@Override
	public void onTestFailure(ITestResult result)
	{
    logger.info("TestCase execution Failed" + result.getName());
    ScreenshotClass.takeScreenShot(result.getName());
	logger.info("Take Screenshot");
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
	logger.info("TestCase execution Skipped" + result.getName());	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
   
}
