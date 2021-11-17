package applications;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;

import base.Base;
import functions.Scroll_n_Click;
import functions.String_to_Double;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class General_Store_webView extends Base{
	static Scroll_n_Click f = new Scroll_n_Click();
	static String_to_Double f1 = new String_to_Double();
	
	public static void main (String [] args) throws MalformedURLException, InterruptedException {
	driver = capa();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Kunal");
	driver.hideKeyboard();
	driver.findElement(By.xpath("//*[@text='Female']")).click();
	f.scroll("Armenia");
	driver.findElement(By.xpath("//*[@text='Armenia']")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	f.scrollClick("Converse All Star");
	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	String price = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	System.out.println("price of selected product is $ "+f1.convert(price));
	
	WebElement lp = driver.findElement(By.xpath("//*[@text='Send me e-mails on discounts related to selected products in future']"));
	TouchAction swipe = new TouchAction(driver);
	swipe.tap(tapOptions().withElement(element(lp))).perform();
	driver.findElement(By.className("android.widget.Button")).click();
	Thread.sleep(5000);
	Set<String> contextNames = driver.getContextHandles(); 
	for (String contextName : contextNames) 
	{ System.out.println(contextName);}
	driver.context("WEBVIEW_com.androidsample.generalstore");
	
	driver.findElement(By.name("q")).sendKeys("Kunal");
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	driver.context("NATIVE_APP");
	
		
	}
}