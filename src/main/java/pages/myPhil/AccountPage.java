package pages.myPhil;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import utilities.Actions;
import utilities.Configs;

public class AccountPage extends Actions {
		
	public AccountPage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "account-mng")
	WebElement managerButton;
	
	@FindBy(className = "account-list")
	WebElement patientButton;
		
	@FindBy(css = ".InsuranceList__link a")
	WebElement addInsuranceButton;
	
	@FindBy(css = "input.fs-exclude")
	WebElement uploadInsurance;
	
	@FindBy(className = "cta-button")
	WebElement saveButton;
	
	@FindBy(className = "RadioOption__label-text")
	List<WebElement> insuranceTypeRadioButton;
	
	@FindBy(className = "ToastContainer")
	WebElement toastContainer;
	
	
	public void uploadInsuranceImg(String accountType, String file) {
		
		driver.navigate().to(Configs.getProperty("myPhil.url").replace("env", BaseTest.env)+"/account");
		String insURL;
		if (accountType.equalsIgnoreCase("manager")) {
			
			clickOnElement(managerButton);
			insURL = driver.getCurrentUrl().split("detail")[0]+"insurances";
		}	
		else {
			
			clickOnElement(patientButton);
			insURL = driver.getCurrentUrl().split("detail")[0]+"insurances";
		}
		driver.navigate().to(insURL);
		clickOnElement(addInsuranceButton);
		uploadInsurance.sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\"+file);
		clickOnElement(insuranceTypeRadioButton.get(0));
		clickOnElement(saveButton);
	}


	public void checkForToastDisplayed() {
		
		waitForElementToBeVisible(toastContainer);
		toastContainer.isDisplayed();
	}
}
