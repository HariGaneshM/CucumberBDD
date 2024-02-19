package pages.myPhil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Actions;

public class MyPhilLoginPage extends Actions {
		
	public MyPhilLoginPage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "email")
	WebElement emailField;
		
	@FindBy(name = "password")
	WebElement passwordField;
	
	@FindBy(className = "LoginSection__btn")
	WebElement loginButton;
	
	@FindBy(className = "Header-logo")
	WebElement philLogo;
	
	@FindBy(className = "OnboardingSlider__cross-icon")
	WebElement popupCloseButton;
	
	public void logIn(String email, String password) {
		
		enterData(emailField, email);
		enterData(passwordField, password);
		clickOnElement(loginButton);
		waitForElementToBeVisible(philLogo);
		clickOnElement(popupCloseButton);
	}	
}
