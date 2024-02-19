package pages.stages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;
import utilities.Actions;

public class RunInsurancePage extends Actions{
		
	public RunInsurancePage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "btn__info")
	WebElement canFillNowButton;
	
	@FindBy(className = "btn__outlinered")
	WebElement cannotFillButton;
	
	@FindBy(className = "custom-dropdown-control__display-text")
	List<WebElement> cannotFillDropdownButtons;
	
	@FindBy(className = "custom-dropdown-control__dropdown-select-label-text")
	List<WebElement> cannotFillReasons;
	
	@FindBy(id = "comment")
	WebElement commentBox;
	
	@FindBy(css = ".modal-footer button.btn__primary")
	WebElement saveButton;
	
	@FindBy(name = "insuranceExceptionForm")
	WebElement cannotFillModal;
	
	public void cannotFillToPA() throws Exception {
		
		HomePage hm = new HomePage(driver);
//		hm.getOrderDetails();
		hm.getOrderDetailsWithoutWaiting();
		clickOnElement(cannotFillButton);
//		clickOnElement(cannotFillDropdownButtons.get(0));
		Thread.sleep(2000);
		cannotFillDropdownButtons.get(0).click();
//		clickOnElement(cannotFillReasons.get(2));
		Thread.sleep(1000);
		cannotFillReasons.get(1).click();
//		clickOnElement(cannotFillDropdownButtons.get(1));
		cannotFillDropdownButtons.get(1).click();
//		clickOnElement(cannotFillReasons.get(9));
		Thread.sleep(1000);
		cannotFillReasons.get(9).click();
//		enterData(commentBox, "Test");
		commentBox.sendKeys("Test");
//		clickOnElement(saveButton);
		saveButton.click();
		waitForElementToBeInVisible(cannotFillModal);
		hm.closeAlertPopup();
	}
}
