package mockAPIpojo;

public class DrugDetails {
	
	private String medicationQuantity = "30";
	private String packageSize = "30";
	private String daysOfSupply = "30";
	
	public String getMedicationQuantity() {
		return medicationQuantity;
	}
	public void setMedicationQuantity(String medicationQuantity) {
		this.medicationQuantity = medicationQuantity;
	}
	public String getPackageSize() {
		return packageSize;
	}
	public void setPackageSize(String packageSize) {
		this.packageSize = packageSize;
	}
	public String getDaysOfSupply() {
		return daysOfSupply;
	}
	public void setDaysOfSupply(String daysOfSupply) {
		this.daysOfSupply = daysOfSupply;
	}
}
