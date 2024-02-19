package stepDefinitions;

import org.junit.Assert;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddRxPage;
import pages.HomePage;
import pages.LoginPage;
import pages.myPhil.AccountPage;
import pages.myPhil.MyPhilLoginPage;
import pages.stages.CreatePAPage;
import pages.stages.PhilRxTransferPage;
import pages.stages.RunInsurancePage;
import pages.stages.ScrubAndRoutePage;
import philAPIs.mockOrder;
import utilities.Configs;
import utilities.Utils;

public class ReleaseTests extends BaseTest{
	
	@Given("User logged in to {string}")
	public void user_logged_in_to(String dashboard) {
	    
		LoginPage login = new LoginPage(driver);
		MyPhilLoginPage myPhil = new MyPhilLoginPage(driver);
		
		if (dashboard.equalsIgnoreCase("OPSdash")) {
			
			login.logIn(Configs.getProperty("ops.email"), Configs.getProperty("ops.password"));
			
		}
		else if (dashboard.equalsIgnoreCase("PPdash")) {
			
			goToPage(Configs.getProperty("ops.url").replace("env", env)+"/logout");
			login.logIn(Configs.getProperty("pp.emailCDS"), Configs.getProperty("pp.passwordCDS"));
			
		}
		else if (dashboard.equalsIgnoreCase("MyPhil")) {
			
			goToPage(Configs.getProperty("myPhil.url").replace("env", env));
			myPhil.logIn(mockOrder.patientEmail, Configs.getProperty("myPhil.password"));
		}
		
	}
	
	@And("Mock order created for Program:{string} at Stage:{string} with paymentType:{string} from MD:{string}")
	public void mock_order_created_for_program_at_stage_with_payment_type_from_md(String program, String stage, String paymentType, String docterNPI) {
	    
		String npi = Configs.getProperty("npi");
		
		if (docterNPI.equalsIgnoreCase("pref_npi")) {
			
			npi = Configs.getProperty("npiPref");
		}
		mockOrder.createOrder(Configs.getProperty("medName"), Configs.getProperty("stage"), Configs.getProperty("insType1"), npi);
		HomePage opsDash = new HomePage(driver);
		opsDash.searchOrder(mockOrder.rxNumber);
	}
	
	@And("MD preference is Let Phil Send me substitutes to choose from")
	public void md_preference_is_let_phil_send_me_substitutes_to_choose_from() {
	    
		
		ScrubAndRoutePage sr = new ScrubAndRoutePage(driver);
		Assert.assertEquals(sr.getPAPreference(), Configs.getProperty("exp.PAPref"));
	}
	
	@And("AddRx order created with {string} for {string} order")
	public void add_rx_order_created_with_for_order(String string, String string2) {
	    
		AddRxPage addRx = new AddRxPage(driver);
		String orderNumber = addRx.createAddRxOrder(mockOrder.patientEmail, string2, 
		mockOrder.patientName, string, Configs.getProperty("medNDC"), Configs.getProperty("npiPref"));
		System.out.println(orderNumber);
	}
	
	@When("Order routed to PP")
	public void order_routed_to_pp() {
	    
		ScrubAndRoutePage sr = new ScrubAndRoutePage(driver);
		sr.routeToPharmacy();
		PhilRxTransferPage pt = new PhilRxTransferPage(driver);
		pt.sendToPP();
	}
	
	@When("Initiated PA and moved to Ask for CN via fax")
	public void initiated_pa_and_moved_to_ask_for_cn_via_fax() {
	    
		ScrubAndRoutePage sr = new ScrubAndRoutePage(driver);
		CreatePAPage pa = new CreatePAPage(driver);
		sr.moveToPAqueue();
		pa.startPA();
		pa.askForCN();
	}
	
	@And("Initiated PA from Cannot Fill")
	public void initiated_pa_from_cannot_fill() throws Exception {
	    
		RunInsurancePage ri = new RunInsurancePage(driver);
		ri.cannotFillToPA();
	}
	
	@And("Insurance uploaded to manager and patient")
	public void insurance_uploaded_to_manager_and_patient() throws Exception {
	    
		AccountPage myAc = new AccountPage(driver);
		myAc.uploadInsuranceImg ("manager", "ins.jpg");
		success_toast_should_display_after_new_insurance_uploaded();
		myAc.uploadInsuranceImg ("patient", "blank.jpg");
		
	}
	
	@Then("Order should move to {string}")
	public void order_should_move_to(String stageLabel) throws Exception {
	    
		HomePage opsDash = new HomePage(driver);
		
		if (stageLabel.equalsIgnoreCase("expectedLabelForRTC1")) {
			
			Assert.assertEquals(opsDash.getPPStageLabel(), Configs.getProperty("exp.label1"));
			Utils.getScreenshot("RTC1");
		}
		else if (stageLabel.equalsIgnoreCase("expectedLabelForRTC3")) {
			
			Assert.assertEquals(opsDash.getPPStageLabel(), Configs.getProperty("exp.label2"));
			Utils.getScreenshot("RTC3");
		}
	}
	
	
	@Then("Success toast should display after new Insurance uploaded")
	public void success_toast_should_display_after_new_insurance_uploaded() throws Exception {
	    
		AccountPage myAc = new AccountPage(driver);
		myAc.checkForToastDisplayed();
		Utils.getScreenshot("RTC2");
	}
}
