package com.ifocus.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WebPageNew {
	public WebPageNew(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@Test
	public void playVideo(WebDriver driver) throws InterruptedException
	{

		driver.findElement(By.className("icon")).click();
        //menu icon
Thread.sleep(3000);
driver.findElement(By.linkText("JOIN VOOT")).click();
Thread.sleep(3000);
driver.findElement(By.className("sign-up-btn")).click();         // sign-up

Thread.sleep(5000);
WebElement fName=driver.findElement(By.xpath(".//.//div[contains(@class,'firstname')]/div[1]/input"));
JavascriptExecutor executor= (JavascriptExecutor)driver;
executor.executeScript("document.getElementById('firstname').style.display='block';");
//driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
Thread.sleep(2000);

fName.click();
fName.sendKeys("Ganesh");
}
}
