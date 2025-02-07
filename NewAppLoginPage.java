package com.mdr.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mdr.base.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewAppLoginPage extends BasePage {
	@SuppressWarnings("rawtypes")
	private AppiumDriver<MobileElement> driver;
	private WebDriverWait wait;


	@SuppressWarnings("rawtypes")
	public NewAppLoginPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}
	
	@AndroidFindBy(xpath ="//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
	public MobileElement Allow;
	
	@AndroidFindBy(xpath ="//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button']")
	public MobileElement DontAllow;
	
	@AndroidFindBy(xpath ="//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")
	public MobileElement whileusingtheapp;
	
	@AndroidFindBy(xpath ="//android.view.ViewGroup[@content-desc='English']/android.view.ViewGroup/android.widget.ImageView")
	public MobileElement selectCountryoption;
	
	@AndroidFindBy(xpath ="//android.widget.ImageView")
	public MobileElement countrydropdown;
	
	@AndroidFindBy(xpath ="//android.view.ViewGroup[@content-desc='India']")
	public MobileElement India;
	
	@AndroidFindBy(xpath ="(//android.view.ViewGroup[@content-desc='United States'])[2]")
	public MobileElement UnitedStates;
	
	@AndroidFindBy(xpath ="//android.view.ViewGroup[@content-desc='South Africa']")
	public MobileElement SouthAfrica;
	
	@AndroidFindBy(xpath ="//android.view.ViewGroup[@content-desc='Middle East Countries']")
	public MobileElement MiddleEastCountries;
	
	@AndroidFindBy(xpath ="//android.view.ViewGroup[@content-desc='English']/android.widget.ImageView")
	public MobileElement languagedropdown;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='English']")
	public MobileElement English;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Espanol']")
	public MobileElement Espanol;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='हिंदी']")
	public MobileElement Hindi;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='తెలుగు']")
	public MobileElement Telagu;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='मराठी']]")
	public MobileElement Marati;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='ಕನ್ನಡ']")
	public MobileElement Kannada;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='ਪੰਜਾਬੀ']")
	public MobileElement Punjabi;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='عربي']")
	public MobileElement Urdu;
	
	@AndroidFindBy(xpath ="//android.widget.EditText[@text='Enter Email Id']")
	public MobileElement Emailid;
	
	@AndroidFindBy(xpath ="//android.widget.EditText[@text='Enter Password']")
	public MobileElement password;
	
	@AndroidFindBy(xpath ="(//android.widget.TextView[@text='Sign In'])[2]")
	public MobileElement Signin;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Services ']")
	public MobileElement Services;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Shivan']")
	public MobileElement Shivan;
	
	@AndroidFindBy(xpath ="//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView")
	public MobileElement menu;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Home']")
	public MobileElement Home;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Immunizations']")
	public MobileElement Immunizations;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Medication']")
	public MobileElement Medication;
	
	@AndroidFindBy(xpath ="(//android.widget.TextView[@text='Prenatal Care'])[2]")
	public MobileElement PrenatalCare;
	
	@AndroidFindBy(xpath ="(//android.widget.TextView[@text='Health Snapshot'])[2]")
	public MobileElement HealthSnapshot;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Logout']")
	public MobileElement logout;
	
	public void selectserive(String Service) throws InterruptedException {
		clickButton(menu, driver);
		Thread.sleep(1000);
		if (Service.equalsIgnoreCase("Immunization")) {
			clickButton(Immunizations, driver);
		} else if (Service.equalsIgnoreCase("Medication")) {
			clickButton(Medication, driver);
		} else if (Service.equalsIgnoreCase("HealthSnapshot")) {
			clickButton(HealthSnapshot, driver);
		} else if (Service.equalsIgnoreCase("PrenatalCare")) {
			clickButton(PrenatalCare, driver);
		} else if (Service.equalsIgnoreCase("Home")) {
			clickButton(Home, driver);
		} 
	}
	
	public void selectCountry(String country) throws InterruptedException {
		clickButton(Allow,driver);
		Thread.sleep(1000);
		clickButton(selectCountryoption, driver);
		Thread.sleep(1000);
		clickButton(countrydropdown, driver);
		if (country.equalsIgnoreCase("India")) {
			clickButton(India, driver);
		} else if (country.equalsIgnoreCase("United States")) {
			clickButton(UnitedStates, driver);
		} else if (country.equalsIgnoreCase("South Africa")) {
			clickButton(SouthAfrica, driver);
		} else if (country.equalsIgnoreCase("Middle East Countries")) {
			clickButton(MiddleEastCountries, driver);
		}
		//clickButton(Signin, driver);

	}
	
	
	  public void selectCou(String country) throws InterruptedException {
		  Select select= new Select(selectCountryoption);
		  Thread.sleep(5000);
		  select.selectByVisibleText(country);
		  Thread.sleep(5000);
	}

	public void selectLocationPermission() throws InterruptedException {
		 Thread.sleep(5000);
		clickButton(whileusingtheapp, driver);
		//clickButton(Allow, driver);

	}

	public void login(String Email, String Password) {
		waitForVisibilityOf(password, driver);
		//inputText(email, Email, driver);
		//inputText(Password, password, driver);
		//Emailid.clear();
		Emailid.sendKeys(Email);
		//password.clear();
		password.sendKeys(Password);
		clickButton(Signin, driver);
		
	}

	public void validateLogin() throws InterruptedException {
		// clickButton(Allow, driver);
		Thread.sleep(30000);
		//wait.until(ExpectedConditions.visibilityOf(service));
		waitForAvailabilityOf(Services, driver);
		String validatehomepage = Services.getText();
		Assert.assertEquals(validatehomepage, "Services ");
		//waitForVisibilityOf(Jhon, driver);
		waitForVisibilityOf(Shivan, driver);
		Thread.sleep(3000);
	
		wait.until(ExpectedConditions.visibilityOf(Services));
        Assert.assertEquals(Services.getText(), "Services ", "Home page validation failed");
	}
	
	@SuppressWarnings({ "unused" })
	private void clickButton(MobileElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
