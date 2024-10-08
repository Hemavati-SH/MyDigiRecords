package com.mdr.utils;

import io.appium.java_client.android.AndroidDriver;

public class ThreadLocalDriver {
	@SuppressWarnings("rawtypes")
	private static ThreadLocal<AndroidDriver> tlDriver = new ThreadLocal<>();

	public synchronized static void setTLDriver(AndroidDriver<?> driver) {
		tlDriver.set(driver);
	}

	public synchronized static AndroidDriver<?> getTLDriver() {
		return tlDriver.get();
	}
}
