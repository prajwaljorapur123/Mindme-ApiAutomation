package api.test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class JiraTestListener implements ITestListener{
	 @Override
	    public void onTestFailure(ITestResult result) {
	        String testName = result.getName();
	        String testClassName = result.getTestClass().getName();
	        String errorMessage = result.getThrowable().getMessage();
	        
	      

	        String summary = "Test Failure: " + testName;
	        String description = "Test " + testName + " in class " + testClassName + " failed , Error: " + errorMessage;

	       
       CreateJiraTicket.createJiraIssue(summary, description);
	//	 System.out.println("fail");
	   
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    }

	    @Override
	    public void onStart(ITestContext context) {
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	    }

}
