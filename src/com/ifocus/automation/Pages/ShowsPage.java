package com.ifocus.automation.Pages;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ifocus.automation.Utilities.Utilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
public class ShowsPage {
	static Logger logger = Logger.getLogger("VootLogger");
	
	@FindBy(name = "Open Drawer")
	public WebElement MenuTab;
	
	@FindBy(name = "SHOWS")
	public WebElement ShowsTab;
	
	@FindBy(name = "ALL SERIES")
	public WebElement AllSeries;
	
	
	@FindBy(name = "Cookery Show")
	public WebElement CookeryShowBtn;
	
	
	@FindBy(name = "Flavours Of Gujarat")
	public WebElement FlavoursOfGujarat;
	
	@FindBy(id = "com.tv.v18.viola:id/img_article_play_button")
	public WebElement vplayBtn;
	
	@FindBy(id = "com.tv.v18.viola:id/txt_article_video_duration")
	public WebElement vtimeline1;
	
	@FindBy(id = "com.tv.v18.viola:id/player_total_time")
	public WebElement vtimeline2;
	
	@FindBy(id = "com.tv.v18.viola:id/btn_clip_play")
	public WebElement playBtn;
	
	@FindBy(className = "android.view.View")
	public WebElement videoViewer;
	
	
	@FindBy(id = "com.tv.v18.viola:id/img_list_item")
	public WebElement playListItem;
	
	@FindBy(id = "com.tv.v18.viola:id/video_player_close_btn")
	public WebElement videoClose;
	
	
	@FindBy(id = "com.tv.v18.viola:id/img_det_close")
	public WebElement videoBackBtn;
	
	
	@FindBy(id = "com.tv.v18.viola:id/video_title")
	public WebElement videoTitle;
	
	public ShowsPage(AndroidDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}
	public void playlist(AndroidDriver driver) throws InterruptedException, IOException
	{
		
		Utilities.explicitWaitClickable(driver, MenuTab, 20);
		MenuTab.click();
		Utilities.explicitWaitClickable(driver, ShowsTab, 20);
		ShowsTab.click();
		Utilities.explicitWaitClickable(driver, AllSeries, 20);
		AllSeries.click();
		
		Utilities.explicitWaitClickable(driver, CookeryShowBtn, 30);
		CookeryShowBtn.click();
		Utilities.explicitWaitClickable(driver, FlavoursOfGujarat, 20);
		FlavoursOfGujarat.click();
		System.out.println("Playing the first video in Flavours of Gujarath");
		logger.info("Playing the first video in Flavours of Gujarath");
		Thread.sleep(5000);
		String xpath ="//android.widget.TextView[@resource-id='com.tv.v18.viola:id/txt_title_tile']";
		
		WebElement screen = driver.findElementByClassName("android.widget.FrameLayout");
		Utilities.verticalSwipe(driver,screen,xpath);
		String title1=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.tv.v18.viola:id/txt_title_tile']")).getText();
		System.out.println("Selected video title: "+title1);
		logger.info("Selected video title: "+title1);
		String time1=vtimeline1.getText();
		
		Utilities.explicitWaitClickable(driver, vplayBtn, 20);
		vplayBtn.click();
		Thread.sleep(45000);
		Utilities.pauseVideo(driver,videoViewer);
		
		String time2=vtimeline2.getText();
		
		Boolean flag=time1.equals(time2);
		if(flag)
			System.out.println("Validated video timeline");
		System.out.println("Expected timeline: "+time1);
		System.out.println("Actual timeline: "+time2);
		logger.info("Expected timeline: "+time1);
		logger.info("Actual timeline: "+time2);
		logger.info("Validated video timeline");
		String title2=videoTitle.getText();
		Boolean flag1=title1.equals(title2);
		if(flag1)
			System.out.println("Validated video title");
		logger.info("Validated video title");
		System.out.println("Expected video title: "+title1);
		System.out.println("Actual video title: "+title2);
		logger.info("Expected video title: "+title1);
		logger.info("Actual video title: "+title2);
		Thread.sleep(5000);
		
		Utilities.horizontalSwipe(driver,screen);
		System.out.println("Swiped horizonatally from right to left");
		logger.info("Swiped horizonatally from right to left");
		Utilities.captureScreenshot(driver);
				
		/*String highlighted="//android.widget.RelativeLayout[@id='id: com.tv.v18.viola:id/playlist_overlay']";
		List<WebElement> imglist=driver.findElementsByClassName("android.widget.RelativeLayout");
		int i;
		for(i=0;i<imglist.size();i++)
		{
			if (driver.findElements(By.xpath(highlighted)).size()>0)
			break;
			
		}
		//String title3=driver.findElementsByXPath("//android.widget.LinearLayout").get(i).getText();
		System.out.println("highlighted row: "+i);
		logger.info("highlighted row: "+i);
		List<WebElement> titles=driver.findElementsByXPath("//android.widget.LinearLayout/android.widget.TextView");
		System.out.println("No of titles: "+titles.size());
		logger.info("No of titles: "+titles.size());
		for(int j=0;j<titles.size();j++)
		{
			System.out.println(titles.get(j).getText());
			logger.info(titles.get(j).getText());
		}
		
		*///System.out.println("Video title highlighted on the playlist: "+title3);
		Utilities.explicitWaitClickable(driver, playListItem, 20);
		
		playListItem.click();
		Thread.sleep(45000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		
		/*Utilities.pauseVideo(driver, videoViewer);
		//videoViewer.click();
  		videoClose.click();
  		System.out.println("Done first close");
  		try{
  		
  			Utilities.pauseVideo(driver, videoViewer);
  			videoClose.click();
  		}
  		catch(Exception e)
  		{
  			System.out.println("Video is already closed");
  			logger.info("Video is already closed");
  			
  		}*/
		Utilities.explicitWaitClickable(driver, videoBackBtn, 20);
		videoBackBtn.click();
	}
	
}
