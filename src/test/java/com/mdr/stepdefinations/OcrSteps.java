package com.mdr.stepdefinations;

import com.mdr.base.BasePage;
import com.mdr.config.Hooks;
import com.mdr.pages.OCRPage;

import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;

public class OcrSteps extends BasePage {
	
	@SuppressWarnings("rawtypes")
	AppiumDriver driver = Hooks.getDriver();
	
	OCRPage ocrPage= new OCRPage(driver);
	
	
	@Then("^user click OCR and select medicince and scann medicine \"([^\"]*)\"$")
	public void user_click_OCR_and_select_medicince_and_scann_medicine(String photopath) throws Throwable {
	   ocrPage.uploadAdPhotos(photopath);
	}

	@Then("^user add medicine and medicine Strenght \"([^\"]*)\"$")
	public void user_add_medicine_and_medicine_Strenght(String strenght) throws Throwable {
	   ocrPage.AddMedicine(strenght);
	}

	@Then("^user select Frequency \"([^\"]*)\"$")
	public void user_select_Frequency(String arg1) throws Throwable {
	    ocrPage.selectFrequency(arg1);
	}
}
