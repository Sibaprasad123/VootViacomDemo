package com.ifocus.automation.Pages;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ifocus.automation.Utilities.Utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class HomePage {
	
	Logger logger = Logger.getLogger("VootLogger");
	
	@FindBy(name = "Open Drawer")
	public WebElement MenuTab;
	
	@FindBy(name = "SETTINGS")
	public WebElement Settings;
	
	@FindBy(id = "com.tv.v18.viola:id/img_modal_cover")
	public WebElement defaultVideo;
		
	@FindBy(className = "android.view.View")
	//@FindBy(id = "com.tv.v18.viola:id/skin_overlay_layout")
	public WebElement videoViewer;
	
	//com.tv.v18.viola:id/skin_overlay_layout
	
	@FindBy(name = "SHOWS")
	public WebElement ShowsTab;
	
	@FindBy(id = "com.tv.v18.viola:id/player_play_pause_control")
	public WebElement playPause;
	
	@FindBy(id = "com.tv.v18.viola:id/player_play_previous")
	public WebElement previousBtn;
		
	@FindBy(id = "com.tv.v18.viola:id/player_play_next")
	public WebElement nextBtn;
	
	@FindBy(id = "com.tv.v18.viola:id/video_player_close_btn")
	public WebElement videoClose;
	
	@FindBy(name = "Sign Out")
	public WebElement signoutBtn;
	
	@FindBy(id = "com.tv.v18.viola:id/player_current_time")
	public WebElement timeLine;
		
	@FindBy(id = "com.tv.v18.viola:id/playback_option_shout")
	public WebElement shoutBtn;
	
	@FindBy(id = "com.tv.v18.viola:id/playback_option_quality")
	public WebElement qualityBtn;
	
	@FindBy(id = "com.tv.v18.viola:id/playback_option_share")
	public WebElement shareBtn;
	
	@FindBy(id = "com.tv.v18.viola:id/video_title")
	public WebElement videoTitle;
	
	@FindBy(name = "Data Saving")
	public WebElement dataSavingTab;
	
	@FindBy(name = "High Quality")
	public WebElement highQualityTab;
	
	@FindBy(name = "Auto")
	public WebElement autoTab;
	
	@FindBy(name = "Gmail")
	public WebElement gmailBtn;
		
	@FindBy(id = "com.tv.v18.viola:id/img_bottom_option_close")
	public WebElement QualityCloseBtn;
	
	@FindBy(className = "android.widget.LinearLayout")
	public WebElement sscreen;
	
	@FindBy(id= "com.tv.v18.viola:id/btn_tap_to_dismiss")
	public WebElement tapToDismiss;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		public void minimize(AndroidDriver driver) throws InterruptedException, IOException, AWTException
	{
		//tap on default video
		Utilities.explicitWaitClickable(driver, defaultVideo, 20);
		defaultVideo.click();
		System.out.println("playing the featured video in voot");
		logger.info("playing the featured video in voot");
		Thread.sleep(10000);
		try{
			tapToDismiss.click();
		}
		catch(Exception e)
		{
			System.out.println("Tap to dismiss button is not displayed");
			logger.info("Tap to dismiss button is not displayed");
		}
		Thread.sleep(45000);
		//videoViewer.click();
		Utilities.pauseVideo(driver, videoViewer);
	        System.out.println("Video is paused now");
			logger.info("Video is paused now");
          Thread.sleep(8000);
          driver.pressKeyCode(AndroidKeyCode.HOME);
		//driver.sendKeyEvent(AndroidKeyCode.HOME);
		
		System.out.println("Voot app is minimized in the mobile");
		logger.info("Voot app is minimized in the mobile");
		Thread.sleep(10000);		
		driver.findElement(By.name("Voot")).click();
		System.out.println("Voot app is resumed in the mobile");
		logger.info("Voot app is resumed in the mobile");
		Thread.sleep(10000);
		//called pause for playing back
		  Utilities.pauseVideo(driver, videoViewer);
	        System.out.println("Video is resumed now");
			logger.info("Video is resumed now");
          Thread.sleep(8000);	
          
          driver.pressKeyCode(AndroidKeyCode.HOME);
          //driver.pressKeyCode(3);
          
  		System.out.println("Voot app is minimized in the mobile");
  		logger.info("Voot app is minimized in the mobile");
  		Thread.sleep(10000); 		
  		driver.findElement(By.name("Voot")).click();
  		System.out.println("Voot app is resumed in the mobile");
  		logger.info("Voot app is resumed in the mobile");
  		Thread.sleep(10000);
  		driver.pressKeyCode(AndroidKeyCode.BACK);
  		//driver.sendKeyEvent(AndroidKeyCode.BACK);
  		/*Utilities.pauseVideo(driver, videoViewer);
  		//videoViewer.click();
  		videoClose.click();
  		System.out.println("Done first close");
  		try{
  		
  			Utilities.pauseVideo(driver, videoViewer);
  			videoClose.click();
  			System.out.println("Done second close");
  		
  		}
  		catch(Exception e)
  		{
  			System.out.println("Video is already closed");
  			logger.info("Video is already closed");
  			
  		}
  		*/
		   System.out.println("Video is closed now");
			logger.info("Video is closed now");
			Thread.sleep(5000);
		
	}
	public void videoPlayerControls(AndroidDriver driver) throws InterruptedException, IOException
	{
		Utilities.explicitWaitClickable(driver, defaultVideo, 30);
		defaultVideo.click();
		System.out.println("playing the featured video in voot");
		logger.info("playing the default video in voot");
		Thread.sleep(10000);
		try{
			tapToDismiss.click();
		}
		catch(Exception e)
		{
			System.out.println("Tap to dismiss button is not displayed");
			logger.info("Tap to dismiss button is not displayed");
		}
		Thread.sleep(35000);		
		validatePause(driver);
		validatePlay(driver);
		Thread.sleep(3000);
		Utilities.pauseVideo(driver, videoViewer);
		previousNext(driver);
		Utilities.pauseVideo(driver, videoViewer);
		System.out.println("sliding the scrubber forward");
		logger.info("sliding the scrubber forward");
		slide(driver);
		//quality(driver);
		//share(driver);
		//shout(driver);
		Thread.sleep(10000);		
		Utilities.pauseVideo(driver, videoViewer);
		Thread.sleep(10000);
		
		driver.pressKeyCode(AndroidKeyCode.BACK);
		/*Utilities.pauseVideo(driver, videoViewer);
		//videoViewer.click();
  		videoClose.click();
  		System.out.println("Done first close");
  		try{
  			Utilities.pauseVideo(driver, videoViewer);
  			videoClose.click();
  			System.out.println("Done in second close");
  		
  		}
  		catch(Exception e)
  		{
  			System.out.println("Video is already closed");
  			logger.info("Video is already closed");
  			
  		}*/
	}
	public void previousNext(AndroidDriver driver) throws InterruptedException
	{
		//videoViewer.click();
		String title1=videoTitle.getText();
		System.out.println("Featured video title is: "+title1);
		logger.info("Featured video title is: "+title1);
		if(previousBtn.isEnabled())
		{
		previousBtn.click();					
		Thread.sleep(45000);		
		Utilities.pauseVideo(driver, videoViewer);
		videoViewer.click();
		String title2=videoTitle.getText();
		System.out.println("Video title after clicking Previous button: "+title2);
		logger.info("Video title after clicking Previous button: "+title2);
		}
		else{
			System.out.println("Previous button is not enabled");
			logger.info("Previous button is not enabled");
		}
		if(nextBtn.isEnabled())
		{
		nextBtn.click();		
		Thread.sleep(45000);
		Utilities.pauseVideo(driver, videoViewer);
		videoViewer.click();
		String title3=videoTitle.getText();
		System.out.println("Video title after clicking Next button: "+title3);
		logger.info("Video title after clicking Next button: "+title3);
		}
		else{
			System.out.println("Next button is not enabled");
			logger.info("Next button is not enabled");
		}
	}
	public void slide(AndroidDriver driver) throws InterruptedException
	{
		videoViewer.click();
		String t1=timeLine.getText();
        WebElement seekBar=driver.findElement(By.id("com.tv.v18.viola:id/player_seekBar"));
        int startX = seekBar.getLocation().getX();       
        //Get vertical location of seekbar.
        int yAxis = seekBar.getLocation().getY();
        logger.info("start positionX "+startX);
        logger.info("start positionY "+yAxis);
        //Set slidebar move to position.
        // this number is calculated based on (offset + 3/4width)
        int moveToXDirectionAt = 400 + startX;
        
        //Moving seekbar using TouchAction class.
        TouchAction act=new TouchAction((MobileDriver)driver);
        act.longPress(startX,yAxis).moveTo(moveToXDirectionAt,yAxis).release().perform();
        System.out.println("Scrubber has moved forward");
        logger.info("Scrubber has moved forward");
     //Thread.sleep(3000);
     //videoViewer.click();
     String t2=timeLine.getText();
     int newx=startX+400;
     int newy=yAxis;
          
     moveToXDirectionAt = newx-200;
     System.out.println("Timeline before sliding: "+t1+" ,Timeline after sliding: "+t2);
     logger.info("Timeline before sliding: "+t1+" ,Timeline after sliding: "+t2);
     act.longPress(newx,newy).moveTo(moveToXDirectionAt,newy).release().perform();
     System.out.println("Scrubber has moved backward");
     logger.info("Scrubber has moved backward");
	}
     public void validatePause(AndroidDriver driver) throws InterruptedException
     {
    	 videoViewer.click();
 		Dimension size = driver.manage().window().getSize();
 		//	System.out.println(size);
 	        
 	        MultiTouchAction maction = new MultiTouchAction((MobileDriver) driver);
 	        
 	        int x5 = size.width / 2;
 	        int y5 = size.height / 2;
 	        
 	        TouchAction action51 = new TouchAction((MobileDriver)driver).tap(x5, y5).waitAction(500);
 	        
 	        maction.add(action51).add(action51).perform();
 	        System.out.println("Video is paused now");
 			logger.info("Video is paused now");
                     
          String time= timeLine.getText();
          System.out.println("Timeline while pausing:  "+time);
          logger.info("Timeline while pausing:  "+time);
          Thread.sleep(5000);
          String time1=timeLine.getText();
          System.out.println("Timeline after 5 seconds from pausing:  "+time1);
          logger.info("Timeline after 5 seconds from pausing:  "+time1);
          
          Assert.assertEquals("Video still playing after the pause", time.equals(time1));
          System.out.println("Expected timelines: "+time+" should be equal to timeline after 5 seconds");
          logger.info("Expected timelines: "+time+" should be equal to timeline after 5 seconds");
          System.out.println("Actual timelines: "+time+" is equal to time after 5 seconds "+time1);
          logger.info("Actual timelines: "+time+" is equal to time after 5 seconds "+time1);
          System.out.println("Validated pause functionality successfully");
          logger.info("Validated pause functionality successfully");
         
     }
     public void quality(AndroidDriver driver) throws InterruptedException
     {
    	 //videoViewer.click();
    	//Video is in paused status
    	 qualityBtn.click();
    	 /*WebElement q=driver.findElement(By.id("com.tv.v18.viola:id/playback_option_quality"));
    	 new TouchAction((AndroidDriver) driver).tap(q).perform();*/
    	 Utilities.explicitWaitClickable(driver, dataSavingTab, 20);
    	 /*if(!dataSavingTab.isDisplayed())
    	 {
    		 qualityBtn.click();
    		 System.out.println("tried clicking quality setting again");
    	 }*/
    	 Utilities.explicitWaitClickable(driver, dataSavingTab, 10);
    	 dataSavingTab.click();
    	 Thread.sleep(10000);
    	 videoViewer.click();
    	
    	 qualityBtn.click();
    	 
    	 String headerColor = dataSavingTab.getCssValue("backgroud-color");
    	 System.out.println(headerColor);
    	   //Assert.assertEquals("some message", "#FFFFFF", headerColor);
    	 QualityCloseBtn.click();
     }
     public void share(AndroidDriver driver) throws InterruptedException
     {
    	// videoViewer.click();
    	 
    	 shareBtn.click();
    	 Utilities.explicitWaitClickable(driver, gmailBtn, 20);
    	 gmailBtn.click();
    	 driver.findElement(By.id("com.google.android.gm:id/to")).sendKeys("ifocusamc@gmail.com");
    	 driver.findElement(By.id("com.google.android.gm:id/subject")).sendKeys("Vootshare");
    	 driver.findElement(By.name("Send")).click();
    	 Thread.sleep(3000);
     }
     public void shout(AndroidDriver driver)
     {
    	 //videoViewer.click();
    	 //Utilities.explicitWaitClickable(driver, shoutBtn, 20);
    	 shoutBtn.click();
    	 ((WebElement) driver.findElements(By.id("com.tv.v18.viola:id/img_shape")).get(0)).click();
    	 
     }
     
     public void validatePlay(AndroidDriver driver) throws InterruptedException
     {
    	 
    	// videoViewer.click();
  		Dimension size = driver.manage().window().getSize();
  		  	        
  	        MultiTouchAction maction = new MultiTouchAction((MobileDriver) driver);
  	        
  	        int x5 = size.width / 2;
  	        int y5 = size.height / 2;
  	        
  	        TouchAction action51 = new TouchAction((MobileDriver)driver).tap(x5, y5).waitAction(500);
  	        
  	       //maction.add(action51).add(action51).perform();
  	        
            Thread.sleep(4000);
              
            String time1= timeLine.getText();
            
    	 System.out.println("Timeline Before playing "+time1);
         logger.info("Timeline Before playing "+time1);
         //tap to play
         maction.add(action51).add(action51).perform();
         Thread.sleep(5000);
         
         videoViewer.click();
         //tap to pause
         maction.add(action51).add(action51).perform();
         Thread.sleep(3000);
         String time2=timeLine.getText();
         System.out.println("Timeline after playing few seconds "+time2);
         logger.info("Timeline after playing few seconds "+time2);
         Assert.assertFalse(time1.equals(time2), "video is not playing after tapping on playbutton");
         //Assert.assertFalse("video is not playing after tapping on playbutton", time1.equals(time2));
         System.out.println("Expected timelines: "+time1+" should not be equal to timeline after few seconds");
         logger.info("Expected timelines: "+time1+" should not be equal to timeline after few seconds");
         System.out.println("Actual timelines: "+time1+" is not equal to time after few seconds "+time2);
         logger.info("Actual timelines: "+time1+" is not equal to time after few seconds ("+time2+")");
         System.out.println("Validated play functionality successfully");
         logger.info("Validated play functionality successfully");
         Thread.sleep(5000);
         
     }
	    	
	public void test(AndroidDriver driver)
	{
		//Runtime.getRuntime().exec(“C:\Program Files (x86)\Fiddler2\Fiddler.exe”);
	}

}

