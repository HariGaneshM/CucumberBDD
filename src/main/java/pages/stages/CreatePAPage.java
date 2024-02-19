package pages.stages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;
import utilities.Actions;

public class CreatePAPage extends Actions{
		
	public CreatePAPage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".btn__primary.btn-small")
	WebElement startPAButton;
	
	@FindBy(name = "coverMyMedsKey")
	WebElement coverMyMedsField;
	
	@FindBy(css = ".modal-footer .btn__primary")
	WebElement saveButton;
	
	@FindBy(css = "button.btn__secondary")
	WebElement askForChartNoteButton;
	
	@FindBy(css = "button.btn__primary")
	WebElement notifyMdButton;
	
	@FindBy(css = "button[ng-click='previewPriorAuthNeedChartNotesFax()']")
	WebElement previewAuthFaxButton;
	
	@FindBy(css = "button[ng-click='sendPriorAuthNeedChartNotesFax()']")
	WebElement sendAuthFaxButton;
	
	@FindBy(name = "sendFaxForm")
	WebElement sendAuthFaxModal;
	
	@FindBy(className = "pa-fax-modal__dropdown-btn")
	WebElement insuranceDropdownButton;
	
	@FindBy(className = "pa-fax-modal__dropdown-item")
	WebElement insuranceOption;
	
	@FindBy(css = "button[ng-click='previewPAFax()']")
	WebElement previewFaxButton;
	
	@FindBy(css = "button[ng-click='submitPAAndSendFax()']")
	WebElement sendFaxButton;
	
	@FindBy(name = "pafaxform")
	WebElement sendFaxModal;
	
	public void startPA() {
		
		HomePage hm = new HomePage(driver);
		hm.getOrderDetails();
		clickOnElement(startPAButton);
		enterData(coverMyMedsField, "123456");
		clickOnElement(saveButton);
		hm.closeAlertPopup();
	}
	
	public void askForCN() {
		
		HomePage hm = new HomePage(driver);
		hm.getOrderDetails();
		clickOnElement(askForChartNoteButton);
		clickOnElement(previewAuthFaxButton);
		clickOnElement(sendAuthFaxButton);
		waitForElementToBeInVisible(sendAuthFaxModal);
		hm.closeAlertPopup();
	}
	
	public void notifyMD() {
		
		HomePage hm = new HomePage(driver);
		hm.getOrderDetails();
		clickOnElement(notifyMdButton);
		clickOnElement(insuranceDropdownButton);
		clickOnElement(insuranceOption);
		clickOnElement(previewFaxButton);
		clickOnElement(sendFaxButton);
		waitForElementToBeInVisible(sendFaxModal);		
		hm.closeAlertPopup();
	}
}
