package com.peopleinteractive.pages;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import com.peopleinteractive.base.BasePage;
import com.peopleinteractive.configs.Hooks;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITBy;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsernamePage extends BasePage {

	@SuppressWarnings("rawtypes")
	public AppiumDriver driver;

	/*
	 * Constructor initializes screen elements
	 */
	@SuppressWarnings("static-access")
	public UsernamePage()

	{
		this.driver = new Hooks().getDriver();
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}

	@iOSXCUITFindBy(accessibility = "textfieldemailMobileField")
	@AndroidFindBy(id = "com.shaadi.android:id/edt_username")
	private MobileElement usernameTextField;


	
	
	/**
	 * Method to enter username
	 * @param usernameText
	 */

	public void enterUsername(String usernameText) {
		//waitForVisibilityOf(usernameTextField, driver);
		inputText(usernameText, usernameTextField, driver);
		//inputText_enablekeyboard(usernameText, usernameTextField, driver);
		
	}
	
	public boolean checkForUsernamePage() {
		try {
			usernameTextField.isDisplayed();
			return true;

		} catch (NoSuchElementException | TimeoutException e) {
			return false;
		}
	}
	/**
	 * Method to wait for username page
	 */

	public void waitForUsernamePage() {
		waitForVisibilityOf(usernameTextField, driver);
	}
	/**
	 * Method for login 
	 * 
	 */

	


}
