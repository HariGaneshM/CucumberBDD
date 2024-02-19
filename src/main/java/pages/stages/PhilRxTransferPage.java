package pages.stages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;
import utilities.Actions;

public class PhilRxTransferPage extends Actions{
		
	public PhilRxTransferPage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "button[ng-click='skipPhilRxTransfer(tab.prescription)']")
	WebElement skipTransferButton;
	
	@FindBy(css = "button[ng-click='skipWithUpdateRxScriptTransferFax()']")
	WebElement skipAndUpdateButton;
	
	@FindBy(name = "skipRxScriptTransferFaxForm")
	WebElement skipTransferModal;
	
	@FindBy(css = "button[ng-click='openSendRxScriptTransferFaxModal(tab.prescription)']")
	WebElement sendToPPButton;
	
	@FindBy(css = "button[ng-click='previewRxScriptTransferFax(sendRxScriptTransferFaxForm)']")
	WebElement previewFaxButton;
	
	@FindBy(css = "button[ng-click='sendRxScriptFax(sendRxScriptTransferFaxForm)']")
	WebElement sendFaxButton;
	
	@FindBy(name = "sendRxScriptTransferFaxForm")
	WebElement transferModal;
	
	@FindBy(css = "button[ng-click='initiateMoveToRoute(tab.prescription)']")
	WebElement moveToRouteButton;
	
	@FindBy(id = "comment")
	WebElement commentBox;
	
	@FindBy(css = ".btn__primary.ng-binding")
	WebElement confirmButton;
	
	public void skipTransfer() {
		
		HomePage hm = new HomePage(driver);
		hm.getOrderDetails();
		clickOnElement(skipTransferButton);
		clickOnElement(skipAndUpdateButton);
		waitForElementToBeInVisible(skipTransferModal);
		hm.closeAlertPopup();
	}
	
	public void sendToPP() {
		
		HomePage hm = new HomePage(driver);
		hm.getOrderDetails();
		clickOnElement(sendToPPButton);
		clickOnElement(previewFaxButton);
		clickOnElement(sendFaxButton);
		waitForElementToBeInVisible(transferModal);
		hm.closeAlertPopup();
	}
	
	public void moveToRoute() {
		
		HomePage hm = new HomePage(driver);
		hm.getOrderDetails();
		clickOnElement(moveToRouteButton);
		enterData(commentBox, "Test");
		clickOnElement(confirmButton);
		hm.closeAlertPopup();
	}
}
