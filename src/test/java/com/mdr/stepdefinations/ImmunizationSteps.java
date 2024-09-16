package com.mdr.stepdefinations;

import com.mdr.base.BasePage;
import com.mdr.config.Hooks;
import com.mdr.pages.ImmunizationPage;
import com.mdr.pages.LoginPage;

import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;

public class ImmunizationSteps extends BasePage {

	@SuppressWarnings("rawtypes")
	AppiumDriver driver = Hooks.getDriver();

   LoginPage loginPage = new LoginPage(driver);
   
   ImmunizationPage immunizationPage = new ImmunizationPage(driver);
	

@Then("^user select immunization serivce$")
public void user_select_immunization_serivce() throws Throwable {
   immunizationPage.selectserive();
}

@Then("^user add Immunization details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
public void user_add_Immunization_details(String imName, String Dose, String Date) throws Throwable {
	immunizationPage.addImmunization(imName, Dose, Date);
    
}

@Then("^user select time and location \"([^\"]*)\"$")
public void user_select_time_and_location(String location) throws Throwable {
    immunizationPage.selectTime();
    immunizationPage.selectLocation(location);
}
}
