package com.ifocus.automation.Pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ifocus.automation.Utilities.Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class VootKidsPage {

	Logger logger = Logger.getLogger("VootLogger");
	@FindBy(name = "Open Drawer")
	public WebElement MenuTab;

	@FindBy(name = "SETTINGS")
	public WebElement Settings;

	@FindBy(name = "VOOT KIDS")
	public WebElement VootKidsTab;

	@FindBy(className = "android.view.View")
	public WebElement videoViewer;

	@FindBy(id = "com.tv.v18.viola:id/img_kid_character")
	public WebElement VootKidsdVideo;

	@FindBy(id = "com.tv.v18.viola:id/img_play")
	public WebElement VootKidsdVideoPlay;

	@FindBy(name = "Navigate up")
	public WebElement exitBtn;

	@FindBy(id = "com.tv.v18.viola:id/video_player_close_btn")
	public WebElement videoClose;

	public VootKidsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void vootkidsVideo(AndroidDriver driver) throws InterruptedException, IOException {

		Utilities.explicitWaitClickable(driver, MenuTab, 20);
		MenuTab.click();
		Utilities.explicitWaitClickable(driver, VootKidsTab, 20);
		VootKidsTab.click();
		System.out.println("User is in Voot Kids section");
		logger.info("User is in Voot Kids section");
		Utilities.explicitWaitClickable(driver, VootKidsdVideo, 20);
		VootKidsdVideo.click();
		Utilities.explicitWaitClickable(driver, VootKidsdVideoPlay, 30);
		VootKidsdVideoPlay.click();
		System.out.println("Playing Voot kids video");
		logger.info("Playing Voot kids video");
		Thread.sleep(45000);
		try {
			driver.findElement(By.id("com.tv.v18.viola:id/video_player_coach_cards_view_pager")).click();
		} catch (Exception e) {
			System.out.println("Shake to dismiss button is not displayed");
			logger.info("Shake to dismiss button is not displayed");
		}
		Utilities.pauseVideo(driver, videoViewer);
		Thread.sleep(8000);
		// driver.sendKeyEvent(AndroidKeyCode.BACK);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		/*
		 * Utilities.explicitWaitClickable(driver, videoClose, 10);
		 * videoClose.click();
		 */
		System.out.println("Video is closed now");
		logger.info("Video is closed now");
		Thread.sleep(3000);
		Utilities.explicitWaitClickable(driver, exitBtn, 20);
		exitBtn.click();

	}

}
