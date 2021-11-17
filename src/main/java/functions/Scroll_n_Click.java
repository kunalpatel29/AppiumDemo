package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import io.appium.java_client.TouchAction;

import base.Base;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Scroll_n_Click extends Base{
	public void scrollClick(String s) {
		
		
	MobileElement ele = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
			"new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
			".scrollIntoView(new UiSelector().text(\""+s+"\"))"));
	int no = driver.findElements(By.id("com.androidsample.generalstore:id/productImage")).size();

	for (int i =0; i<no; i++) {
		String text1 = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
		if (text1.equalsIgnoreCase(s)) {
			driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			break;
		}

	}
	}
	public void scroll (String s) {
		MobileElement ele = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
				".scrollIntoView(new UiSelector().text(\""+s+"\"))"));
		
		
		
	}
	
	
	

}
