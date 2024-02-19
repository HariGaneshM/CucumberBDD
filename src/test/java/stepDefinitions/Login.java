package stepDefinitions;

import org.junit.Assert;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utilities.Configs;
import utilities.Utils;

public class Login extends BaseTest{
	
	@Given("User lands on OPSdash Login page")
	public void user_lands_on_opsdash_login_page() {
		
		initializeDriver();
		goToPage(Configs.getProperty("ops.url").replace("env", env));
	}
	
	@When("User logged in with {string} credentials")
	public void user_logged_in_with_credentials(String string) {
		
		LoginPage login = new LoginPage(driver);
		
	    if(string.equalsIgnoreCase("valid")) {
	    	
	    	login.logIn(Configs.getProperty("ops.email"), Configs.getProperty("ops.password"));
	    }
	    else {
	    	
	    	login.logIn(Configs.getProperty("ops.email"), "InvalidPassword@123");
	    }
	}
	
	@Then("User should land on home page")
	public void user_should_land_on_home_page() throws Exception {
		
		HomePage opsDash = new HomePage(driver);
		Assert.assertEquals(opsDash.getPageTitle(), Configs.getProperty("exp.PageTitle"));
		Utils.getScreenshot("HomePage");
	}
	
	@Then("Error message should display")
	public void error_message_should_display() throws Exception {
		
		LoginPage login = new LoginPage(driver);
		Assert.assertEquals(login.getErrorLoginMessage(), "Invalid email or password");
		Utils.getScreenshot("LoginError");
	}
	
	@Then("Close Browser tabs")
	public void close_Browser_tabs() {
		
		driver.quit();
	}
}
