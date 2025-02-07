package com.mdr.stepDefinitions;

import com.mdr.base.BasePage;
import com.mdr.config.Hooks;
import com.mdr.pages.LoginPage;
import com.mdr.pages.MemberPage;
import com.mdr.pages.NewAppLoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class NewAppLoginSteps extends BasePage {
	
@SuppressWarnings("rawtypes")
	
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private NewAppLoginPage newloginPage = new NewAppLoginPage(driver);
	MemberPage memberPage = new MemberPage(driver);
   
   @Given("^User Navigate to country selection page for new app$")
   public void user_Navigate_to_country_selection_page_for_new_app() throws Throwable {
	   
   }
   
   @Then("^User select country \"([^\"]*)\" for new app$")
   public void user_select_country_for_new_app(String country) throws Throwable {
     newloginPage.selectCountry(country);
   }

   @Then("^User Navigate to new app Login page$")
   public void user_Navigate_to_new_app_Login_page() throws Throwable {
	   
   }

   @Then("^user enter valid credentials \"([^\"]*)\" \"([^\"]*)\" for new app$")
   public void user_enter_valid_credentials_for_new_app(String email, String password) throws Throwable {
	   newloginPage.login(email, password);
	   newloginPage.selectLocationPermission();
   }
   
   @Then("^validate the home page for new app$")
   public void validate_the_home_page_for_new_app() throws Throwable {
	   newloginPage.validateLogin();
	}

}
