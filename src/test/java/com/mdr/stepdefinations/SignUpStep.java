package com.mdr.stepdefinations;

import com.mdr.base.BasePage;
import com.mdr.config.Hooks;
import com.mdr.pages.LoginPage;
import com.mdr.pages.SignUpPage;

import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;

public class SignUpStep extends BasePage {

	@SuppressWarnings("rawtypes")
	AppiumDriver driver = Hooks.getDriver();

	LoginPage loginPage = new LoginPage(driver);

	SignUpPage signUpPage = new SignUpPage(driver);

	@Then("^user clicks on signUp$")
	public void user_clicks_on_signUp() throws Throwable {
		signUpPage.clickSignUp();
	}

	@Then("^User select country code and enter Phone number \"([^\"]*)\"$")
	public void user_select_country_code_and_enter_Phone_number(String Number) throws Throwable {
		signUpPage.selectCountrycode();
		signUpPage.enterPhoneNumber(Number);
	}

	@Then("^User Enter firstName \"([^\"]*)\" , MiddleName \"([^\"]*)\" and LastName \"([^\"]*)\"$")
	public void user_Enter_firstName_MiddleName_and_LastName(String FirstName, String MiddleName, String LastName)
			throws Throwable {
		signUpPage.enterfirstnamelastname(FirstName, MiddleName, LastName);
	}
	
	@Then("^user Enter Email \"([^\"]*)\"$")
	public void user_Enter_Email(String Email) throws Throwable {
	    signUpPage.enterEmail(Email);
	}

	@Then("^User Enter Date of Birth \"([^\"]*)\"$")
	public void user_Enter_Date_of_Birth(String dob) throws Throwable {
		signUpPage.dateOfBirth(dob);
	}

	@Then("^User Enter password \"([^\"]*)\" and Confirm Password \"([^\"]*)\"$")
	public void user_Enter_password_and_Confirm_Password(String password, String confirmpassword) throws Throwable {
		signUpPage.enterpassword(password, confirmpassword);
	}

	@Then("^User click iAgree and contine button$")
	public void user_click_iAgree_and_contine_button() throws Throwable {
		signUpPage.iAgreeclick();
		signUpPage.continuebutton();
	}

}
