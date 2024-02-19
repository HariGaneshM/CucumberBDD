package utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions {
	
	public WebDriver driver;
	public WebDriverWait w;
	
	public Actions(WebDriver driver) {
		
		this.driver = driver;
		w = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	public void refreshPage() {
		
		driver.navigate().refresh();
	}
	
	public void navigateBack() {
		
		driver.navigate().back();
	}
	
	public void navigateForward() {
		
		driver.navigate().forward();
	}
	
	public void waitForElementToBeVisible(WebElement element) {
		
		w.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeInVisible(WebElement element) {
		
		w.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitForElementToBeClickable(WebElement element) {
		
		waitForElementToBeVisible(element);
		w.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void clickOnElement(WebElement element) {
		
		waitForElementToBeClickable(element);
		element.click();
	}
	
	public void selectCheckbox(WebElement element) {
		
		element.click();
	}
	
	public void enterData(WebElement element, String data) {
		
		waitForElementToBeVisible(element);
		element.sendKeys(data);
	}
	
	public String getText(WebElement element) {
		
		waitForElementToBeVisible(element);
		String text = element.getText();
		
		return text;
	}
	
	public void selectFromDropdown(WebElement element, String value) {
		
		waitForElementToBeVisible(element);
		Select Program = new Select(element);
		Program.selectByValue(value);
	}
	
	public void selectFromDropdown(WebElement element, int value) {
		
		waitForElementToBeVisible(element);
		Select Program = new Select(element);
		Program.selectByIndex(value);
	}
	
	public void switchToWindow(String window) {
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		String parentId = it.next();
		String childId = it.next();
		if (window.contains("parent"))
			driver.switchTo().window(parentId);
		else driver.switchTo().window(childId);
	}
}
