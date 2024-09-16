package com.mdr.utils;

import java.io.BufferedReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import com.mdr.base.BaseTest;



public class DeviceSetup {

	public static List<String> realDevice = new ArrayList<String>();

	public static List<String> simulatorDevice = new ArrayList<String>();

	public static List<String> myDeviceInfo = new ArrayList<String>();

	public static String deviceList, realDeviceName, realDeviceOS, realDeviceUDID;

	public static List<String> deviceOsPool = new ArrayList<String>();

	public static List<String> deviceNamePool = new ArrayList<String>();

	public static List<String> deviceUdidPool = new ArrayList<String>();

	public static boolean isiOSSimulator, isRealDevice;

	public static void getiOSDeviceInfo() throws IOException {

		int realDeviceCount, simulatorCount;
		
		if(AppProperties.getProperty(UserProperty.isIosSimulator, "no").equalsIgnoreCase("Yes")) {
			
			isiOSSimulator = true;
			
		}

		ProcessBuilder builder = new ProcessBuilder("instruments", "-s", "devices");

		builder.redirectErrorStream(true);

		Process prc;

		prc = builder.start();

		BufferedReader r = new BufferedReader(new InputStreamReader(prc.getInputStream()));

		while ((deviceList = r.readLine()) != null) {

			myDeviceInfo.add(deviceList);

		}
		
		
		System.out.println(myDeviceInfo);

		while (!myDeviceInfo.get(0).contains("Known Devices:")) {
			myDeviceInfo.remove(0);
			System.out.println(myDeviceInfo);
		}

		if (isiOSSimulator) {
			for (int i = 2; i < myDeviceInfo.size(); i++) {
				if (!myDeviceInfo.get(i).contains("iPad") && !myDeviceInfo.get(i).contains("Apple")) {
					if (myDeviceInfo.get(i).contains("Simulator"))
						simulatorDevice.add(myDeviceInfo.get(i));
				}
			}

			simulatorCount = simulatorDevice.size();
			setiOSDevice(setiOSDeviceRandom(simulatorCount), simulatorDevice);
			setiOSDevicePool(simulatorDevice);

		}

		else {
			for (int i = 2; i < myDeviceInfo.size(); i++) {
				if (!myDeviceInfo.get(i).contains("Simulator")) {
					realDevice.add(myDeviceInfo.get(i));
				}
			}

			realDeviceCount = realDevice.size();

			setiOSDevice(setiOSDeviceRandom(realDeviceCount), realDevice);
			setiOSDevicePool(realDevice);

		}

	}

	public static int setiOSDeviceRandom(int deviceCount) {

		int randomNum;

		if (deviceCount == 1) {
			randomNum = 0;
		} else {
			Random rand = new Random();

			randomNum = rand.nextInt((deviceCount));
		}

		return randomNum;

	}

	public static void setiOSDevice(int deviceIndex, List<String> deviceList)

	{

		Pattern pattern = Pattern.compile(
				"((.{0,})\\((.{0,})\\)\\s{0,}\\s\\[(.{0,})])|(((.{0,})\\((.{0,})\\))(\\s-*\\s*(.*)))|((\\w+ \\w+ -)(\\s-*\\s*(.*)))|((\\w*\\s\\-)(.*))");

		Matcher matcher = pattern.matcher(deviceList.get(deviceIndex));

		if (matcher.find()) {

			System.out.println("match found");

			realDeviceName = matcher.group(2);

			realDeviceOS = matcher.group(3);

			realDeviceUDID = matcher.group(4);

		}

	}

	public static void setiOSDevicePool(List<String> myDeviceList)

	{

		for (int i = 0; i < myDeviceList.size(); i++) {

			Pattern pattern = Pattern.compile(
					"((.{0,})\\((.{0,})\\)\\s{0,}\\s\\[(.{0,})])|(((.{0,})\\((.{0,})\\))(\\s-*\\s*(.*)))|((\\w+ \\w+ -)(\\s-*\\s*(.*)))|((\\w*\\s\\-)(.*))");

			Matcher matcher = pattern.matcher(myDeviceList.get(i));

			if (matcher.find()) {

				System.out.println(matcher.group(2));

				deviceNamePool.add(matcher.group(2).trim());

				deviceOsPool.add(matcher.group(3).trim());

				deviceUdidPool.add(matcher.group(4).trim());

			}

		}

	}

	public static void setMacEnv() {
		try {
			BaseTest.process_platformversion = new ProcessBuilder("./adb", "shell", "getprop",
					"ro.build.version.release");
			BaseTest.process_platformversion
					.directory(new File(System.getProperty("user.home") + "/Library/Android/sdk/platform-tools/"));
			BaseTest.process_platformversion.redirectErrorStream(true);
			BaseTest.prc_platformversion = BaseTest.process_platformversion.start();
			BufferedReader r = new BufferedReader(new InputStreamReader(BaseTest.prc_platformversion.getInputStream()));
			BaseTest.platformVersion = r.readLine();

			BaseTest.process_devicename = new ProcessBuilder("./adb", "get-serialno");
			BaseTest.process_devicename
					.directory(new File(System.getProperty("user.home") + "/Library/Android/sdk/platform-tools/"));
			BaseTest.process_devicename.redirectErrorStream(true);
			BaseTest.prc_devicename = BaseTest.process_devicename.start();
			r = new BufferedReader(new InputStreamReader(BaseTest.prc_devicename.getInputStream()));
			BaseTest.deviceName = r.readLine();

		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
			}
	}

	public static void setWinEnv() {
		try {
			BaseTest.process_platformversion = new ProcessBuilder("cmd.exe", "/c",
					"adb shell getprop ro.build.version.release");
			BaseTest.process_platformversion.redirectErrorStream(true);
			BaseTest.prc_platformversion = BaseTest.process_platformversion.start();
			BufferedReader r = new BufferedReader(new InputStreamReader(BaseTest.prc_platformversion.getInputStream()));
			BaseTest.platformVersion = r.readLine();
			BaseTest.prc_platformversion.waitFor();

			BaseTest.process_devicename = new ProcessBuilder("cmd.exe", "/c", "adb get-serialno");
			BaseTest.process_devicename.redirectErrorStream(true);
			BaseTest.prc_devicename = BaseTest.process_devicename.start();
			r = new BufferedReader(new InputStreamReader(BaseTest.prc_devicename.getInputStream()));
			BaseTest.deviceName = r.readLine();
			BaseTest.prc_devicename.waitFor();

		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());		}
	}

	public static void setOtherEnv() {
		try {

			BaseTest.process_platformversion = new ProcessBuilder("/bin/bash", "-l", "-c",
					"adb shell getprop ro.build.version.release");
			BaseTest.process_platformversion.redirectErrorStream(true);
			BaseTest.prc_platformversion = BaseTest.process_platformversion.start();
			BufferedReader r = new BufferedReader(new InputStreamReader(BaseTest.prc_platformversion.getInputStream()));
			BaseTest.platformVersion = r.readLine();
			BaseTest.prc_platformversion.waitFor();

			BaseTest.process_devicename = new ProcessBuilder("/bin/bash", "-l", "-c", "adb get-serialno");
			BaseTest.process_devicename.redirectErrorStream(true);
			BaseTest.prc_devicename = BaseTest.process_devicename.start();
			r = new BufferedReader(new InputStreamReader(BaseTest.prc_devicename.getInputStream()));
			BaseTest.deviceName = r.readLine();
			BaseTest.prc_devicename.waitFor();
		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());		}
	}

	public static boolean isWindows() {

		return (BaseTest.OS.indexOf("win") >= 0);

		// return OS;
	}

	public static boolean isMac() {

		return (BaseTest.OS.indexOf("mac") >= 0);

	}

	public static boolean isUnix() {

		return (BaseTest.OS.indexOf("nix") >= 0 || BaseTest.OS.indexOf("nux") >= 0 || BaseTest.OS.indexOf("aix") > 0);

	}

	public static void getMachineOSName() {

		if (isWindows())
			BaseTest.machineOSName = "windows";
		else if (isMac())
			BaseTest.machineOSName = "mac";
		else if (isUnix())
			BaseTest.machineOSName = "unix";

		System.out.println(BaseTest.machineOSName);

	}

	public static String getDeviceName() {
		String deviceName = "";

		try {
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "adb get-serialno");
			builder.redirectErrorStream(true);
			Process prc;
			prc = builder.start();
			BufferedReader r = new BufferedReader(new InputStreamReader(prc.getInputStream()));
			deviceName = r.readLine();
			prc.waitFor();
		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());		}

		return deviceName;
	}

	static boolean isADBStarted_Win() {
		Process prc;
		boolean isStarted = false;
		try {
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "adb start-server");
			builder.redirectErrorStream(true);
			prc = builder.start();
			int exitValue = prc.waitFor();
			isStarted = (exitValue == 0) ? true : false;
		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());		}

		return isStarted;
	}

	static boolean isADBStarted_Mac() {
		Process prc;
		boolean isStarted = false;

		try {
			ProcessBuilder builder = new ProcessBuilder("./adb", "start-server");
			builder.directory(new File(System.getProperty("user.home") + "/Library/Android/sdk/platform-tools/"));
			prc = builder.start();
			int exitValue = prc.waitFor();
			isStarted = (exitValue == 0) ? true : false;
		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());		}

		return isStarted;
	}

	static boolean isAdbStarted_linux() {
		Process prc;
		boolean isStarted = false;

		try {
			ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-l", "-c", "adb start-server");
			builder.redirectErrorStream(true);
			prc = builder.start();
			int exitValue = prc.waitFor();
			isStarted = (exitValue == 0) ? true : false;
		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());		}

		return isStarted;

	}

	static String getAppiumVersion() {
		String appiumVersion = "0.0";
		try {
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "appium -v");
			builder.redirectErrorStream(true);
			Process prc;
			prc = builder.start();
			BufferedReader r = new BufferedReader(new InputStreamReader(prc.getInputStream()));
			appiumVersion = r.readLine();
			prc.waitFor();
		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());		}

		return appiumVersion;
	}

	public static String getAppiumVersion_Unix() {
		String appiumVersion = "0.0";
		try {
			ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-l", "-c", "appium -v");
			builder.redirectErrorStream(true);
			Process prc;
			prc = builder.start();
			BufferedReader r = new BufferedReader(new InputStreamReader(prc.getInputStream()));
			appiumVersion = r.readLine();
			prc.waitFor();
		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());		}

		return appiumVersion;
	}

	public static List<String> getDeviceInfo() {

		switch (BaseTest.machineOSName) {

		case "windows":
			BaseTest.path_to_chromedriver = new File(UserProperty.chromeDriver_PATH_WIN).getAbsolutePath();
			isADBStarted_Win();
			setWinEnv();
			break;

		case "mac":
			BaseTest.path_to_chromedriver = new File(UserProperty.chromeDriver_PATH_MAC).getAbsolutePath();
			isADBStarted_Mac();
			setMacEnv();
			break;

		case "unix":
			BaseTest.path_to_chromedriver = new File(UserProperty.chromeDriver_PATH_LIN).getAbsolutePath();
			isAdbStarted_linux();
			setOtherEnv();
			break;

		}

		BaseTest.deviceData.add(BaseTest.deviceName);

		BaseTest.deviceData.add(BaseTest.platformVersion);

		return BaseTest.deviceData;
	}

	public static void validateAndroidDevice() {

		if (!BaseTest.DeviceName.equals(getDeviceInfo().get(0)))
			BaseTest.DeviceName = getDeviceInfo().get(0);

		if (!BaseTest.platformVersion.equals(getDeviceInfo().get(1)))
			BaseTest.platformVersion = getDeviceInfo().get(1);

		System.out.println(BaseTest.DeviceName);

		System.out.println(BaseTest.platformVersion);

	}

	public static void validateiOSDevice() throws IOException {

		getiOSDeviceInfo();

//		if (isiOSSimulator == false) {

		if (deviceNamePool.contains(BaseTest.DeviceName.trim())) {

			int i = deviceNamePool.indexOf(BaseTest.DeviceName.trim());

			System.out.println(deviceOsPool.get(i));
			System.out.println(deviceUdidPool.get(i));

			System.out.println();

			if (BaseTest.platformVersion.equalsIgnoreCase(deviceOsPool.get(i))
					&& BaseTest.udid.equalsIgnoreCase(deviceUdidPool.get(i))) {

				System.out.println("Connected Device Found in App Properties");

			} else {

				BaseTest.DeviceName = realDeviceName;
				BaseTest.platformVersion = realDeviceOS;
				BaseTest.udid = realDeviceUDID;
			}

		}

		else {

			BaseTest.DeviceName = realDeviceName;
			BaseTest.platformVersion = realDeviceOS;
			BaseTest.udid = realDeviceUDID;
		}
		// }
	}

	public static String setTestExecutionPlatform() {
		String buildName, appName, buildExtn = null, platform = null;
		String buildPath = AppProperties.getProperty(UserProperty.APP_BUILD_PATH, null);

		if (buildPath.contains("/")) {
			String[] Build = buildPath.split("/");
			buildName = Build[1];

			if (buildName.contains(".")) {
				String[] Extn = buildName.split("\\.", buildName.lastIndexOf("."));
				appName = Extn[0];
				buildExtn = Extn[Extn.length - 1];
			}

			if (buildExtn != null) { // null check
				if (buildExtn.equals("ipa") || buildExtn.equals("app")) {
					if (buildExtn.equalsIgnoreCase("app")) {
						isiOSSimulator = true;
					}
					platform = UserProperty.iosPlatformname;

				} else {
					platform = UserProperty.androidPlatformName;
				}
			}
		}
		return platform;
	}

	public static void setAndroidcapabilities() {

		BaseTest.DeviceName = AppProperties.getProperty(UserProperty.APP_ANDROID_DEVICE_NAME, null);

		BaseTest.platformName = AppProperties.getProperty(UserProperty.APP_ANDROID_PLATFORM, "Android");

		BaseTest.platformVersion = AppProperties.getProperty(UserProperty.APP_ANDROID_VERSION, null);
	}

	public static void setIOScapabilities() {

		BaseTest.DeviceName = AppProperties.getProperty(UserProperty.APP_IOS_DEVICE_NAME, null);

		BaseTest.platformVersion = AppProperties.getProperty(UserProperty.APP_IOS_VERSION, "iOS");

		BaseTest.platformName = AppProperties.getProperty(UserProperty.APP_IOS_PLATFORM, null);

		BaseTest.udid = AppProperties.getProperty(UserProperty.APP_IOS_UDID, null);

	}

	public static int getTestCount(ITestContext ctx) {
		int count = 0;
		List<XmlSuite> m_suites = new ArrayList<XmlSuite>();
		m_suites.add(ctx.getCurrentXmlTest().getSuite());
		for (XmlSuite suite : m_suites) {
			 count += suite.getTests().size();
		}

		return count;
	}

}
