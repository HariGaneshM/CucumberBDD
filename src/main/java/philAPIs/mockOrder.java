package philAPIs;

import static io.restassured.RestAssured.given;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import mockAPIpojo.AdvancePrescription;
import mockAPIpojo.Appeal;
import mockAPIpojo.BaseData;
import mockAPIpojo.DrugDetails;
import mockAPIpojo.MockAPI;
import mockAPIpojo.PatientDetails;
import utilities.Configs;

public class mockOrder extends BaseTest {
	
	public static Response response;
	public static String rxNumber;
	public static String patientName;
	public static String patientEmail;
	
	public static void createOrder(String program, String stage, String paymentType, String docterNPI) {
			
		MockAPI payload = new MockAPI();
		BaseData baseData = new BaseData();
		baseData.setProgramType(program);
		baseData.setStage(stage);
		baseData.setPaymentType(paymentType);
		baseData.setNpi(docterNPI);
		DrugDetails drugDetails = new DrugDetails();
		PatientDetails pd = new PatientDetails();
		baseData.setDrugDetails(drugDetails);
		baseData.setPatientDetails(pd);
		AdvancePrescription adv = new AdvancePrescription();
		adv.setStage(stage);
		Appeal app = new Appeal();
		adv.setAppeal(app);
		
		payload.setBaseData(baseData);
		payload.setAdvancePrescription(adv);
		
		RestAssured.baseURI = Configs.getProperty("mockOrder.baseURI").replace("env", env);
		
		response = given()
		   .contentType(ContentType.JSON)
		   .headers("Authorization", Configs.getProperty("philKey"))
		   .body(payload)
		   .when()
		   .post(Configs.getProperty("mockOrder.endPoint"));
		
		rxNumber = response
				       .then()
				       .contentType(ContentType.JSON)
				       .extract()
				       .path("data.prescriptions[0].number");
		
		patientName = response
				       .then()
				       .contentType(ContentType.JSON)
				       .extract()
				       .path("data.prescriptions[0].manager.fullName");
		
		patientEmail = response
				       .then()
				       .contentType(ContentType.JSON)
				       .extract()
				       .path("data.prescriptions[0].manager.email");
	}
}
