package com.ifocus.automation.Pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ifocus.automation.GlobalRepository.GlobalVariables;
import com.ifocus.automation.Utilities.Utilities;

public class WebPage {
	Logger logger = Logger.getLogger("VootLogger");

	@FindBy(xpath = "//*[@id='progressId']/div/span/a/i")
	public WebElement MenuBtn;
	
	@FindBy(xpath = ".//*[@id='signin']")
	public WebElement signInBtn;
	
	@FindBy(xpath = ".//*[@id='email_sign']")
	public WebElement emailid;
	
	@FindBy(xpath = ".//*[@id='password_sign']")
	public WebElement password;
	
	@FindBy(xpath = ".//*[@id='vootSignin']/div/div[5]/button")
	public WebElement signBtn;
	
	@FindBy(xpath = ".//*[@id='item-4']/a/div[2]/span[1]/i")
	public WebElement playBtn;
	
	
	@FindBy(xpath = ".//*[@id='voot_player']")
	public WebElement vootPlayer;
	
	@FindBy(xpath = ".//*[@id='signout']")
	public WebElement signoutBtn;
	
	
			@FindBy(xpath = "//div[@class='controlsContainer']")
	public WebElement player;		
	
	
	
	public WebPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void playWebVideo(WebDriver driver) throws InterruptedException, IOException
	{
		Utilities.explicitWaitClickable(driver, MenuBtn, 20);
		MenuBtn.click();
		
		Utilities.explicitWaitClickable(driver, signInBtn, 20);
		signInBtn.click();
				
		Utilities.explicitWaitClickable(driver, emailid, 20);
		emailid.sendKeys(GlobalVariables.email);
		
		Utilities.explicitWaitClickable(driver, password, 20);
		password.sendKeys(GlobalVariables.password);
		
		Utilities.explicitWaitClickable(driver, signBtn, 20);
		signBtn.click();
		Thread.sleep(5000);
		System.out.println("successfully signed into Voot Web Application");
		logger.info("successfully signed into Voot Web Application");
		//Utilities.explicitWaitClickable(driver, playBtn, 20);
		//playBtn.click();
		  WebElement playButton = null;
		  for (int i = 0; i <= 8; i++) {
		   playButton = driver.findElement(By.xpath(".//*[@id='item-" + i + "']/a/div[2]/span[1]"));
		   if (playButton.isDisplayed()) {
		    playButton.click();
		    System.out.println("\nClicked on video: " + i);
		    break;
		   }
		  }
		Thread.sleep(50000);
		/*Utilities.explicitWaitClickable(driver, vootPlayer, 20);
		vootPlayer.click();
		Thread.sleep(10000);
		Utilities.explicitWaitClickable(driver, vootPlayer, 20);
		vootPlayer.click();*/
		
		Actions action=new Actions(driver);
		action.moveToElement(player).click();
		action.build().perform();
		System.out.println("tapped on player");
		Thread.sleep(5000);
		
		
		MenuBtn.click();
		
		Utilities.explicitWaitClickable(driver, signoutBtn, 20);
		signoutBtn.click();
		Utilities.captureScreenshot(driver);
		
	}

}
