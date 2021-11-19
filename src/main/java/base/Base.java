package base;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
	public static AndroidDriver<AndroidElement> driver;


	
		
		
		public static AndroidDriver<AndroidElement> capa() throws MalformedURLException {
			
			File f = new File("src/main/java");
//			File fs = new File(f,"ApiDemos-debug.apk");
			File prac = new File(f,"prac.apk");
			DesiredCapabilities cap = new DesiredCapabilities();
			//DesiredCapabilities cp = DesiredCapabilities.android();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "KunalAnd");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
		
		cap.setCapability("chromeOptions", ImmutableMap.of("w3c", false));
		
		cap.setCapability(MobileCapabilityType.APP, prac.getAbsolutePath());
		
		
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
}
