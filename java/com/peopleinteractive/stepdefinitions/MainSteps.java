 package com.peopleinteractive.stepdefinitions;
import com.peopleinteractive.pages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;


public class MainSteps {

	
	private LoginPage login;


 
	

	@SuppressWarnings("rawtypes")
	public AppiumDriver driver;
	
	@Given("^user navigates to login screen after accepting all permissions if app is installed on the device\\.$")
	public void user_navigates_to_login_screen_after_accepting_all_permissions_if_app_is_installed_on_the_device() throws Throwable {

	}

	@Given("^User Navigate to sign in page$")
	public void user_Navigate_to_sign_in_page() throws Throwable {
		login =new LoginPage();
		login.NavigateSignIn();

	}
	
	@Then("^user clicks on continue with password option$")
	public void user_clicks_on_continue_with_password_option() throws Throwable {
		if (System.getProperty("platform").equalsIgnoreCase("ios")) {
			login.Continue_with_password();

		}
	}

	@Then("^user clicks on SignIn button$")
	public void user_clicks_on_SignIn_button() throws Throwable {
		Thread.sleep(1000);
		login.ClickSignIn();
	}
	
	@Then("^Verify login functionality for below test data$")
	public void verify_login_functionality_for_below_test_data() throws Throwable {
		String expectedtext="Invalid Mobile No.";
		login.VerifyAlertMessage(expectedtext);
	}

	@When("^user enters the Incorrect Mobile no \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_Incorrect_Mobile_no_and(String arg1, String arg2) throws Throwable {
		login.InputUserNamePasswordCustom(arg1, arg2);

	}

	@Then("^Verify login functionality for Incorrect Mobile no$")
	public void verify_login_functionality_for_Incorrect_Mobile_no() throws Throwable {
		String expectedtext="Invalid Mobile No.";
		login.VerifyAlertMessage(expectedtext);

	}

	@Then("^user will clicks on OK button to close pop up$")
	public void user_will_clicks_on_OK_button_to_close_pop_up() throws Throwable {
		login.ClickOKLogin();
	}
	
	@When("^user enters the same number \"([^\"]*)\" and \"([^\"]*)\" for Multiple profiles$")
	public void user_enters_the_same_number_and_for_Multiple_profiles(String arg1, String arg2) throws Throwable {
		login.InputUserNamePasswordCustom(arg1, arg2);

	}

	@Then("^Verify login functionality for Multiple profiles with same mobile number$")
	public void verify_login_functionality_for_Multiple_profiles_with_same_mobile_number() throws Throwable {
		String expectedtext="This no. is already in use";
		login.VerifyAlertMessage(expectedtext);
	}

	@When("^user enters the Unregistered mobile number \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_Unregistered_mobile_number_and(String arg1, String arg2) throws Throwable {
		login.InputUserNamePasswordCustom(arg1, arg2);

	}

	@Then("^Verify login functionality for Unregistered mobile number$")
	public void verify_login_functionality_for_Unregistered_mobile_number() throws Throwable {
		String expectedtext="Mobile no. not registered";
		login.VerifyAlertMessage(expectedtext);
	}

	@When("^user enters the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_and(String arg1, String arg2) throws Throwable {
		login.InputUserNamePasswordCustom(arg1, arg2);

	}

	@Then("^Verify login functionality for Incorrect Email$")
	public void verify_login_functionality_for_Incorrect_Email() throws Throwable {
		String expectedtext="Invalid Email ID";
		login.VerifyAlertMessage(expectedtext);
	}

	@When("^user enters the Email not Registered \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_Email_not_Registered_and(String arg1, String arg2) throws Throwable {
		login.InputUserNamePasswordCustom(arg1, arg2);

	}

	@Then("^Verify login functionality for Email not Registered$")
	public void verify_login_functionality_for_Email_not_Registered() throws Throwable {
		String expectedtext="Email ID not registered";
		login.VerifyAlertMessage(expectedtext);
	}

	@When("^user enters the Blank Email \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void user_enters_the_Blank_Email_and_Password(String arg1, String arg2) throws Throwable {
		login.InputUserNamePasswordCustom(arg1, arg2);

	}

	@Then("^Verify login functionality for Blank Email$")
	public void verify_login_functionality_for_Blank_Email() throws Throwable {
		String expectedtext="No details entered";
		login.VerifyAlertMessage(expectedtext);
	}

	@When("^user enters the Incorrect password \"([^\"]*)\"$")
	public void user_enters_the_Incorrect_password(String arg1) throws Throwable {
		login.InputUserNamePasswordCustom(arg1, arg1);

	}

	@Then("^Verify login functionality for Incorrect password$")
	public void verify_login_functionality_for_Incorrect_password() throws Throwable {
		String expectedtext="Incorrect Password";
		login.VerifyAlertMessage(expectedtext);
	}

	@When("^user enters the Email not present \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_Email_not_present_and(String arg1, String arg2) throws Throwable {
		login.InputUserNamePasswordCustom(arg1, arg2);

	}

	@Then("^Verify login functionality for Email not present$")
	public void verify_login_functionality_for_Email_not_present() throws Throwable {
		String expectedtext="No details entered";
		login.VerifyAlertMessage(expectedtext);
	}

	@When("^user enters the Correct \"([^\"]*)\" id and \"([^\"]*)\"$")
	public void user_enters_the_Correct_id_and(String arg1, String arg2) throws Throwable {
		login.InputUserNamePasswordCustom(arg1, arg2);

	}

	@Then("^Verify login functionality for Correct mobile number and password$")
	public void verify_login_functionality_for_Correct_mobile_number_and_password() throws Throwable {
		String expectedtext="Invalid Mobile No.";
		login.VerifyAlertMessage(expectedtext);
	}

	@Given("^user will Navigate to My Shaadi page\\.$")
	public void user_will_Navigate_to_My_Shaadi_page() throws Throwable {

	}

	@Then("^user will Scroll and click on Account settings\\.$")
	public void user_will_Scroll_and_click_on_Account_settings() throws Throwable {

	}

	@Then("^user clicks on logout button\"$")
	public void user_clicks_on_logout_button() throws Throwable {

	}

	@Then("^verify logout functionality$")
	public void verify_logout_functionality() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}



}
