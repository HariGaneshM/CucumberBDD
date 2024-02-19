package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Actions;

public class AdminPage extends Actions {
		
	public AdminPage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Mock Order Generation")
	WebElement mockOrderButton;
	
	@FindBy(css = "select[ng-model='mockData.programType']")
	WebElement programDropdown;
	
	@FindBy(id = "mockOrderStage")
	WebElement stageDropdown;
	
	@FindBy(name = "mockNpi")
	WebElement doctorNpiField;
	
	@FindBy(id = "mockPaymentType")
	WebElement paymentTypeDropdown;
	
	@FindBy(className = "mock-cta")
	WebElement saveButton;
	
	@FindBy(className = "confirm")
	WebElement popupCloseButton;
	
	@FindBy(css = "tr[ng-repeat='datum in mockDataResult'] td:nth-child(1)")
	WebElement orderNumberElement;
	
	public String createMockOrder(String programName, String stage, String paymentType, String doctorNPI) {
		
		new HomePage(driver).clickOnAdmin();
		clickOnElement(mockOrderButton);
		selectFromDropdown(programDropdown, programName);
		selectFromDropdown(stageDropdown, stage);
		enterData(doctorNpiField, doctorNPI);
		selectFromDropdown(paymentTypeDropdown, paymentType);
		clickOnElement(saveButton);
		clickOnElement(popupCloseButton);
		String orderNumber = getText(orderNumberElement);
		
		return orderNumber;
	}
}
