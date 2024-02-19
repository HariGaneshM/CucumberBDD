package mockAPIpojo;

public class BaseData {
	
	private int numRxs = 1;
	private int numPatients = 1;
	private String programType = "OysterPoint";
	private String stage = "ScrubAndRoute";
	private String paymentType = "GovernmentInsurance";
	private String npi = "1396845798";
	private String insuranceType = "";
	private String strength = "";
	private String patientId = "";
	private String priorAuth = "";
	private DrugDetails drugDetails;
	private PatientDetails patientDetails;
	
	public int getNumRxs() {
		return numRxs;
	}
	public void setNumRxs(int numRxs) {
		this.numRxs = numRxs;
	}
	public int getNumPatients() {
		return numPatients;
	}
	public void setNumPatients(int numPatients) {
		this.numPatients = numPatients;
	}
	public String getProgramType() {
		return programType;
	}
	public void setProgramType(String programType) {
		this.programType = programType;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getNpi() {
		return npi;
	}
	public void setNpi(String npi) {
		this.npi = npi;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPriorAuth() {
		return priorAuth;
	}
	public void setPriorAuth(String priorAuth) {
		this.priorAuth = priorAuth;
	}
	public DrugDetails getDrugDetails() {
		return drugDetails;
	}
	public void setDrugDetails(DrugDetails drugDetails) {
		this.drugDetails = drugDetails;
	}
	public PatientDetails getPatientDetails() {
		return patientDetails;
	}
	public void setPatientDetails(PatientDetails patientDetails) {
		this.patientDetails = patientDetails;
	}
}
