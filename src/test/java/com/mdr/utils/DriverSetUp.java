package com.mdr.utils;

import java.io.IOException;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;
import com.mdr.base.BaseTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverSetUp extends BaseTest {
	
	
	@SuppressWarnings("rawtypes")
	public static void setIOSCaps() throws IOException {
		DesiredCapabilities capabilities = new DesiredCapabilities();		
		DeviceSetup.setIOScapabilities();// sets all the parameters required for IOS capabilities
		DeviceSetup.validateiOSDevice();
		capabilities.setCapability("deviceName", BaseTest.DeviceName);
		capabilities.setCapability("app", BaseTest.app);
		capabilities.setCapability("udid", BaseTest.udid);
		capabilities.setCapability("automationName", "XCUITest");
		//capabilities.setCapability("noReset", false);
		//capabilities.setCapability("useNewWDA", true);
		capabilities.setCapability("newCommandTimeout", 0);
		//capabilities.setCapability("fullReset", true);
		capabilities.setCapability("sendKeyStrategy", "setValue");
		capabilities.setCapability("autoGrantPermissions", "true"); 
		capabilities.setCapability("autoAcceptAlerts", "true");
		capabilities.setCapability("clearSystemFiles", true);
		capabilities.setCapability("updatedWDABundleId", "com.shaadi.iphone");
		capabilities.setCapability("platformVersion", BaseTest.platformVersion);
		driver = new IOSDriver(new URL(BaseTest.Url), capabilities);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("Driver Initialized ----- " + driver);

		
	}

	@SuppressWarnings("rawtypes")
	public static void setAndroidCaps() throws IOException {
		DesiredCapabilities capabilities = new DesiredCapabilities();		
		System.out.println("Testing started");
		DeviceSetup.setAndroidcapabilities();// sets all the parameters required for Android capabilities
		DeviceSetup.validateAndroidDevice();
		capabilities.setCapability("deviceName", DeviceName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("newCommandTimeout", 400);
		capabilities.setCapability("appium-version", appiumVersion);
		//capabilities.setCapability("noReset", false);
		//capabilities.setCapability("fullReset", true);
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability("app", app);
		capabilities.setCapability("appPackage", AppStringConstants.ANDROIDAPPPACKAGE);
		capabilities.setCapability("appActivity", AppStringConstants.ANDROIDAPPACTIVITY);
		capabilities.setCapability("forceMjsonwp", true);
		capabilities.setCapability("automationName", AutomationRunName);
		capabilities.setCapability("autowebview", true);
		capabilities.setCapability("chromedriverExecutable", path_to_chromedriver);
		capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		driver = new AndroidDriver(new URL(Url), capabilities);
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		
		System.out.println("Driver Initialized ----- " + driver);
		
		
	}
	
	
	
}