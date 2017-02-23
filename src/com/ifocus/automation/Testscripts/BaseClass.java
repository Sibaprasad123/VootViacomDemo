package com.ifocus.automation.Testscripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

	static Logger logger = Logger.getLogger("VootLogger");

	public static WebDriver startSeleniumDriver() {
		System.out.println("Logging in to Voot Webapplication");
		logger.info("Logging in to Voot Webapplication");
		System.setProperty("webdriver.chrome.driver", ".//Testdata//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		return driver;
	}

	public static AndroidDriver<MobileElement> startAndroidDriver() throws MalformedURLException {

		AndroidDriver driver;

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "4.4");
		capabilities.setCapability("deviceName", "Note2");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.tv.v18.viola");
		capabilities.setCapability("appActivity", "com.tv.v18.viola.activities.VIOSplashScreenActivity");

		/*
		 * capabilities.setCapability("BROWSER_NAME", "Android");
		 * capabilities.setCapability("VERSION", "6.0.1");
		 * capabilities.setCapability("deviceName", "Motoxplay");
		 * capabilities.setCapability("platformName", "Android");
		 * capabilities.setCapability("appPackage", "com.tv.v18.viola");
		 * capabilities.setCapability("appActivity",
		 * "com.tv.v18.viola.activities.VIOSplashScreenActivity");
		 */

		// capabilities.setCapability("appPackage", "com.android.settings");
		// capabilities.setCapability("appActivity",
		// "com.android.settings.Settings");

		// driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
		// capabilities);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		logger.info("Voot app launched successfully in mobile");
		System.out.println("\n***Voot app opened successfully in mobile device**");
		return driver;
	}

	public static AndroidDriver startMobileWebApp() throws MalformedURLException {

		AndroidDriver driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", "appium");
		capabilities.setCapability("browserName", "Android");
		capabilities.setCapability("version", "6.0");
		capabilities.setCapability("deviceName", "MotoG");
		capabilities.setCapability("platformName", "Android");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		return driver;

	}

}