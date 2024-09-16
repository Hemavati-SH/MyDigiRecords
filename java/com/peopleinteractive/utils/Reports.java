package com.peopleinteractive.utils;
//package shaadi.utils;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//
//import data.VerificationData;
//
//
//public class Reports {
//	public static ExtentReports report = null;
//	public static ExtentTest extentTest;
//	static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
//	static String date = f.format(new Date()).toString();
//	static String report_name = VerificationData.reportName+"_"+date+".html";
//	
//
//	public static ExtentReports getReports(String baseDirPath) {
//		if (report == null) {
//			
//			report = new ExtentReports(baseDirPath
//					+ report_name);
//			report.addSystemInfo("Selenium Version",
//					VerificationData.seleniumVersion);
//		}
//		return report;
//	}
//}
