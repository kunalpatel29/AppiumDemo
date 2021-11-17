package applications;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.Base;
import base.base_Chrome;

public class Mobile_Browser extends base_Chrome{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		driver = capability();
		driver.get("https://www.td.com/ca/en/personal-banking/");
		Thread.sleep(3000);
		driver.findElement(By.className("td-mobile-menu-button-icon")).click();
		driver.findElement(By.xpath("//ul[@class='td-nav-mobile-menu-list']/li[2]")).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement cc = driver.findElement(By.xpath("//a[contains(text(),'Find a credit')]"));
		jse.executeScript("arguments[0].scrollIntoView(true);", cc);
		//jse.executeScript("window.scrollBy(0, 4000)"); 
		Thread.sleep(2000);
		cc.click();

	}

}
