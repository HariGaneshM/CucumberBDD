package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Actions;

public class AddRxPage extends Actions{
		
public AddRxPage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div[id='user-search'] input")
	WebElement searchField;
	
	@FindBy(className = "input-group-btn")
	WebElement searchButton;
	
	@FindBy(css = "button.btn__outlinegreen")
	WebElement newRxButton;
	
	@FindBy(css = "p.lead a")
	WebElement newPatientButton;
	
	@FindBy(name = "firstName")
	WebElement firstNameField;
	
	@FindBy(name = "lastName")
	WebElement lastNameField;
	
	@FindBy(name = "missingPhoneNumber")
	WebElement missingPhoneNumberCheckbox;
	
	@FindBy(id = "zipCode")
	WebElement zipCodeField;
	
	@FindBy(css = "button.btn.btn__primary[type='submit']")
	WebElement nextButton;
	
	@FindBy(className = "add-new-account-modal__confirmation-details")
	WebElement confirmationModal;
	
	@FindBy(id = "rx-source-select")
	WebElement rxSourceDropdown;
	
	@FindBy(id = "rx-phil-pharmacist-select")
	WebElement philPharmacistDropdown;
	
	@FindBy(id = "md-patient-select")
	WebElement rxTypesDropdown;
	
	@FindBy(id = "name-field")
	WebElement patientNameField;
	
	@FindBy(css = "input[value='Male']")
	WebElement genderCheckboxMale;
	
	@FindBy(css = "input[value='Female']")
	WebElement genderCheckboxFemale;
	
	@FindBy(name = "dateOfBirth")
	WebElement dateOfBirthField;
	
	@FindBy(css = "div.xdsoft_datetimepicker.fs-exclude")
	WebElement datePicker;
	
	@FindBy(id = "step-one-continue-btn")
	WebElement continueButton;
	
	@FindBy(css = "input[ng-model='rx.rxNumber']")
	WebElement rxNumberField;
	
	@FindBy(id = "medication-field")
	WebElement ndcField;
	
	@FindBy(className = "medicationDropdown__container")
	WebElement ndcSearchResult;
	
	@FindBy(css = "input[ng-model='rx.medicationQuantity']")
	WebElement quantityField;
	
	@FindBy(css = "input[ng-model='rx.daysOfSupply']")
	WebElement daysOfSupplyField;
	
	@FindBy(css = "input[ng-model='rx.refillCadence']")
	WebElement refillCadenceField;
	
	@FindBy(css = "textarea[ng-model='rx.sig']")
	WebElement sigField;
	
	@FindBy(css = "select[ng-model='rx.drugType']")
	WebElement drugTypeDropdown;
	
	@FindBy(css = "input[ng-model='doctor.npi']")
	WebElement doctorNpiField;
	
	@FindBy(id = "step-two-continue-btn")
	WebElement continueButton2;
	
	@FindBy(id = "address-street1-field")
	WebElement streetField;
	
	@FindBy(id = "address-city-field")
	WebElement cityField;
	
	@FindBy(id = "address-state-field")
	WebElement stateField;
	
	@FindBy(id = "address-zipcode-field")
	WebElement zipCodeField2;
	
	@FindBy(id = "step-three-continue-btn")
	WebElement continueButton3;
	
	@FindBy(id = "paper-unknown")
	WebElement insuranceTypeUnknownCheckbox;
	
	@FindBy(id = "step-four-continue-btn")
	WebElement continueButton4;
	
	@FindBy(id = "searchResult")
	WebElement searchResultsContainer;
	
	@FindBy(css = "ins[class='ng-binding']")
	List<WebElement> searchResults;
	
	public String createAddRxOrder(String patientEmail, String accountType, String patientName, String rxType, String medNDC, String doctorNPI) {
		
		new HomePage(driver).clickOnAddRx();
		enterData(searchField, patientEmail);
		clickOnElement(searchButton);
		
		if(accountType.equalsIgnoreCase("new")) {
			
			clickOnElement(newPatientButton);
			String[] splitName = patientName.split("");
			enterData(firstNameField, splitName[0]);
			enterData(lastNameField, splitName[1]);
			clickOnElement(missingPhoneNumberCheckbox);
			enterData(zipCodeField, "94114");
			clickOnElement(continueButton);
			waitForElementToBeVisible(confirmationModal);
			clickOnElement(nextButton);
		}
		else {
			
			clickOnElement(newRxButton);
		}
		
		selectFromDropdown(rxSourceDropdown, "md-office");
		selectFromDropdown(philPharmacistDropdown, "Haley Decoy");
		
		if(rxType.equalsIgnoreCase("patient")) {
			
			selectFromDropdown(rxTypesDropdown, 1);
			enterData(patientNameField, patientName + "2");
		}
		else {
			
			selectFromDropdown(rxTypesDropdown, 2);
		}
		selectCheckbox(genderCheckboxMale);
		clickOnElement(dateOfBirthField);
		waitForElementToBeVisible(datePicker);
		enterData(dateOfBirthField, "05261999");
		clickOnElement(continueButton);
		Random rand = new Random();
        int rxNumber = rand.nextInt(9000000) + 1000000;
		enterData(rxNumberField, Integer.toString(rxNumber));
		enterData(ndcField, medNDC);
		clickOnElement(ndcSearchResult);
		enterData(quantityField, "30");
		enterData(daysOfSupplyField, "30");
		enterData(refillCadenceField, "30");
		enterData(sigField, "Take 1 tablet every day night");
		selectFromDropdown(drugTypeDropdown, 1);
		enterData(doctorNpiField, doctorNPI);
		clickOnElement(continueButton2);
		enterData(streetField, "111 Castro St");
		enterData(cityField, "San Francisco");
		enterData(stateField, "CA");
		enterData(zipCodeField2, "94114");
		clickOnElement(continueButton3);
		selectCheckbox(insuranceTypeUnknownCheckbox);
		clickOnElement(continueButton4);
		waitForElementToBeVisible(searchResultsContainer);
		
		String orderNumber = null;
		for(int i=1; i<searchResults.size(); i++) {
			
			if(searchResults.get(i).getText().contains(patientName + "2")) {
				
				orderNumber = searchResults.get(i-1).getText();
			}
		}
		return orderNumber;
	}
}
