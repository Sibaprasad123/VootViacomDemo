package com.ifocus.automation.Logging;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.ifocus.automation.Utilities.Utilities;

import io.appium.java_client.android.AndroidDriver;



public class ListenerClass extends TestListenerAdapter {
	static Logger logger = Logger.getLogger("VootLogger");
	
	
	@Override
	public void onStart(ITestContext testContext) {		
		//super.onStart(testContext);
		System.out.println("\n***********************************TEST SUITE EXECUTION STARTS**********************************");
		logger.info("\n***********************************EXECUTION STARTS**********************************");
	}
	
	@Override
	public void onTestStart(ITestResult tr) {		
		//super.onTestStart(result);
		//logger.info("\n-----------------------------------------------------------------------------------");
		logger.info("\n**********TEST --> "+tr.getName()+" :STARTED ***********");
		//logger.info("-----------------------------------------------------------------------------------");
		//System.out.println("\n-----------------------------------------------------------------------------------");
		System.out.println("\n*********TEST --> "+tr.getName()+" : STARTED**********");
		//System.out.println("-----------------------------------------------------------------------------------\n");
	}
	
	
	@Override
	public void onTestSuccess(ITestResult tr) {		
		//super.onTestSuccess(tr);
		//logger.info("\n-----------------------------------------------------------------------------------");
		logger.info("\n***********TEST --> "+tr.getName()+" :PASSED **************");
		//logger.info("-----------------------------------------------------------------------------------");
		//System.out.println("\n-----------------------------------------------------------------------------------");
		System.out.println("\n**************TEST --> "+tr.getName()+" : PASSED***********");
		//System.out.println("-----------------------------------------------------------------------------------\n");
		//Utilities.captureScreenshot(driver);
		
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {		
		//super.onTestFailure(tr);
		//logger.info("\n-----------------------------------------------------------------------------------");
		logger.info("\n*****************TEST --> "+tr.getName()+" :FAILED **************");
		//logger.info("-----------------------------------------------------------------------------------");
		//System.out.println("\n-----------------------------------------------------------------------------------");
		System.out.println("\n**************TEST --> "+tr.getName()+" : FAILED***********");
		//System.out.println("-----------------------------------------------------------------------------------\n");
		
	}
	
	
	@Override
	public void onFinish(ITestContext testContext) {		
		//super.onFinish(testContext);
		logger.info("\n***********************************EXECUTION ENDS**********************************");
		System.out.println("\n***********************************EXECUTION ENDS**********************************");
	}
	

}
