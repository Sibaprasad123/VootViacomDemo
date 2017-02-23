package com.ifocus.automation.Testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ifocus.automation.GlobalRepository.GlobalVariables;
import com.ifocus.automation.Pages.WebPage;
import com.ifocus.automation.Pages.WebPageNew;

public class WebTest {
	@Test
	public void playWebVideo() throws InterruptedException, IOException {
		WebDriver driver = BaseClass.startSeleniumDriver();
		driver.get(GlobalVariables.url);
		driver.manage().window().maximize();

		WebPageNew login = new WebPageNew(driver);
		login.playVideo(driver);
}
}
