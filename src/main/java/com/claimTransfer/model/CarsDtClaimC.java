package com.claimTransfer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CARS_DT_CLAIM_C")
public class CarsDtClaimC {

	@Id
	@Column(name = "DT_ID")
	private String dtId;

	@Column(name = "NOTIFICATION")
	private String notification;

	@Column(name = "CLAIM_NUM")
	private String claimNum;

	@Column(name = "POLICY_SERIE")
	private String policySerie;

	@Column(name = "POLICY_Id")
	private String policyId;

	@Column(name = "VEHICLE_SERIE ")
	private String vehicleSerie;

	@Column(name = "ACCIDENT_DATE")
	private String accidentDate;

	@Column(name = "REPORTED_DATE")
	private String reportedDate;

	@Column(name = "ACCIDENT_TIME")
	private String accidentTime;

	@Column(name = "REPORTED_TIME")
	private String reportedTime;

	@Column(name = "STATUS_CODE")
	private String statusCode;
	
	@Column(name = "STATUS_DESCRIPTION")
	private String statusDescription;

	@Column(name = " STATUS_DATE")
	private String statusDate;

	@Column(name ="ACCIDENT_LONGITUDE")
	private String accidentLongitude;
	
	@Column (name = "ACCIDENT_LATITUDE")
	private String accidentLatitude;
	
	@Column (name = "ACCIDENT_LOCATION")
	private String accidentLocation;
	
	@Column(name ="CLAIM_REASON")
	private String claimReason;
	
	@Column(name = "SCRIPT_NAME")
	private String scriptName;

	@Column(name = "RELATED_NOTIFICATION")
	private String relatedNotification;	
	
	@Column(name = "RESERVE_AMOUNT_USD")
	private String reserveAmountUsd;
	
	@Column(name = "TOTAL_PAID_USD")
	private String totalPaidUsd;
	
	@Column(name = "EXPERT_NAME")
	private String expertName;
	
	@Column(name = "EXPERT_CODE")
	private String expertCode;
	
	@Column(name = "RESERVE_DIFFERNCE")
	private String reserveDifference;

	@Column(name = "ACCIDENT_LOCATION_DISTRICT")
	private String accidentLocationDistrict;


	@Column(name = "ACCIDENT_LOCATION_CAZA ")
	private String accidentLocationCAZA;





	@Column(name = "DEFAULT_COVER_CODE")
	private String defaultCoverCode;


	@Column(name = "DEFAULT_RISK_TYPE")
	private String defaultRiskType;

	@Column(name = "CURRENCY")
	private String Currency;
	@Column(name = "POLICY_CERTIF_ID")
	private String policyCertifId;
	@Column(name = "POLICY_FLEET_ID")
	private String policyFleetID;

	public String getPolicyCertifId() {
		return policyCertifId;
	}

	public void setPolicyCertifId(String policyCertifId) {
		this.policyCertifId = policyCertifId;
	}

	public String getPolicyFleetID() {
		return policyFleetID;
	}

	public void setPolicyFleetID(String policyFleetID) {
		this.policyFleetID = policyFleetID;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getDefaultCoverCode() {
		return defaultCoverCode;
	}

	public void setDefaultCoverCode(String defaultCoverCode) {
		this.defaultCoverCode = defaultCoverCode;
	}

	public String getDefaultRiskType() {
		return defaultRiskType;
	}

	public void setDefaultRiskType(String defaultRiskType) {
		this.defaultRiskType = defaultRiskType;
	}

	public String getAccidentLocationDistrict() {
		return accidentLocationDistrict;
	}

	public void setAccidentLocationDistrict(String accidentLocationDistrict) {
		this.accidentLocationDistrict = accidentLocationDistrict;
	}

	public String getAccidentLocationCAZA() {
		return accidentLocationCAZA;
	}

	public void setAccidentLocationCAZA(String accidentLocationCAZA) {
		this.accidentLocationCAZA = accidentLocationCAZA;
	}
	/*
	 * public String toString() { return ToStringBuilder.reflectionToString(this,
	 * ToStringStyle.MULTI_LINE_STYLE); }
	 */

	public String getDtId() {
		return dtId;
	}

	public void setDtId(String dtId) {
		this.dtId = dtId;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public String getClaimNum() {
		return claimNum;
	}

	public void setClaimNum(String claimNum) {
		this.claimNum = claimNum;
	}

	public String getPolicySerie() {
		return policySerie;
	}

	public void setPolicySerie(String policySerie) {
		this.policySerie = policySerie;
	}

	public String getVehicleSerie() {
		return vehicleSerie;
	}

	public void setVehicleSerie(String vehicleSerie) {
		this.vehicleSerie = vehicleSerie;
	}

	public String getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(String accidentDate) {
		this.accidentDate = accidentDate;
	}

	public String getReportedDate() {
		return reportedDate;
	}

	public void setReportedDate(String reportedDate) {
		this.reportedDate = reportedDate;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}

	public String getAccidentLongitude() {
		return accidentLongitude;
	}

	public void setAccidentLongitude(String accidentLongitude) {
		this.accidentLongitude = accidentLongitude;
	}

	public String getAccidentLatitude() {
		return accidentLatitude;
	}

	public void setAccidentLatitude(String accidentLatitude) {
		this.accidentLatitude = accidentLatitude;
	}

	public String getAccidentLocation() {
		return accidentLocation;
	}

	public void setAccidentLocation(String accidentLocation) {
		this.accidentLocation = accidentLocation;
	}

	public String getClaimReason() {
		return claimReason;
	}

	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}

	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public String getRelatedNotification() {
		return relatedNotification;
	}

	public void setRelatedNotification(String relatedNotification) {
		this.relatedNotification = relatedNotification;
	}

	public String getReserveAmountUsd() {
		return reserveAmountUsd;
	}

	public void setReserveAmountUsd(String reserveAmountUsd) {
		this.reserveAmountUsd = reserveAmountUsd;
	}

	public String getTotalPaidUsd() {
		return totalPaidUsd;
	}

	public void setTotalPaidUsd(String totalPaidUsd) {
		this.totalPaidUsd = totalPaidUsd;
	}

	public String getExpertName() {
		return expertName;
	}

	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}

	public String getExpertCode() {
		return expertCode;
	}

	public void setExpertCode(String expertCode) {
		this.expertCode = expertCode;
	}

	public String getReserveDifference() {
		return reserveDifference;
	}

	public void setReserveDifference(String reserveDifference) {
		this.reserveDifference = reserveDifference;
	}

	public String getPolicyId() {
		return policyId;
	}

	public String getAccidentTime() {
		return accidentTime;
	}

	public void setAccidentTime(String accidentTime) {
		this.accidentTime = accidentTime;
	}

	public String getReportedTime() {
		return reportedTime;
	}

	public void setReportedTime(String reportedTime) {
		this.reportedTime = reportedTime;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
}