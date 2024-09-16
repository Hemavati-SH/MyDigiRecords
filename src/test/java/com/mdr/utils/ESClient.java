
package com.mdr.utils;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.testng.ITestResult;

import io.appium.java_client.AppiumDriver;

public class ESClient {

	public void insertData(AppiumDriver driver, ITestResult result, String deviceName, String platformVersion,
			String platformName, String appiumVersion, String udid, String testScenario, String pod) {
		try {
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
			String date = f.format(new Date()).toString();
			String res = "NA";
			String failmessage = "";
			if (result.getStatus() == ITestResult.FAILURE) {
				res = "FAIL";
				if (result.getThrowable() != null) {
					final Throwable testResultThrowable = result.getThrowable();
					failmessage = testResultThrowable.getMessage() != null ? testResultThrowable.getMessage()
							: testResultThrowable.getCause().getMessage();

					if (failmessage == null) {
						failmessage = "Test failed";
					}

				}
			} else if (result.getStatus() == ITestResult.SKIP) {
				res = "SKIP";
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				res = "PASS";
			}

			HashMap<Object, Object> requestParams = new HashMap<Object, Object>();

			requestParams.put("testclass", result.getInstanceName());
			requestParams.put("testmethod", result.getName());
			requestParams.put("testsuite", result.getTestContext().getCurrentXmlTest().getSuite().getName());
			requestParams.put("testcaseresult", res);
			requestParams.put("testfailmessage", failmessage); // FIX FOR NULL POINTER EXCEPTION NEEDED
			requestParams.put("testscenario", testScenario);
			requestParams.put("testtime",
					TimeUnit.MILLISECONDS.toSeconds(result.getEndMillis() - result.getStartMillis()));
			requestParams.put("apkdetails", ""); // FIX FOR NULL POINTER EXCEPTION NEEDED

			requestParams.put("gitbranch", "develop_studio");
			requestParams.put("environment", "production");
			requestParams.put("exetype", "adhoc");

			// requestParams.put("appiumsessionid", driver.getSessionId().toString()); //FIX
			// FOR NULL POINTER EXCEPTION NEEDED
			requestParams.put("appiumVersion", appiumVersion);
			// requestParams.put("noreset",
			// driver.getCapabilities().getCapability("noReset").toString()); //FIX FOR NULL
			// POINTER EXCEPTION NEEDED
			// requestParams.put("fullReset",
			// driver.getCapabilities().getCapability("fullReset").toString()); //FIX FOR
			// NULL POINTER EXCEPTION NEEDED

			requestParams.put("deviceModel", driver.getCapabilities().getCapability("deviceModel").toString());
			requestParams.put("deviceName", driver.getCapabilities().getCapability("deviceName").toString());
			requestParams.put("deviceManufacturer",
					driver.getCapabilities().getCapability("deviceManufacturer").toString());
			requestParams.put("deviceScreenSize",
					driver.getCapabilities().getCapability("deviceScreenSize").toString());
			requestParams.put("udid", udid);
			requestParams.put("platformVersion", platformVersion);
			requestParams.put("platformName", platformName);

			requestParams.put("timestamp", date);
			requestParams.put("username", System.getProperty("user.name"));
			requestParams.put("os", System.getProperty("os.name"));
			requestParams.put("hostname", InetAddress.getLocalHost().getHostName());
			requestParams.put("pod", pod);

			JSONObject requestParamsJson = new JSONObject(requestParams);

			HttpClient httpClient = HttpClientBuilder.create().build();
			StringEntity params = new StringEntity(requestParamsJson.toString());
			HttpPost request = new HttpPost("http://34.227.112.200:9200/app-automation-results1/posts");
			request.addHeader("Content-Type", "application/json");
			request.setEntity(params);
			HttpResponse response = httpClient.execute(request);
			System.out.println(response.getStatusLine().getStatusCode());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(
					"Timed out connecting to ESClient http://34.227.112.200:9200 , please check vpn connection");
			// e.printStackTrace();

		}
	}

}