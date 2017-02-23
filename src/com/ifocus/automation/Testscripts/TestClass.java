package com.ifocus.automation.Testscripts;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ifocus.automation.Pages.LoginPage;
import com.ifocus.automation.Utilities.Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class TestClass {
	@BeforeClass
	public void setup()
	{
		Utilities.startAppiumServer();
	}
	
	public AndroidDriver driver;
	@Test(priority=1,enabled=true)
	public void Test() throws InterruptedException, IOException
	{
				
	 //driver = BaseClass.startAndroidDriver();
				
		LoginPage loginPage = new LoginPage(driver);
		loginPage.registerVoot(driver);
		
		driver.navigate().back();
		//driver.sendKeyEvent(AndroidKeyCode.BACK);
		Thread.sleep(3000);
		driver.findElementByName("YES").click();
		
									
	}

}
