package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import philAPIs.mockOrder;
import utilities.Actions;

public class HomePage extends Actions{
		
	public HomePage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "name-header-label")
	WebElement pageTitle;
	
	@FindBy(className = "quick-navbar-item")
	List<WebElement> createOrderButtons;
	
	@FindBy(className = "search-filter__form-control")
	WebElement searchField;
	
	@FindBy(className = "search-filter__btn")
	public WebElement searchButton;
	
	@FindBy(id = "searchResult")
	WebElement searchResultsContainer;
	
	@FindBy(css = "ins[class='ng-binding']")
	WebElement searchResults;
	
	@FindBy(className = "rx-status-label--small")
	WebElement stageLabel;
	
	@FindBy(className = "loading-icon")
	WebElement loadingIcon;
	
	@FindBy(css = "td.search-table__col--lg")
	WebElement orderDetailsButton;
	
	@FindBy(className = "sweet-alert")
	WebElement alertModal;
	
	@FindBy(className = "confirm")
	WebElement alertCloseButton;
	
	@FindBy(className = "visible")
	List<WebElement> alertModals;
	
	
	public String getPageTitle() {
		
		String title = getText(pageTitle);
		
		return title;
	}
	
	public void clickOnAdmin() {
		
		clickOnElement(createOrderButtons.get(0));
		if (!(getPageTitle().contains("Phil Dashboard"))) {
			navigateBack();
			clickOnAdmin();
		}
	}
	
	public void clickOnAddRx() {
		
		clickOnElement(createOrderButtons.get(1));
		if (!(getPageTitle().contains("Phil Dashboard"))) {
			navigateBack();
			clickOnAddRx();
		}
	}
	
	public void searchOrder(String searchText) {
		
		enterData(searchField, searchText);
		clickOnElement(searchButton);
		waitForElementToBeInVisible(loadingIcon);
		waitForElementToBeVisible(searchResultsContainer);
		System.out.println(getText(searchResults));
	}
	
	public void getOrderDetails() {
		
		clickOnElement(searchButton);
		waitForElementToBeInVisible(loadingIcon);
		waitForElementToBeVisible(searchResultsContainer);
		clickOnElement(orderDetailsButton);
	}
	
	public void getOrderDetailsWithoutWaiting() {
		
		searchField.sendKeys(mockOrder.rxNumber);
		searchButton.click();
		waitForElementToBeInVisible(loadingIcon);
		waitForElementToBeVisible(searchResultsContainer);
		clickOnElement(orderDetailsButton);
	}
	
	public void closeAlertPopup() {
		
		waitForElementToBeVisible(alertModal);
		clickOnElement(alertCloseButton);
	}
	
	public String getStageLabel() {
		
		clickOnElement(searchButton);
		waitForElementToBeVisible(searchResultsContainer);
		waitForElementToBeInVisible(loadingIcon);
		String label = getText(stageLabel);
		
		return label;
	}
	
	public String getPPStageLabel() throws Exception {
		
		Thread.sleep(2000);
		searchButton.click();
		waitForElementToBeInVisible(loadingIcon);
		String label = stageLabel.getText();
		
		return label;
	}
}
