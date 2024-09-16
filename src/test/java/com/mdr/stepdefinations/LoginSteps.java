package com.mdr.stepdefinations;

import com.mdr.base.BasePage;
import com.mdr.config.Hooks;
import com.mdr.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;

public class LoginSteps extends BasePage{
	
	@SuppressWarnings("rawtypes")
	AppiumDriver driver = Hooks.getDriver();

   LoginPage loginPage = new LoginPage(driver);
   
   
   @Given("^User Navigate to country selection page$")
   public void user_Navigate_to_country_selection_page() throws Throwable {
	   
   }
   
   @Then("^User select country \"([^\"]*)\"$")
   public void user_select_country(String country) throws Throwable {
     loginPage.selectCountry(country);
   }

   @Then("^User Navigate to Login page$")
   public void user_Navigate_to_Login_page() throws Throwable {

	   loginPage.selectLocationPermission();
   }

   @Then("^user enter valid credentials \"([^\"]*)\" \"([^\"]*)\"$")
   public void user_enter_valid_credentials(String email, String password) throws Throwable {

	   loginPage.login(email, password);
   }
   
   @Then("^validate the home page$")
   public void validate_the_home_page() throws Throwable {
	   loginPage.validateLogin();
	}

}
