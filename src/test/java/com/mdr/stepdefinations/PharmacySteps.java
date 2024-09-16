package com.mdr.stepdefinations;

import com.mdr.base.BasePage;
import com.mdr.config.Hooks;
import com.mdr.pages.PharmacyPage;

import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;

public class PharmacySteps  extends BasePage{

	@SuppressWarnings("rawtypes")
	AppiumDriver driver = Hooks.getDriver();

	PharmacyPage pharmacyPage= new PharmacyPage(driver);
	
	@Then("^user select Pharmacy \"([^\"]*)\" service and validate$")
	public void user_select_Pharmacy_service_and_validate(String Pharmacy) throws Throwable {
	   pharmacyPage.selectPharmacy(Pharmacy);
	}
}
