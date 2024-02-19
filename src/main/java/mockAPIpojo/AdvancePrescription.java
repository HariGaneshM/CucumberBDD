package mockAPIpojo;

public class AdvancePrescription {
	
	private String rxIds;
	private String userID = "";
	private String stage = "ScrubAndRoute";
    private String pharmacyNpi = "";
    private String finalCopay = "";
    private String insuranceCoverage = "";
    private String couponCoverage = "";
    private String appealType = "";
    private String couponEnrollment = "Enrolled";
    private String hipaaEnrollment = "Signed";
    private String govtWaiverEnrollment = "Accepted";
    private int delay = 0;
    private String delayType = "";
    private String priorAuthProcessingState = "";
    private Appeal appeal;
    private boolean isRunClaim = true;
    private String occ = "";
    private int refillCount = 0;
    private boolean refillPreference = true;
    private String reverseClaim = "";
    private String bestRxClaim = "";
    private String vpsClaimType = "";
    private String claimPrice = "";
    
	public String getRxIds() {
		return rxIds;
	}
	public void setRxIds(String rxIds) {
		this.rxIds = rxIds;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getPharmacyNpi() {
		return pharmacyNpi;
	}
	public void setPharmacyNpi(String pharmacyNpi) {
		this.pharmacyNpi = pharmacyNpi;
	}
	public String getFinalCopay() {
		return finalCopay;
	}
	public void setFinalCopay(String finalCopay) {
		this.finalCopay = finalCopay;
	}
	public String getInsuranceCoverage() {
		return insuranceCoverage;
	}
	public void setInsuranceCoverage(String insuranceCoverage) {
		this.insuranceCoverage = insuranceCoverage;
	}
	public String getCouponCoverage() {
		return couponCoverage;
	}
	public void setCouponCoverage(String couponCoverage) {
		this.couponCoverage = couponCoverage;
	}
	public String getAppealType() {
		return appealType;
	}
	public void setAppealType(String appealType) {
		this.appealType = appealType;
	}
	public String getCouponEnrollment() {
		return couponEnrollment;
	}
	public void setCouponEnrollment(String couponEnrollment) {
		this.couponEnrollment = couponEnrollment;
	}
	public String getHipaaEnrollment() {
		return hipaaEnrollment;
	}
	public void setHipaaEnrollment(String hipaaEnrollment) {
		this.hipaaEnrollment = hipaaEnrollment;
	}
	public String getGovtWaiverEnrollment() {
		return govtWaiverEnrollment;
	}
	public void setGovtWaiverEnrollment(String govtWaiverEnrollment) {
		this.govtWaiverEnrollment = govtWaiverEnrollment;
	}
	public int getDelay() {
		return delay;
	}
	public void setDelay(int delay) {
		this.delay = delay;
	}
	public String getDelayType() {
		return delayType;
	}
	public void setDelayType(String delayType) {
		this.delayType = delayType;
	}
	public String getPriorAuthProcessingState() {
		return priorAuthProcessingState;
	}
	public void setPriorAuthProcessingState(String priorAuthProcessingState) {
		this.priorAuthProcessingState = priorAuthProcessingState;
	}
	public Appeal getAppeal() {
		return appeal;
	}
	public void setAppeal(Appeal appeal) {
		this.appeal = appeal;
	}
	public boolean getIsRunClaim() {
		return isRunClaim;
	}
	public void setIsRunClaim(boolean isRunClaim) {
		this.isRunClaim = isRunClaim;
	}
	public String getOcc() {
		return occ;
	}
	public void setOcc(String occ) {
		this.occ = occ;
	}
	public int getRefillCount() {
		return refillCount;
	}
	public void setRefillCount(int refillCount) {
		this.refillCount = refillCount;
	}
	public boolean getRefillPreference() {
		return refillPreference;
	}
	public void setRefillPreference(boolean refillPreference) {
		this.refillPreference = refillPreference;
	}
	public String getReverseClaim() {
		return reverseClaim;
	}
	public void setReverseClaim(String reverseClaim) {
		this.reverseClaim = reverseClaim;
	}
	public String getBestRxClaim() {
		return bestRxClaim;
	}
	public void setBestRxClaim(String bestRxClaim) {
		this.bestRxClaim = bestRxClaim;
	}
	public String getVpsClaimType() {
		return vpsClaimType;
	}
	public void setVpsClaimType(String vpsClaimType) {
		this.vpsClaimType = vpsClaimType;
	}
	public String getClaimPrice() {
		return claimPrice;
	}
	public void setClaimPrice(String claimPrice) {
		this.claimPrice = claimPrice;
	}
}
