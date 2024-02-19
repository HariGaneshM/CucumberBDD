package pages.stages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;
import utilities.Actions;

public class ScrubAndRoutePage extends Actions{
		
	public ScrubAndRoutePage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//div[@class='order-component mt-3']//span[@class='fs-exclude ng-binding'])[1]")
	WebElement patientName;
	
	@FindBy(xpath = "(//div[@class='order-component mt-3']//span[@class='fs-exclude ng-binding'])[3]")
	WebElement patientEmail;
	
	@FindBy(linkText = "View practice preferences")
	WebElement viewPracticePreferencesButton;
	
	@FindBy(css = "div[ng-show='boxSection.priorAuthExpanded'] div div p")
	WebElement practicePreferenceText;
	
	@FindBy(className ="modal-header__close")
	WebElement closePreferenceModal; 
	
	@FindBy(className = "btn__info")
	WebElement openRouteModelButton;
	
	@FindBy(className = "customDropdown__box")
	WebElement pharmacyDropdown;
	
	@FindBy(css = "div.medicationDropdown__header")
	List<WebElement> patnerPharmacies;
	
	@FindBy(css = "div.modal-footer button.btn__primary")
	WebElement confirmRoutingButton;	
	
	@FindBy(css = "button.btn.btn__secondary.ng-scope")
	WebElement moveToPAqueueButton;
	
	@FindBy(name = "internalOnlyComment")
	WebElement commentBox;
	
	@FindBy(css = "[class='modal-footer'] button.btn__primary")
	WebElement commentSaveButton;
	
	public String getPatientName() {
		
		return getText(patientName);
	}
	
	public String getPatientEmail() {
		
		return getText(patientEmail);
	}
	
	public String getPAPreference() {
		
		new HomePage(driver).getOrderDetails();
		clickOnElement(viewPracticePreferencesButton);
		String paPreference = getText(practicePreferenceText);
		clickOnElement(closePreferenceModal);
		
		return paPreference;
	}
	
	public void routeToPharmacy() {
		
		HomePage hm = new HomePage(driver);
		hm.getOrderDetails();
		clickOnElement(openRouteModelButton);
		clickOnElement(pharmacyDropdown);
		for (int i=0; i<patnerPharmacies.size(); i++) {
			if(patnerPharmacies.get(i).getText().contains("Central Drug Store")) {
				clickOnElement(patnerPharmacies.get(i));
				break;
			}
		}
		clickOnElement(confirmRoutingButton);
		hm.closeAlertPopup();
	}
	
	public void moveToPAqueue() {
		
		HomePage hm = new HomePage(driver);
		hm.getOrderDetails();
		clickOnElement(moveToPAqueueButton);
		enterData(commentBox, "Test");
		clickOnElement(commentSaveButton);
		hm.closeAlertPopup();
	}
}
