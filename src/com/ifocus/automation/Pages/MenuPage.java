package com.ifocus.automation.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ifocus.automation.Utilities.Utilities;

import io.appium.java_client.android.AndroidDriver;

public class MenuPage {
	Logger logger = Logger.getLogger("VootLogger");
	@FindBy(name = "Open Drawer")
	public static WebElement MenuTab;
	
	@FindBy(name = "SETTINGS")
	public static WebElement Settings;
	@FindBy(name = "Sign Out")
	public static WebElement signoutBtn;
	
	String signout="//android.widget.TextView[@text='Sign Out']";
		
	@FindBy(className = "android.widget.LinearLayout")
	public WebElement sscreen;
	
	public MenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void Logout(AndroidDriver driver) throws InterruptedException
	{
		Utilities.explicitWaitClickable(driver, MenuTab, 20);
		MenuTab.click();
		Utilities.explicitWaitClickable(driver, Settings, 20);
		Settings.click();
		//driver.scrollTo("SIGN OUT");
		Utilities.verticalSwipe(driver, sscreen, signout);
		Utilities.explicitWaitClickable(driver, signoutBtn, 20);
		signoutBtn.click();
		System.out.println("successfully logged out from Voot App");
		logger.info("successfully logged out from Voot App");
		Thread.sleep(5000);
	}
}
