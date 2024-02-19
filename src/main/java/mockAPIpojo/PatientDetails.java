package mockAPIpojo;

public class PatientDetails {
	
	private String dateOfBirth = "";
	private String patientZipCode = "";
	private String patientStAddress = "";
	private String patientCity = "";
	private String patientState = "";
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPatientZipCode() {
		return patientZipCode;
	}
	public void setPatientZipCode(String patientZipCode) {
		this.patientZipCode = patientZipCode;
	}
	public String getPatientStAddress() {
		return patientStAddress;
	}
	public void setPatientStAddress(String patientStAddress) {
		this.patientStAddress = patientStAddress;
	}
	public String getPatientCity() {
		return patientCity;
	}
	public void setPatientCity(String patientCity) {
		this.patientCity = patientCity;
	}
	public String getPatientState() {
		return patientState;
	}
	public void setPatientState(String patientState) {
		this.patientState = patientState;
	}
}
