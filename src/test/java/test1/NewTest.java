package test1;

import org.testng.annotations.Test;

import base.base_Chrome;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NewTest extends base_Chrome{
	AndroidDriver<AndroidElement> driver;
  @Test
  public void verifyTittle() throws InterruptedException {
	  driver.get("https://www.google.ca/");
		Thread.sleep(3000);
		Assert.assertEquals("Google", driver.getTitle());
  }
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  driver = capability();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
