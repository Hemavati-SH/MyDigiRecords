package com.peopleinteractive.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.peopleinteractive.base.BasePage;
import com.peopleinteractive.utils.AppStringConstants;
import com.peopleinteractive.utils.JSONUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.Alert;


public class LoginPage extends BasePage {
	public AppiumDriver driver;
	public static String username;
	public static String password;
	LoginPage login;

	@SuppressWarnings("static-access")
	public LoginPage()

	{
		this.driver = new com.peopleinteractive.configs.Hooks().getDriver();
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}
	
	@AndroidFindBy(id = "com.shaadi.android:id/gmail")
	public MobileElement googleLoginButton;


	@iOSXCUITFindBy(id = "Login with password")
	@AndroidFindBy(id = "com.shaadi.android:id/tvLoginWithPassword")
	public MobileElement txt_loginWithPassword;

	@iOSXCUITFindBy(id = "leftArrow")
	@AndroidFindBy(id = "com.shaadi.android:id/tvLoginWithPassword")
	public MobileElement left_arrow_backbutton;
	
	@AndroidFindBy(id = "com.shaadi.android:id/tvFooterServerError")
	public MobileElement txt_OtpLimitExceedFooterServerError;

	@AndroidFindBy(id = "com.shaadi.android:id/tvFooterError")
	public MobileElement txt_OtpLimitExceedFooterError;

	@iOSXCUITFindBy(id = AppStringConstants.OTPExceededLimit)
	@AndroidFindBy(id = "com.shaadi.android:id/tvLimitExceedError")
	public MobileElement txt_OtpLimitExceedError;

	@iOSXCUITFindBy(id = "buttonsendOTP")
	@AndroidFindBy(id = "com.shaadi.android:id/btn_login_with_otp")
	public MobileElement LoginWithOTPButton;

	@iOSXCUITFindBy(id = "Try again")
	public MobileElement try_AgainButton;

	@iOSXCUITFindBy(id = "Allow")
	public MobileElement Allow_notifications;

	@iOSXCUITFindBy(id = "labelAccountExists")
	public MobileElement label_Account_Exists;
;
   @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Forgot Password\"]/XCUIElementTypeButton")
   public MobileElement forgetpwdbackbutton;
	
	@iOSXCUITFindBy(accessibility = "Login")
	@AndroidFindBy(id = "com.shaadi.android:id/btn_morph_login")
	public MobileElement btnNavigateSignIn;

	@iOSXCUITFindBy(accessibility ="Continue with Password")
	@AndroidFindBy(id = "com.shaadi.android:id/btn_morph_login")
	public MobileElement ContinueWithpassword;
	
	@iOSXCUITFindBy(accessibility ="Continue with OTP")
	@AndroidFindBy(id = "com.shaadi.android:id/btn_morph_login")
	public MobileElement ContinueWithOTP;
	
	@iOSXCUITFindBy(className = "XCUIElementTypeImage")
	@AndroidFindBy(id = "com.shaadi.android:id/img_cancel")
	public MobileElement imgVIPShaadiCancel;

	@iOSXCUITFindBy(accessibility = "buttonSignIn")
	public MobileElement btnNavigateSignIniOS; // NEW SPLASH SCREEN LOGIN BUTTON

	@iOSXCUITFindBy(accessibility = "textfieldemailMobileField")
	@AndroidFindBy(id = "com.shaadi.android:id/edt_username")
	public MobileElement editTextUserName;

	@iOSXCUITFindBy(accessibility = "textfieldpasswordField")
	@AndroidFindBy(id = "com.shaadi.android:id/edt_password")
	public MobileElement editTextPassword;

	//@iOSXCUITFindBy(id = "buttonsignInButton")
	@iOSXCUITFindBy(accessibility = "Login")
//	buttonsignInWithPassword v7.21.1 (1.0)
	@AndroidFindBy(id = "com.shaadi.android:id/btn_login")
	public MobileElement btnMainSignIn;

	@iOSXCUITFindBy(accessibility = "buttonForgotPassword")
	@AndroidFindBy(id = "com.shaadi.android:id/tv_forgot_password")
	public MobileElement textviewForgotPassword;

	@iOSXCUITFindBy(className = "XCUIElementTypeAlert")
	public MobileElement Alert;

	@iOSXCUITFindBy(className = "XCUIElementTypeSheet")
	public MobileElement BottomAlert;

	@iOSXCUITFindBy(id = "OK")
	public MobileElement Ok;

	@iOSXCUITFindBy(id = "Cancel")
	public MobileElement Cancel;

	@AndroidFindBy(id = "com.shaadi.android:id/til_username")
	public MobileElement LayoutEmail;

	@AndroidFindBy(id = "com.shaadi.android:id/til_password")
	public MobileElement Layoutpassword;

	@iOSXCUITFindBy(accessibility = "btnRegisterFree.label")
	public MobileElement btnSignUp;

	@iOSXCUITFindBy(id = "buttonSignUp")
	@AndroidFindBy(id = "com.shaadi.android:id/btn_morph_sign_up")
	public MobileElement btnSignupFree;
	
	@iOSXCUITFindBy(id="buttoncreateForFree")
	public MobileElement btn_SignUpFreeOnLogin;

	@iOSXCUITFindBy(id = "buttonsignUpFree")
	public MobileElement btn_SignupOnLoginPage;

	@iOSXCUITFindBy(id = "Sign Up Free")
	public MobileElement Sign_Up_Free
;
	
	@iOSXCUITFindBy(id = "Forgot Password?")
	@AndroidFindBy(id = "com.shaadi.android:id/tv_forgot_password")
	public MobileElement tvForgotPswd;

	@iOSXCUITFindBy(accessibility = "buttonForgotPassword")
	@AndroidFindBy(id = "com.shaadi.android:id/forgotPw_text")
	public MobileElement btnForgotPswd;

	@FindBy(className = "android.widget.TextView")
	public MobileElement txtForgotPswd;

	@iOSXCUITFindBy(className = "XCUIElementTypeStaticText")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Forgot Password\")")
	public MobileElement forgotPasswordTitle;

	@AndroidFindBy(id = "com.shaadi.android:id/menu_skip")
	public static MobileElement paymentSkip;

	@AndroidFindBy(id = "com.shaadi.android:id/lbl_skip")
	public static MobileElement connectionSkip;

	@AndroidFindBy(id = "com.shaadi.android:id/tv_skip")
	public static MobileElement acceptStopPageSkip;

	@AndroidFindBy(className = "android.widget.ImageButton")
	public static MobileElement paymentArrowBack;

	@FindBy(id = "com.shaadi.android:id/textView_upgrade_title")
	public static MobileElement upgradeToPremiumNow;

	@FindBy(id = "com.shaadi.android:id/btnGotIt")
	public static MobileElement btnGotIt;
	
	
	@FindBy(id = "com.google.android.gms:id/add_account_chip_title")
	public MobileElement addAnotherAccount;
	
	@FindBy( id = "com.google.android.gms:id/account_name")
	public MobileElement existingEmailIdGoogleSignUp;
	
	@FindBy(xpath = "//android.widget.Button[@text = 'ACCEPT']")
	public MobileElement acceptBtnGoogleSignUpPage;
	
	@FindBy(id = "signinconsentNext")
	public MobileElement iAgreeButtonGoogleSignupPage;
	
	@FindBy(id = "passwordNext")
	public MobileElement passwordNextGoogleSignupPage;
	
	@FindBy(xpath = "//android.view.View[@id='password']/android.view.View/android.view.View/android.widget.EditText")
	public MobileElement passwordTextBoxGmail;

	//@FindBy(id = "identifierId")
	@AndroidFindBy(xpath = "//input[@type = 'email']")
	public MobileElement gmailTextBox;
	
	@FindBy(id = "identifierNext")
	public MobileElement nextGoogleSignUpPage;
	
	@AndroidFindBy(id = "com.shaadi.android:id/gsignin")
	public MobileElement GoogleSignUpBtn;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	@iOSXCUITFindBy(id = "arrow left white")
	public MobileElement btn_back;

	
	public void Allow() throws Exception {
		ClickNoException(Allow_notifications, 3, "Click Allow Notifications", "Login-01", driver);
	}

	public void Continue_with_password() throws Exception {
		Thread.sleep(3000); // Added for plcoudy as it takes some time for loading homepage
		
		
		clickButton(ContinueWithpassword, driver);
		

	}
	

	public void Continue_with_otp() throws Exception {
		Thread.sleep(3000); // Added for plcoudy as it takes some time for loading homepage
		
		clickButton(ContinueWithOTP, driver);
		

	}
	public void NavigateSignIn() throws Exception {
		Thread.sleep(3000); // Added for plcoudy as it takes some time for loading homepage
		
		
		clickButton(btnNavigateSignIn, driver);
		

	}
	
	
	public void NavigateSignInCustom() throws Exception {
		Thread.sleep(3000); // Added for plcoudy as it takes some time for loading homepage
		waitForVisibilityOf(btnNavigateSignIn, driver);
		clickButton(btnNavigateSignIn, driver);
	}

	public void NavigateSignIniOS() throws Exception {
		clickButton(btnNavigateSignIniOS, driver);
	}

	public void InputUserNamePassword(String UserName, String Password) throws Exception {

		driver.getKeyboard();
		driver.hideKeyboard();
		inputText(UserName, editTextUserName, driver);
		inputText(Password, editTextPassword, driver);


		if (System.getProperty("platform").equalsIgnoreCase("android")) {
			driver.getKeyboard();
			driver.hideKeyboard();
		}

	}
	
	
	public void InputUserNamePasswordCustom(String UserName, String Password) throws Exception {

		driver.getKeyboard();
		driver.hideKeyboard();
		inputText(UserName, editTextUserName, driver);
		inputText(Password, editTextPassword, driver);

//		InputValueCustom(editTextUserName, UserName, "Input Valid UserName");
//
//		InputValueCustom(editTextPassword, Password, "Input Valid Password");

//		   if (BaseTest.AutomationRunName.equals("Appium"))
		if (System.getProperty("platform").equalsIgnoreCase("ios")) {
			driver.getKeyboard();
			driver.hideKeyboard();
		}

	}

	public void ClickSignIn() throws Exception {

		clickButton(btnMainSignIn, driver);

			Thread.sleep(5000);
	}
	
	public void ClickSignInCustom(boolean islogout) throws Exception {

		clickButton(btnMainSignIn, driver);
//		for random banner
//id=imageViewBanner
//xpath=//XCUIElementTypeImage[@name="imageViewBanner"]
		if (islogout)
			Thread.sleep(5000);
	}

	

	public void VerifyAlertMessage(String ExpectedText) throws InterruptedException {

			try {
			    WebDriverWait wait = new WebDriverWait(driver, 2);
			    wait.until(ExpectedConditions.alertIsPresent());
//			    String expectedText="Confirm Profile Deletion? This will result in the permanent loss of your Profile info, all Matches you’ve liked, connected or contacted & Chat history.";
			    Alert alert = driver.switchTo().alert();
			    System.out.println(alert.getText());
//				assertEquals(alert.getText(), expectedText);
			    Assert.assertTrue(alert.getText().contains(ExpectedText));
				System.out.print(alert.getText().toString());
				Thread.sleep(1000);
			} catch (Exception e) {
			    //exception handling
			}

	}

	
	public void ClickOK() throws Exception {
//		if (isDisplayedAfterWait(Ok, 2))
////			clickButton(Ok, "Click Ok to close alert!", "Login-10");
//			System.out.println("Auto accepting ok ");
//		else if (isDisplayedAfterWait(Cancel, 2))
//			clickButton(Cancel, "Click Try Again button to close alert!", "Login-10");
//		else
//			clickButton(try_AgainButton, "Click Try Again button to close alert!", "Login-10");

		if (isElementPresent(Ok)||isElementPresent(Cancel)||isElementPresent(try_AgainButton)) {
			System.out.println("Auto accepting ok ");

		}
		
		else if (isElementPresent(btnNavigateSignIn)) {
			login = new LoginPage();			
			NavigateSignInCustom();

			if (System.getProperty("platform").equalsIgnoreCase("ios")) {
					login.Continue_with_otp();

				}			
				
		}	
		else {
			System.out.println("No conditions matched");

		}
		
	}
	public void ClickOKLogin() throws Exception {
		if (isDisplayedAfterWait(Ok, 2)) {
			clickButton(Ok, driver);
			System.out.println("Auto accepting ok ");}
		else if (isDisplayedAfterWait(Cancel, 2))
			clickButton(Cancel, driver);
		else if (isDisplayedAfterWait(try_AgainButton, 2))
			clickButton(try_AgainButton, driver);

		else if (isElementPresent(btnNavigateSignIn)) {
			login = new LoginPage();			
			NavigateSignInCustom();

			if (System.getProperty("platform").equalsIgnoreCase("ios")) {
					login.Continue_with_otp();

				}			
				
		}	
		else {
			System.out.println("No conditions matched");

		}
		
//		if (isElementPresent(Ok)||isElementPresent(Cancel)||isElementPresent(try_AgainButton)) {
//			System.out.println("Auto accepting ok ");
//
//		}
		
	}
	public void ClickOK_FP() throws Exception {
//		if (isDisplayedAfterWait(Ok, 2))
////			clickButton(Ok, "Click Ok to close alert!", "Login-10");
//			System.out.println("Auto accepting ok ");
//		else if (isDisplayedAfterWait(Cancel, 2))
//			clickButton(Cancel, "Click Try Again button to close alert!", "Login-10");
//		else
//			clickButton(try_AgainButton, "Click Try Again button to close alert!", "Login-10");

		if (isElementPresent(Ok)||isElementPresent(Cancel)||isElementPresent(try_AgainButton)) {
			
			System.out.println("Auto accepting ok ");
Thread.sleep(2000);

		}
		else if (isElementPresent(label_Account_Exists)) {
			
			login = new LoginPage();			
			NavigateSignInCustom();
			login.Continue_with_password();		
			clickButton(login.tvForgotPswd, driver);

		}	
		
		else {
			
			System.out.println("No conditions matched");

		}
		
	}
	public void ClickCancel() throws Exception {
		clickButton(Cancel, driver);
	}



	public void NavigateSignUpFree() throws Exception {
        waitForAvailabilityOf(btnSignupFree, driver);
		clickButton(btnSignupFree, driver);
	}

	public void ClickVIPShaadiCancelIcon() throws Exception {
		ClickNoException(imgVIPShaadiCancel, 5, "Click on VIP Image", "Login-07", driver);
	}

	public void quickLogin(String userType) throws Exception{
		login = new LoginPage();
		
		List<String> data = JSONUtils.getuserData(userType);
		
		username = data.get(0);
		password = data.get(1);
		
		NavigateSignInCustom();

		if (System.getProperty("platform").equalsIgnoreCase("ios")) {
			login.Continue_with_password();
		}		
		
		this.InputUserNamePasswordCustom(username, password);
		this.ClickSignInCustom(false);
		
		Thread.sleep(7000);
	}
	
	public void quickLogin(String username , String password) throws Exception{
		
		//login = new LoginPage();			
		
		this.InputUserNamePasswordCustom(username, password);
		this.ClickSignInCustom(false);
		
		Thread.sleep(6000);
	}

	
	public  void ClickAcceptStopPageSkip() throws Exception {
		 ClickNoException(acceptStopPageSkip, 5, "Click on Skip on Accept Stop Page", "Login-06", driver);
	 }
	 
	 public  void ClickPaymentSkip() throws Exception {
		  ClickNoException(paymentSkip, 5, "Click Skip on payment stoppage", "Login-06", driver);
		 }
	 
	 public  void ClickConnectSkip() throws Exception {
		  ClickNoException(connectionSkip, 5, "Click on Connection stoppage skip", "Login-07", driver);
		 }

	

	 public  void ClickPaymentActionBarBack() throws Exception{
		try {
			 if(upgradeToPremiumNow.isDisplayed()) {
				 
				 ClickNoException(paymentArrowBack, 5, "Click on Payment Arrow Back", "Login-07", driver);
			 }
		}
		
		catch(Exception e){
			System.out.println("");
		}
		 
	 }
	public  void ClickGotit() throws Exception {
	  ClickNoException(btnGotIt, 5, "Click on Button Got it", "Login-06", driver);
	 }

	
	
}
