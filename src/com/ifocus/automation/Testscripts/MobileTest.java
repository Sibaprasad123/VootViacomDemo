package com.ifocus.automation.Testscripts;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.exec.ExecuteException;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ifocus.automation.GlobalRepository.GlobalVariables;
import com.ifocus.automation.Pages.HomePage;
import com.ifocus.automation.Pages.LoginPage;
import com.ifocus.automation.Pages.MenuPage;
import com.ifocus.automation.Pages.ShowsPage;
import com.ifocus.automation.Pages.VootKidsPage;
import com.ifocus.automation.Utilities.Utilities;

import io.appium.java_client.android.AndroidDriver;


public class MobileTest {
	@BeforeClass
	public void setup() {
		Utilities.startAppiumServer();
	}

	public AndroidDriver driver;
	Logger logger = Logger.getLogger("VootLogger");

	@Test(priority = 1, enabled = false)
	public void Registration() throws InterruptedException, IOException {

		driver = BaseClass.startAndroidDriver();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.registerVoot(driver);
		Utilities.captureScreenshot(driver);
		loginPage.Logout(driver);
		
	}

	@Test(priority = 2, enabled = false)
	public void AbortRegistration() throws InterruptedException, IOException {
		// driver opening temporarily , need to comment later
		// driver = BaseClass.startAndroidDriver();

		LoginPage loginPage = new LoginPage(driver);

		loginPage.registerVoot2(driver);
		Utilities.captureScreenshot(driver);

	}

	@Test(priority = 3, enabled = true)
	public void MinimizeVoot() throws InterruptedException, IOException, AWTException {
		// driver opening temporarily , need to comment later
		driver = BaseClass.startAndroidDriver();
		System.out.println("Testing of App Background and resume");
        Thread.sleep(10000);
		HomePage homepage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(driver, GlobalVariables.email, GlobalVariables.password);
		homepage.minimize(driver);
		Utilities.captureScreenshot(driver);
		loginPage.Logout(driver);
	}

	@Test(priority = 4, enabled = false)
	public void playList() throws InterruptedException, IOException {
		// driver opening temporarily , need to comment later
		//driver = BaseClass.startAndroidDriver();
		Thread.sleep(10000);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(driver, GlobalVariables.email, GlobalVariables.password);
		ShowsPage showspage = new ShowsPage(driver);
		showspage.playlist(driver);
		Utilities.captureScreenshot(driver);
		loginPage.Logout(driver);
	}

	@Test(priority = 5, enabled = false)
	public void VootKidsVideoPlayer() throws InterruptedException, IOException {
		// driver opening temporarily , need to comment later
		// driver = BaseClass.startAndroidDriver();
		Thread.sleep(10000);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(driver, GlobalVariables.email, GlobalVariables.password);
		VootKidsPage kidspage = new VootKidsPage(driver);
		kidspage.vootkidsVideo(driver);
		Utilities.captureScreenshot(driver);
		loginpage.Logout(driver);

	}

	@Test(priority = 6, enabled = false)
	public void videoPlayerControls() throws InterruptedException, IOException {
		// driver opening temporarily , need to comment later
		//driver = BaseClass.startAndroidDriver();
		Thread.sleep(10000);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(driver, GlobalVariables.email, GlobalVariables.password);
		HomePage homepage = new HomePage(driver);
		homepage.videoPlayerControls(driver);
		Utilities.captureScreenshot(driver);
		loginPage.Logout(driver);

		// homepage.test(driver);
	}

	@AfterClass
	public void tearDown() throws ExecuteException, IOException {

		/*Utilities.generateXSLTReport();
		System.out.println("Report generated successfully");*/
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Utilities.stopAppiumServer();
		}

	}

}
