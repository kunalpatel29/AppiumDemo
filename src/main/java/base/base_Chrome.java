package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base_Chrome {
	public static AndroidDriver<AndroidElement> driver;
	public static AndroidDriver<AndroidElement> capability() throws MalformedURLException {
	DesiredCapabilities cap = new DesiredCapabilities();
	
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "KunalAnd");
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
	cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
	cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	cap.setCapability("chromeOptions", ImmutableMap.of("w3c", false));
	
	driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	return driver;
}
}