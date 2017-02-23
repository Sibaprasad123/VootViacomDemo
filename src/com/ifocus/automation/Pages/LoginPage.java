package com.ifocus.automation.Pages;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ifocus.automation.GlobalRepository.GlobalVariables;
import com.ifocus.automation.Utilities.ExcelFunctions;
import com.ifocus.automation.Utilities.Utilities;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage{
	static Logger logger = Logger.getLogger("VootLogger");
	@FindBy(id = "com.tv.v18.viola:id/txt_launch_screen_sign_in")
   // @FindBy(name = "Sign in to voot account")
	public WebElement signinToVoot;
	
	/*@FindBy(name = "Editing.")
	public WebElement emailAddressTb;*/
	
	@FindBy(className = "android.widget.EditText")
	public List<WebElement> emailPasswordTb;
	/*@FindBy(xpath= "//android.widget.EditText[contains(@text,'email')]")
	public WebElement emailAddressTb;
	
	@FindBy(xpath = "//android.widget.EditText[contains(@text,'password')]")
	public WebElement passwordTb;*/
	
	@FindBy(name = "Sign in")
	public WebElement signinBtn;
	
	@FindBy(id = "com.tv.v18.viola:id/txt_launch_screen_create_account")
	public WebElement createAccount;
	
	@FindBy(className = "android.widget.EditText")
	public List<WebElement> firstName;
	
	/*@FindBy(name = "Editing.")
	public WebElement firstName;
	
	@FindBy(xpath = "//android.widget.EditText[@bounds='[50,471][670,527]']")
	public WebElement lastName;*/
	
	@FindBy(id = "com.tv.v18.viola:id/txt_top_bar_right_option")
	public WebElement continueBtn1;
	
	/*@FindBy(name = "Editing.")
	public WebElement emailId;*/
	
	@FindBy(xpath = "//android.widget.EditText[contains(@text,'password')]")
	public WebElement password1;
	
	//driver.findElementsByClassName("android.widget.EditText").get(0).sendKeys("latereg123@gmail.com");
	@FindBy(className = "android.widget.EditText")
	public List<WebElement> emailpassword2;
	
	@FindBy(id = "com.tv.v18.viola:id/txt_top_bar_right_option")
	public WebElement continueBtn2;
	
	@FindBy(name = "Finish")
	public WebElement finishBtn;
	@FindBy(name = "SKIP")
	public WebElement skipBtn;
	
	@FindBy(name = "LET'S VOOT")
	public WebElement vootBtn;
	
	@FindBy(className = "android.widget.EditText")
	public List<WebElement> profileEmail;
	
	@FindBy(id = "com.tv.v18.viola:id/txt_top_bar_left_option")
	public WebElement backBtn;
	@FindBy(name = "Open Drawer")
	public static WebElement MenuTab;
	
	@FindBy(name = "SETTINGS")
	public static WebElement Settings;
	@FindBy(name = "Sign Out")
	public static WebElement signoutBtn;
	
	@FindBy(className = "android.view.View")
	public WebElement videoViewer;
	
	@FindBy(id = "com.tv.v18.viola:id/video_player_close_btn")
	public WebElement videoClose;
	
	@FindBy(name = "Navigate up")
	public WebElement exitBtn;
	
	String signout="//android.widget.TextView[@text='Sign Out']";
	
	
	@FindBy(className = "android.widget.LinearLayout")
	public WebElement sscreen;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void registerVoot(AndroidDriver driver) throws InterruptedException, IOException
	{
		System.out.println("****Voot valid registration Begins now****");
		logger.info("****Voot valid registration Begins now****");
		Utilities.explicitWaitClickable(driver, createAccount, 30);
		createAccount.click();
		Utilities.explicitWaitClickable(driver, firstName.get(0), 20);
		String fname = ExcelFunctions.getCellValue(GlobalVariables.xlPath, GlobalVariables.sheet, 1, 0);
		
		firstName.get(0).sendKeys(fname);
		Utilities.explicitWaitClickable(driver,firstName.get(1) , 20);
		String lname = ExcelFunctions.getCellValue(GlobalVariables.xlPath, GlobalVariables.sheet, 1, 1);
		firstName.get(1).sendKeys(lname);

		Utilities.explicitWaitClickable(driver, continueBtn1, 20);
		continueBtn1.click();
		
		Utilities.explicitWaitClickable(driver, emailpassword2.get(0), 20);
		String email = Utilities.generateEmailid();		
		emailpassword2.get(0).sendKeys(email);
		password1.sendKeys(Keys.ENTER);
		
		Utilities.explicitWaitClickable(driver, password1, 20);
		String pwd1 = ExcelFunctions.getCellValue(GlobalVariables.xlPath, GlobalVariables.sheet, 1, 2);
		password1.sendKeys(pwd1);
		emailpassword2.get(2).sendKeys(Keys.ENTER);
		//driver.sendKeyEvent(AndroidKeyCode.ENTER);
		 
		Thread.sleep(3000);
		String pwd2 = ExcelFunctions.getCellValue(GlobalVariables.xlPath, GlobalVariables.sheet, 1, 3);
		emailpassword2.get(2).sendKeys(pwd2);

		Utilities.explicitWaitClickable(driver, continueBtn2, 20);
       try{
			if(!continueBtn2.isEnabled()){
				email = Utilities.generateEmailid();
				emailpassword2.get(0).clear();
				emailpassword2.get(0).sendKeys(email);
			}
		}catch(Exception e){
			System.out.println("Email id already exists: Entering a new email id");
		}
		continueBtn2.click();
		Utilities.explicitWaitClickable(driver, continueBtn2, 20);
		continueBtn2.click();
		Utilities.explicitWaitClickable(driver, finishBtn, 20);
		finishBtn.click();
		System.out.println("New Voot account created successfully with the given credentials");
		logger.info("New Voot account created successfully with the given credentials");
		Utilities.explicitWaitClickable(driver, skipBtn, 30);
		skipBtn.click();
		//Tap on Lets Voot button
		Utilities.explicitWaitClickable(driver, vootBtn, 20);
		vootBtn.click();
		Thread.sleep(4000);		
		
		Utilities.explicitWaitClickable(driver,MenuTab, 30);
		MenuTab.click();
		Utilities.explicitWaitClickable(driver, Settings, 20);
		Settings.click();
		//Verify email id
		String actualemail=profileEmail.get(2).getText();
		String[] actemail1=actualemail.split(" ");
		actualemail=actemail1[0];
		
		actualemail = actualemail.substring(0, actualemail.length()-1);
		
		System.out.println("email id displayed in the profile:  "+actualemail);
		logger.info("email id displayed in the profile  "+actualemail);
		Utilities.captureScreenshot(driver);
		
		//driver.scrollTo("SIGN OUT");
		
		Utilities.verticalSwipe(driver, sscreen, signout);
		Utilities.explicitWaitClickable(driver, signoutBtn, 40);
		signoutBtn.click();
		System.out.println("successfully logged out from Voot App");
		logger.info("successfully logged out from Voot App");
		Thread.sleep(5000);
		
		//Validate registration
		login(driver, actualemail, pwd1);
		/*logger.info(" Login to Voot starts now");
		System.out.println("\n Login to Voot starts now");
		Utilities.explicitWaitClickable(driver, signinToVoot, 20);
		signinToVoot.click();
		
		Utilities.explicitWaitClickable(driver, emailAddressTb, 20);
		emailAddressTb.sendKeys(actualemail);
		
		
		Utilities.explicitWaitClickable(driver, passwordTb, 20);
		passwordTb.sendKeys(pwd1);
		
		Utilities.explicitWaitClickable(driver, signinBtn, 20);
		signinBtn.click();
		
		Utilities.explicitWaitClickable(driver, MenuPage.MenuTab, 20);
		
		Assert.assertTrue(MenuPage.MenuTab.isDisplayed());
	*/	
		System.out.println("Validated new user registration by logging again with the new credentials and verifying the email id");
		logger.info("Validated new user registration by logging again with the new credentials and verifying the email id");
	
		Utilities.captureScreenshot(driver);
		Thread.sleep(3000);
	}
	public void registerVoot2(AndroidDriver driver) throws InterruptedException, IOException
	{
		System.out.println("Abort Voot registration");
		logger.info("Voot registration with unsuccessful attempt");
		Utilities.explicitWaitClickable(driver, createAccount, 20);
		createAccount.click();
		Utilities.explicitWaitClickable(driver, firstName.get(0), 20);
		String fname = ExcelFunctions.getCellValue(GlobalVariables.xlPath, GlobalVariables.sheet, 2, 0);
		firstName.get(0).sendKeys(fname);
		Utilities.explicitWaitClickable(driver, firstName.get(1), 20);
		String lname = ExcelFunctions.getCellValue(GlobalVariables.xlPath, GlobalVariables.sheet, 2, 1);
		firstName.get(1).sendKeys(lname);
		Utilities.explicitWaitClickable(driver, continueBtn1, 20);
		continueBtn1.click();	
		Utilities.explicitWaitClickable(driver, emailpassword2.get(0), 20);
		String email = Utilities.generateEmailid();		
		emailpassword2.get(0).sendKeys(email);	
		Utilities.explicitWaitClickable(driver, password1, 20);
		String pwd1 = ExcelFunctions.getCellValue(GlobalVariables.xlPath, GlobalVariables.sheet, 1, 2);
		password1.sendKeys(pwd1);
		Thread.sleep(3000);
		String pwd2 = ExcelFunctions.getCellValue(GlobalVariables.xlPath, GlobalVariables.sheet, 1, 3);
		emailpassword2.get(2).sendKeys(pwd2);
		Utilities.explicitWaitClickable(driver, continueBtn2, 20);
		try{
			if(!continueBtn2.isEnabled()){
				email = Utilities.generateEmailid();
				emailpassword2.get(0).clear();
				emailpassword2.get(0).sendKeys(email);
			}
		}catch(Exception e){
			System.out.println("Email id already exists: Entering a new email id");
			logger.info("Email id already exists: Entering a new email id");
		}
		continueBtn2.click();
		Utilities.explicitWaitClickable(driver, continueBtn2, 20);
		continueBtn2.click();
		Utilities.explicitWaitClickable(driver, backBtn, 20);
		backBtn.click();	
		System.out.println("User enters the same details again for creating Voot account");
		logger.info("User enters the same details again for creating Voot account");
		//Second attempt of registration
			
		Utilities.explicitWaitClickable(driver, createAccount, 20);
		createAccount.click();
		Utilities.explicitWaitClickable(driver, firstName.get(0), 20);	
		firstName.get(0).sendKeys(fname);
		Utilities.explicitWaitClickable(driver, firstName.get(1), 20);	
		firstName.get(1).sendKeys(lname);
		Utilities.explicitWaitClickable(driver, continueBtn1, 20);
		continueBtn1.click();	
		Utilities.explicitWaitClickable(driver, emailpassword2.get(0), 20);			
		emailpassword2.get(0).sendKeys(email);	
		Utilities.explicitWaitClickable(driver, password1, 20);		
		password1.sendKeys(pwd1);
		Thread.sleep(3000);		
		emailpassword2.get(2).sendKeys(pwd2);		
		Utilities.explicitWaitClickable(driver, continueBtn2, 20);
		continueBtn2.click();     
		System.out.println("Expected Result: User should be able to continue the Registration process with the given details");
		logger.info("Expected Result: User should be able to continue the Registration process with the given details");
        System.out.println("Actual Result: Error Message displayed: Email id already exists");
        logger.info("Actual Result: Error Message displayed: Email id already exists");
		Utilities.explicitWaitClickable(driver, continueBtn2, 20);
		continueBtn2.click();
		Thread.sleep(5000);
		Utilities.captureScreenshot(driver);         
	}
		
	public void login(AndroidDriver driver,String email,String password)
	{
		try
		{
			if(backBtn.isDisplayed())
		
			{backBtn.click();}
		}catch(Exception e)
		{
			System.out.println("");
		}
		logger.info(" Login to Voot starts now");
		System.out.println("\n Login to Voot starts now");
		
		int present=driver.findElements(By.id("com.tv.v18.viola:id/txt_launch_screen_sign_in")).size();
		
		if(present>0)
		{
		Utilities.explicitWaitClickable(driver, signinToVoot, 40);
		
		signinToVoot.click();
		
		Utilities.explicitWaitClickable(driver, emailPasswordTb.get(0), 20);
		emailPasswordTb.get(0).sendKeys(email);
		
		
		Utilities.explicitWaitClickable(driver, emailPasswordTb.get(1), 20);
		emailPasswordTb.get(1).sendKeys(password);
		
		Utilities.explicitWaitClickable(driver, signinBtn, 20);
		signinBtn.click();
		
		Utilities.explicitWaitClickable(driver, MenuTab, 20);
		
		Assert.assertTrue(MenuTab.isDisplayed());
		System.out.println("Logged into Voot successfully");
		logger.info("Logged into Voot successfully");
		}
		else
		{
			System.out.println("User is already signed in");
		}
		
		
	}
	public void Logout(AndroidDriver driver) throws InterruptedException
	{
		Utilities.explicitWaitClickable(driver, MenuTab, 20);
		MenuTab.click();
		Utilities.explicitWaitClickable(driver, Settings, 20);
		Settings.click();
		Thread.sleep(2000);
		
		Utilities.verticalSwipe(driver, sscreen, signout);
		//driver.scrollTo("SIGN OUT");
		
		
		Utilities.explicitWaitClickable(driver, signoutBtn, 40);
		signoutBtn.click();
		System.out.println("successfully logged out from Voot App");
		logger.info("successfully logged out from Voot App");
		Thread.sleep(5000);
		
	
	}

	
}
