package applications;

import java.net.MalformedURLException;
import java.time.Duration;

import org.testng.Assert;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import base.Base;
import functions.Scroll_n_Click;
import functions.String_to_Double;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;


public class General_Store extends Base {

	

	static String_to_Double std = new String_to_Double();
	static Scroll_n_Click scroll = new Scroll_n_Click();
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		driver = capa();
		//AndroidDriver<AndroidElement> driver = capa();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Kunal");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		//driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();

		//driver.findElement(By.xpath("//android.widget.Spinner[@text = 'India']")).click();

		//driver.findElementByAndroidUIAutomator("new Uiscrollable(newUiSelector()).scrollIntoView(new UiSelector().text(\"India\"));");		
		//AndroidElement list = (AndroidElement)driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));

		//MobileElement listitem = (MobileElement)driver.findElement(MobileBy.AndroidUIAutomator("new Uiscrollable(newUiSelector()).scrollIntoView(new UiSelector().text(\"India\"));"));
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""+"Armenia"+"\")).instance(0))"));

		MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
				".scrollIntoView(new UiSelector().text(\"Armenia\"))"));

		driver.findElement(By.xpath("//*[@text='Armenia']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//String toast = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		//System.out.println(toast);
		MobileElement airJordan = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
				".scrollIntoView(new UiSelector().text(\"Air Jordan 9 Retro\"))"));
		int no = driver.findElements(By.id("com.androidsample.generalstore:id/productImage")).size();

		for (int i =0; i<no; i++) {
			String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if (text.equalsIgnoreCase("Air Jordan 9 Retro")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		MobileElement consAll = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
				".scrollIntoView(new UiSelector().text(\"Converse All Star\"))"));
		int no1 = driver.findElements(By.id("com.androidsample.generalstore:id/productImage")).size();

		for (int i =0; i<no1; i++) {
			String text1 = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if (text1.equalsIgnoreCase("Converse All Star")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
		}
		//scroll.scrollClick("Air Jordan 4 Retro");
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		int totalitem = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		System.out.println("number of items added to cart "+ totalitem);
		String [] n = new String [totalitem];
		for (int i=0; i<totalitem; i++) {
			n[i] = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
		}
		for (String all:n) {
			System.out.println(all);
		}
		double temp = 0;
		double sum = 0;
		for (int i =0; i<n.length; i++) {
			double j = std.convert(n[i]);
			//			String s = n[i].substring(1);
			//			double j = Double.parseDouble(s);
			sum = j+sum;
			//temp = j;
		}


		System.out.println("total price for all items :"+sum);	

		String t = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		String t1 = t.substring(1);
		double tot = Double.parseDouble(t1);
		System.out.println(tot);
		//Assert.assertEquals(sum, tot);
		System.out.println(std.convert("229.7"));
		
		WebElement lp = driver.findElement(By.xpath("//*[@text='Send me e-mails on discounts related to selected products in future']"));
		WebElement tc = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		//swipe
		TouchAction swipe = new TouchAction(driver);
				
				swipe.tap(tapOptions().withElement(element(lp))).perform();
				//swipe.longPress(longPressOptions().withDuration(Duration)).release().perform();
				Thread.sleep(2000);
				swipe.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
	}





}
