package com.ifocus.automation.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Utilities {

	public static AppiumDriverLocalService service;
	public static void explicitWaitVisible(WebDriver driver, WebElement element, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void explicitWaitClickable(WebDriver driver, WebElement element, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	 public static String generateEmailid() {
		  String strRandom = "";
		  String strNumbers = "abcdefghijklmnopqrstuvwxyzacvbe";
		  Random rnd = new Random();
		  StringBuilder strRandomNumber = new StringBuilder(9);
		  for (int i = 0; i < 4; i++)
		   {strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));}
		  strRandom = strRandomNumber.toString();
		  		  
			String email = strRandom +"@" + "gmail" +".com";
			return email;
			
		 }
	
	 public static void captureScreenshot(WebDriver driver) throws IOException {

			EventFiringWebDriver e = new EventFiringWebDriver(driver);
			File srcFile = e.getScreenshotAs(OutputType.FILE);

			SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
			Calendar cal = Calendar.getInstance();
			String sysdate1 = dateFormat.format(cal.getTime());
			
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("HHmmss");		
			String sysdate2 = dateFormat1.format(cal.getTime());
	        
			File destFile = new File("Screenshots/"+sysdate1 +"/"+"/"+ sysdate2 + ".png");
			
			//String destination= System.getProperty("user.dir"+"/Screenshots/Screenshots_"+sysdate1+"//" + sysdate2 + ".png");
			//System.getProperty("user.dir" + "/src/res/test.pdf");
			//File destFile = new File("E://Screenshots//Screenshots_"+sysdate1+"//" + sysdate2 + ".png");
			//File destFile = new File(destination);
			FileUtils.copyFile(srcFile, destFile);
		}

		/*---------------------------------------------------------------------------------------------------------------------*/

		public static void captureScreenshot(AndroidDriver driver) throws IOException {

			EventFiringWebDriver e = new EventFiringWebDriver(driver);
			File srcFile = e.getScreenshotAs(OutputType.FILE);

			SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
			Calendar cal = Calendar.getInstance();
			String sysdate1 = dateFormat.format(cal.getTime());
			
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("HHmmss");		
			String sysdate2 = dateFormat1.format(cal.getTime());

			
			//File destFile = new File("E://Screenshots_"+sysdate1+"//" + sysdate2 + ".png");
			File destFile = new File("Screenshots/"+sysdate1 +"/"+"/"+ sysdate2 + ".png");
			FileUtils.copyFile(srcFile, destFile);
		}
		 public static void generateXSLTReport() {
			  String filePath = System.getProperty("user.dir")+ "/" + "XSLTReport.bat";
			  String pathToXslt = "cmd /c start"+" "+filePath;
			  System.out.println(pathToXslt);
			  final Runtime rt = Runtime.getRuntime();
			  try {
			   Process p = rt.exec(pathToXslt);
			   System.out.println("inside try block");
			  } catch (final IOException e) {
			   throw new RuntimeException("Failed to run bat file.");
			  }
			  finally{
				  try {
			            Runtime.getRuntime().exec("taskkill /f /im cmd.exe") ;
			        } catch (Exception e) {
			            e.printStackTrace();  
			        }
			    }
			  }
		 public static void startAppiumServer() {

				service = AppiumDriverLocalService.buildService(
						new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files (x86)\\Appium\\node.exe"))
								.withAppiumJS(new File("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js"))
								.withIPAddress("127.0.0.1").usingPort(4723));
				if (service.isRunning() == true) {
					service.stop();
				} else {
					service.start();
				}
			}

			public static void stopAppiumServer() {
				service.stop();
				System.out.println("service::" + service.isRunning());

			}
			
			
   //vertical swipe
			public static void verticalSwipe(AndroidDriver driver,WebElement screen,String end) {
				//scrolling starts
				
						
				        int width  = screen.getSize().width;
				            int height = screen.getSize().height;
				           
				            int startx = width/2;
				            int endx = startx;
				            int starty =  (int)(height*0.80) ;
				            int endy = height/2;
				            for(int i=0;i<height;i++)	
							{      
				         driver.swipe(startx, starty, endx, endy, 3000);
				         //if (driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.tv.v18.viola:id/txt_title_tile']")).size()>0)
				        	 if (driver.findElements(By.xpath(end)).size()>0)
				 			break;
				         
						}
			}
			public static void horizontalSwipe(AndroidDriver driver,WebElement screen)
			{
				  
			        int screenwidth  = screen.getSize().width;
			            int screenheight = screen.getSize().height;
			           
			            int startx = (int) (screenwidth * (0.8));
			            int endx = (int)(screenwidth *(0.2));
			            int starty =  screenheight /2 ;
			            int endy = screenheight/2;
			         //swipe from right to left//
			            
			         driver.swipe(startx, starty, endx, endy, 1000);
			         
			         
			}
			public static void pauseVideo(AndroidDriver driver,WebElement screen)
			{
				//System.out.println("inside pause function");
				screen.click();
				Dimension size = driver.manage().window().getSize();
				//	System.out.println(size);
			        
			        MultiTouchAction maction = new MultiTouchAction((MobileDriver) driver);
			        
			        int x5 = size.width / 2;
			        int y5 = size.height / 2;
			        
			        TouchAction action51 = new TouchAction((MobileDriver)driver).tap(x5, y5).waitAction(500);
			        
			        maction.add(action51).add(action51).perform();
				
			}
	//Pause video ends
				        

}

		



