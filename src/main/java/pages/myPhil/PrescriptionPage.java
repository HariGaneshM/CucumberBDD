package pages.myPhil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Actions;

public class PrescriptionPage extends Actions {
		
	public PrescriptionPage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "a[href='/account']")
	WebElement accountPageButton;
	
	@FindBy(className = "account-info__profile-img")
	WebElement profileIcon;
	
	public void goToAccountPage() {
		
		clickOnElement(accountPageButton);
		waitForElementToBeVisible(profileIcon);
	}
}
