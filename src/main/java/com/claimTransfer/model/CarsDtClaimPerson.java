package com.claimTransfer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARS_DT_CLAIM_PERSON")
public class CarsDtClaimPerson {

//	sequence
	@Id
	@Column(name= "DT_ID")
	private String dtId;
	
	@Column(name = "VEH_SEQ")
	private String vehSeq;
	
	@Column(name = "OWNER_FAMILY_NAME")
	private String ownerFamilyName;
	
	@Column(name = "OWNER_FATHER_NAME")
	private String ownerFatherName;
	
	@Column(name = "OWNER_FISRT_NAME")
	private String ownerFirstName;
	
	@Column(name= "DRIVER_FAMILY_NAME")
	private String driverFamilyName;
	
	@Column(name= "DRIVER_FATHER_NAME")
	private String driverFatherName;
	
	@Column(name = "DRIVER_FISRT_NAME")
	private String driverFirstName;
	
	@Column(name ="DRIVER_PHONE")
	private String driverPhone;
	
	@Column(name = "GENDER")
	private String  gender;
	
	@Column(name = "DOB")
	private String dob;
	
	@Column(name ="MAKE_CODE")
	private String makeCode;
	
	@Column(name = "MODEL_CODE")
	private String modelCode;
	
	@Column(name ="VEHICLE_YEAR")
	private String vehicleYear;
	
	@Column(name ="TP_COMPANY_CODE")
	private String tpCompanyCode;
	
	@Column(name= "TP_COMPANY_NAME")
	private String tpCompanyName;
	
	@Column(name ="SCRIPT_NAME")
	private String scriptName;
	
	@Column(name ="NOTIFICATION")
	private String notification;
	
	@Column(name ="LICENSE_NO")
	private String licenseNo;
	
	@Column(name ="LIC_EXPIRY_DATE")
	private String licExpiryDate;
	
	@Column(name ="LICENSE_TYPE")
	private String licenseType;
	
	@Column(name ="LIC_INCEPTION_DATE")
	private String licInceptionDate;
	
	
//	@Column (name = "REPOSITORY")
//	private String repository;
//	
//	@Column (name = "PLATE_PREFIX")
//	private String platePrefix;
//	
//	@Column(name = "PLATE_NUMBER")
//	private String plateNumber;

	
	public String getDtId() {
		return dtId;
	}

	public void setDtId(String dtId) {
		this.dtId = dtId;
	}
	
	public String getVehSeq() {
		return vehSeq;
	}


	public void setVehSeq(String vehSeq) {
		this.vehSeq = vehSeq;
	}

	public String getOwnerFamilyName() {
		return ownerFamilyName;
	}

	public void setOwnerFamilyName(String ownerFamilyName) {
		this.ownerFamilyName = ownerFamilyName;
	}

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public String getDriverFamilyName() {
		return driverFamilyName;
	}

	public void setDriverFamilyName(String driverFamilyName) {
		this.driverFamilyName = driverFamilyName;
	}

	public String getDriverFirstName() {
		return driverFirstName;
	}

	public void setDriverFirstName(String driverFirstName) {
		this.driverFirstName = driverFirstName;
	}

	public String getDriverPhone() {
		return driverPhone;
	}

	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMakeCode() {
		return makeCode;
	}

	public void setMakeCode(String makeCode) {
		this.makeCode = makeCode;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getVehicleYear() {
		return vehicleYear;
	}

	public void setVehicleYear(String vehicleYear) {
		this.vehicleYear = vehicleYear;
	}

	public String getTpCompanyCode() {
		return tpCompanyCode;
	}

	public void setTpCompanyCode(String tpCompanyCode) {
		this.tpCompanyCode = tpCompanyCode;
	}

	public String getTpCompanyName() {
		return tpCompanyName;
	}

	public void setTpCompanyName(String tpCompanyName) {
		this.tpCompanyName = tpCompanyName;
	}

	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public String getOwnerFatherName() {
		return ownerFatherName;
	}

	public void setOwnerFatherName(String ownerFatherName) {
		this.ownerFatherName = ownerFatherName;
	}

	public String getDriverFatherName() {
		return driverFatherName;
	}

	public void setDriverFatherName(String driverFatherName) {
		this.driverFatherName = driverFatherName;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getLicExpiryDate() {
		return licExpiryDate;
	}

	public void setLicExpiryDate(String licExpiryDate) {
		this.licExpiryDate = licExpiryDate;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public String getLicInceptionDate() {
		return licInceptionDate;
	}

	public void setLicInceptionDate(String licInceptionDate) {
		this.licInceptionDate = licInceptionDate;
	}


	@Override
	public String toString() {
		return "CarsDtClaimPerson{" +
				"dtId='" + dtId + '\'' +
				", vehSeq='" + vehSeq + '\'' +
				", ownerFamilyName='" + ownerFamilyName + '\'' +
				", ownerFatherName='" + ownerFatherName + '\'' +
				", ownerFirstName='" + ownerFirstName + '\'' +
				", driverFamilyName='" + driverFamilyName + '\'' +
				", driverFatherName='" + driverFatherName + '\'' +
				", driverFirstName='" + driverFirstName + '\'' +
				", driverPhone='" + driverPhone + '\'' +
				", gender='" + gender + '\'' +
				", dob='" + dob + '\'' +
				", makeCode='" + makeCode + '\'' +
				", modelCode='" + modelCode + '\'' +
				", vehicleYear='" + vehicleYear + '\'' +
				", tpCompanyCode='" + tpCompanyCode + '\'' +
				", tpCompanyName='" + tpCompanyName + '\'' +
				", scriptName='" + scriptName + '\'' +
				", notification='" + notification + '\'' +
				", licenseNo='" + licenseNo + '\'' +
				", licExpiryDate='" + licExpiryDate + '\'' +
				", licenseType='" + licenseType + '\'' +
				", licInceptionDate='" + licInceptionDate + '\'' +
				'}';
	}
}