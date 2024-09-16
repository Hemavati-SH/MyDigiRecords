package com.mdr.stepdefinations;

import com.mdr.base.BasePage;
import com.mdr.config.Hooks;
import com.mdr.pages.MedicationPage;

import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;

public class MedicationSteps extends BasePage {

	@SuppressWarnings("rawtypes")
	AppiumDriver driver = Hooks.getDriver();

	MedicationPage medicationpage = new MedicationPage(driver);

	@Then("^user add Medicine \"([^\"]*)\"$")
	public void user_add_Medicine(String Medicine) throws Throwable {
		medicationpage.addMedicine(Medicine);

	}

	@Then("^user select Frequency$")
	public void user_select_Frequency() throws Throwable {
		medicationpage.selectFrequency();
	}

	@Then("^user Validate the added \"([^\"]*)\"$")
	public void user_Validate_the_added(String Medicine) throws Throwable {
		medicationpage.validateAddedMedicine(Medicine);
	}

}
